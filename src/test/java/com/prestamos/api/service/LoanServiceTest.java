package com.prestamos.api.service;

import com.prestamos.api.exception.LoanValidationException;
import com.prestamos.api.model.dto.LoanRequest;
import com.prestamos.api.model.dto.LoanResponse;
import com.prestamos.api.model.entity.Loan;
import com.prestamos.api.repository.LoanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoanServiceTest {

    @Mock
    private LoanRepository loanRepository;

    @InjectMocks
    private LoanServiceImpl loanService;

    private UUID loanId;
    private LoanRequest loanRequest;
    private Loan loan;

    @BeforeEach
    void setUp() {
        loanId = UUID.randomUUID();
        loanRequest = new LoanRequest();
        loanRequest.setAmount(new BigDecimal("10000.00"));
        loanRequest.setInterestRate(new BigDecimal("12.5"));
        loanRequest.setTerm(12);

        loan = new Loan();
        loan.setId(loanId);
        loan.setAmount(new BigDecimal("10000.00"));
        loan.setInterestRate(new BigDecimal("12.5"));
        loan.setTerm(12);
        loan.setCreationDate(LocalDate.now());
        loan.setDueDate(LocalDate.now().plusMonths(12));
    }

    @Test
    @DisplayName("Crear préstamo - caso exitoso")
    void testCreateLoan_Success() {
        when(loanRepository.save(any(Loan.class))).thenReturn(loan);

        LoanResponse result = loanService.createLoan(loanRequest);

        assertNotNull(result);
        assertEquals(loanId, result.getId());
        assertEquals(new BigDecimal("10000.00"), result.getAmount());
        assertEquals(new BigDecimal("12.5"), result.getInterestRate());
        assertEquals(12, result.getTerm());
        verify(loanRepository, times(1)).save(any(Loan.class));
    }

    @Test
    @DisplayName("Crear préstamo - monto negativo lanza excepción")
    void testCreateLoan_NegativeAmount_ThrowsException() {
        LoanRequest invalidRequest = new LoanRequest();
        invalidRequest.setAmount(new BigDecimal("-1000"));
        invalidRequest.setInterestRate(new BigDecimal("10"));
        invalidRequest.setTerm(12);

        LoanValidationException exception = assertThrows(
                LoanValidationException.class,
                () -> loanService.createLoan(invalidRequest)
        );

        assertEquals("El monto debe ser positivo", exception.getMessage());
        verify(loanRepository, never()).save(any(Loan.class));
    }

    @Test
    @DisplayName("Crear préstamo - monto cero lanza excepción")
    void testCreateLoan_ZeroAmount_ThrowsException() {
        LoanRequest invalidRequest = new LoanRequest();
        invalidRequest.setAmount(BigDecimal.ZERO);
        invalidRequest.setInterestRate(new BigDecimal("10"));
        invalidRequest.setTerm(12);

        LoanValidationException exception = assertThrows(
                LoanValidationException.class,
                () -> loanService.createLoan(invalidRequest)
        );

        assertEquals("El monto debe ser positivo", exception.getMessage());
        verify(loanRepository, never()).save(any(Loan.class));
    }

    @Test
    @DisplayName("Crear préstamo - tasa de interés negativa lanza excepción")
    void testCreateLoan_NegativeInterestRate_ThrowsException() {
        LoanRequest invalidRequest = new LoanRequest();
        invalidRequest.setAmount(new BigDecimal("1000"));
        invalidRequest.setInterestRate(new BigDecimal("-5"));
        invalidRequest.setTerm(12);

        LoanValidationException exception = assertThrows(
                LoanValidationException.class,
                () -> loanService.createLoan(invalidRequest)
        );

        assertEquals("La tasa de interés debe estar entre 0 y 100", exception.getMessage());
        verify(loanRepository, never()).save(any(Loan.class));
    }

    @Test
    @DisplayName("Crear préstamo - tasa de interés mayor a 100 lanza excepción")
    void testCreateLoan_InterestRateOver100_ThrowsException() {
        LoanRequest invalidRequest = new LoanRequest();
        invalidRequest.setAmount(new BigDecimal("1000"));
        invalidRequest.setInterestRate(new BigDecimal("150"));
        invalidRequest.setTerm(12);

        LoanValidationException exception = assertThrows(
                LoanValidationException.class,
                () -> loanService.createLoan(invalidRequest)
        );

        assertEquals("La tasa de interés debe estar entre 0 y 100", exception.getMessage());
        verify(loanRepository, never()).save(any(Loan.class));
    }

    @Test
    @DisplayName("Crear préstamo - plazo cero lanza excepción")
    void testCreateLoan_ZeroTerm_ThrowsException() {
        LoanRequest invalidRequest = new LoanRequest();
        invalidRequest.setAmount(new BigDecimal("1000"));
        invalidRequest.setInterestRate(new BigDecimal("10"));
        invalidRequest.setTerm(0);

        LoanValidationException exception = assertThrows(
                LoanValidationException.class,
                () -> loanService.createLoan(invalidRequest)
        );

        assertEquals("El plazo debe ser un número entero positivo", exception.getMessage());
        verify(loanRepository, never()).save(any(Loan.class));
    }

    @Test
    @DisplayName("Crear préstamo - plazo negativo lanza excepción")
    void testCreateLoan_NegativeTerm_ThrowsException() {
        LoanRequest invalidRequest = new LoanRequest();
        invalidRequest.setAmount(new BigDecimal("1000"));
        invalidRequest.setInterestRate(new BigDecimal("10"));
        invalidRequest.setTerm(-6);

        LoanValidationException exception = assertThrows(
                LoanValidationException.class,
                () -> loanService.createLoan(invalidRequest)
        );

        assertEquals("El plazo debe ser un número entero positivo", exception.getMessage());
        verify(loanRepository, never()).save(any(Loan.class));
    }

    @Test
    @DisplayName("Obtener préstamo por ID - caso exitoso")
    void testGetLoanById_Success() {
        when(loanRepository.findById(loanId)).thenReturn(Optional.of(loan));

        Optional<LoanResponse> result = loanService.getLoanById(loanId);

        assertTrue(result.isPresent());
        assertEquals(loanId, result.get().getId());
        verify(loanRepository, times(1)).findById(loanId);
    }

    @Test
    @DisplayName("Obtener préstamo por ID - no encontrado")
    void testGetLoanById_NotFound() {
        when(loanRepository.findById(loanId)).thenReturn(Optional.empty());

        Optional<LoanResponse> result = loanService.getLoanById(loanId);

        assertFalse(result.isPresent());
        verify(loanRepository, times(1)).findById(loanId);
    }

    @Test
    @DisplayName("Listar todos los préstamos - caso exitoso")
    void testGetAllLoans_Success() {
        when(loanRepository.findAll()).thenReturn(List.of(loan));

        List<LoanResponse> results = loanService.getAllLoans();

        assertNotNull(results);
        assertEquals(1, results.size());
        assertEquals(loanId, results.get(0).getId());
        verify(loanRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Listar todos los préstamos - lista vacía")
    void testGetAllLoans_EmptyList() {
        when(loanRepository.findAll()).thenReturn(List.of());

        List<LoanResponse> results = loanService.getAllLoans();

        assertNotNull(results);
        assertTrue(results.isEmpty());
        verify(loanRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Actualizar préstamo - caso exitoso")
    void testUpdateLoan_Success() {
        when(loanRepository.findById(loanId)).thenReturn(Optional.of(loan));
        when(loanRepository.save(any(Loan.class))).thenReturn(loan);

        Optional<LoanResponse> result = loanService.updateLoan(loanId, loanRequest);

        assertTrue(result.isPresent());
        assertEquals(loanId, result.get().getId());
        verify(loanRepository, times(1)).findById(loanId);
        verify(loanRepository, times(1)).save(any(Loan.class));
    }

    @Test
    @DisplayName("Actualizar préstamo - no encontrado")
    void testUpdateLoan_NotFound() {
        when(loanRepository.findById(loanId)).thenReturn(Optional.empty());

        Optional<LoanResponse> result = loanService.updateLoan(loanId, loanRequest);

        assertFalse(result.isPresent());
        verify(loanRepository, times(1)).findById(loanId);
        verify(loanRepository, never()).save(any(Loan.class));
    }

    @Test
    @DisplayName("Eliminar préstamo - caso exitoso")
    void testDeleteLoan_Success() {
        doNothing().when(loanRepository).deleteById(loanId);

        loanService.deleteLoan(loanId);

        verify(loanRepository, times(1)).deleteById(loanId);
    }

    @Test
    @DisplayName("Validar que la fecha de vencimiento se calcula correctamente")
    void testDueDateCalculation() {
        when(loanRepository.save(any(Loan.class))).thenAnswer(invocation -> {
            Loan savedLoan = invocation.getArgument(0);
            savedLoan.setId(loanId);
            savedLoan.setCreationDate(LocalDate.now());
            return savedLoan;
        });

        LoanResponse result = loanService.createLoan(loanRequest);

        assertNotNull(result.getDueDate());
        assertEquals(result.getCreationDate().plusMonths(12), result.getDueDate());
    }

    @Test
    @DisplayName("Verificar que se guarda la entidad con los valores correctos")
    void testSaveLoanWithCorrectValues() {
        when(loanRepository.save(any(Loan.class))).thenReturn(loan);

        loanService.createLoan(loanRequest);

        ArgumentCaptor<Loan> loanCaptor = ArgumentCaptor.forClass(Loan.class);
        verify(loanRepository).save(loanCaptor.capture());

        Loan savedLoan = loanCaptor.getValue();
        assertEquals(new BigDecimal("10000.00"), savedLoan.getAmount());
        assertEquals(new BigDecimal("12.5"), savedLoan.getInterestRate());
        assertEquals(12, savedLoan.getTerm());
    }
}