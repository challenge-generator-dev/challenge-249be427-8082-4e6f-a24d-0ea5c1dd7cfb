package com.prestamos.api.service;

import com.prestamos.api.exception.LoanValidationException;
import com.prestamos.api.model.dto.LoanRequest;
import com.prestamos.api.model.dto.LoanResponse;
import com.prestamos.api.model.entity.Loan;
import com.prestamos.api.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public LoanResponse saveLoan(LoanRequest request) {
        validateLoanRequest(request);
        
        Loan loan = new Loan();
        loan.setId(UUID.randomUUID());
        loan.setAmount(request.getAmount().setScale(2, RoundingMode.HALF_UP));
        loan.setInterestRate(request.getInterestRate().setScale(2, RoundingMode.HALF_UP));
        loan.setTerm(request.getTerm());
        loan.setCreationDate(LocalDate.now());
        loan.setDueDate(LocalDate.now().plusMonths(request.getTerm()));
        
        Loan savedLoan = loanRepository.save(loan);
        return mapToResponse(savedLoan);
    }

    @Override
    public Optional<LoanResponse> getLoanById(UUID id) {
        if (id == null) {
            throw new LoanValidationException(
                "El ID del préstamo no puede ser nulo",
                "INVALID_ID",
                "id",
                null
            );
        }
        return loanRepository.findById(id).map(this::mapToResponse);
    }

    @Override
    public List<LoanResponse> getAllLoans() {
        return loanRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public LoanResponse updateLoan(UUID id, LoanRequest request) {
        Optional<Loan> existingLoan = loanRepository.findById(id);
        if (existingLoan.isEmpty()) {
            throw new LoanValidationException(
                "Préstamo no encontrado con ID: " + id,
                "LOAN_NOT_FOUND",
                "id",
                id
            );
        }
        
        validateLoanRequest(request);
        
        Loan loan = existingLoan.get();
        loan.setAmount(request.getAmount().setScale(2, RoundingMode.HALF_UP));
        loan.setInterestRate(request.getInterestRate().setScale(2, RoundingMode.HALF_UP));
        loan.setTerm(request.getTerm());
        loan.setDueDate(LocalDate.now().plusMonths(request.getTerm()));
        
        Loan updatedLoan = loanRepository.save(loan);
        return mapToResponse(updatedLoan);
    }

    @Override
    public void deleteLoan(UUID id) {
        if (id == null) {
            throw new LoanValidationException(
                "El ID del préstamo no puede ser nulo",
                "INVALID_ID",
                "id",
                null
            );
        }
        
        Optional<Loan> existingLoan = loanRepository.findById(id);
        if (existingLoan.isEmpty()) {
            throw new LoanValidationException(
                "Préstamo no encontrado con ID: " + id,
                "LOAN_NOT_FOUND",
                "id",
                id
            );
        }
        
        loanRepository.deleteById(id);
    }

    private void validateLoanRequest(LoanRequest request) {
        if (request.getAmount() == null) {
            throw new LoanValidationException(
                "El monto del préstamo es obligatorio",
                "MISSING_AMOUNT",
                "amount",
                null
            );
        }
        
        if (request.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new LoanValidationException(
                "El monto del préstamo debe ser positivo",
                "INVALID_AMOUNT",
                "amount",
                request.getAmount()
            );
        }
        
        if (request.getAmount().compareTo(new BigDecimal("1000000")) > 0) {
            throw new LoanValidationException(
                "El monto del préstamo no puede exceder 1,000,000",
                "AMOUNT_TOO_LARGE",
                "amount",
                request.getAmount()
            );
        }
        
        if (request.getInterestRate() == null) {
            throw new LoanValidationException(
                "La tasa de interés es obligatoria",
                "MISSING_INTEREST_RATE",
                "interestRate",
                null
            );
        }
        
        if (request.getInterestRate().compareTo(BigDecimal.ZERO) < 0 || 
            request.getInterestRate().compareTo(new BigDecimal("100")) > 0) {
            throw new LoanValidationException(
                "La tasa de interés debe estar entre 0 y 100",
                "INVALID_INTEREST_RATE",
                "interestRate",
                request.getInterestRate()
            );
        }
        
        if (request.getTerm() == null) {
            throw new LoanValidationException(
                "El plazo del préstamo es obligatorio",
                "MISSING_TERM",
                "term",
                null
            );
        }
        
        if (request.getTerm() <= 0) {
            throw new LoanValidationException(
                "El plazo del préstamo debe ser un número entero positivo",
                "INVALID_TERM",
                "term",
                request.getTerm()
            );
        }
        
        if (request.getTerm() > 360) {
            throw new LoanValidationException(
                "El plazo del préstamo no puede exceder 360 meses",
                "TERM_TOO_LARGE",
                "term",
                request.getTerm()
            );
        }
    }

    private LoanResponse mapToResponse(Loan loan) {
        LoanResponse response = new LoanResponse();
        response.setId(loan.getId());
        response.setAmount(loan.getAmount());
        response.setInterestRate(loan.getInterestRate());
        response.setTerm(loan.getTerm());
        response.setCreationDate(loan.getCreationDate());
        response.setDueDate(loan.getDueDate());
        return response;
    }
}