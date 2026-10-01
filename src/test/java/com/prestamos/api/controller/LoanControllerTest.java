package com.prestamos.api.controller;


import com.prestamos.api.exception.LoanValidationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prestamos.api.model.dto.LoanRequest;
import com.prestamos.api.model.dto.LoanResponse;
import com.prestamos.api.service.LoanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LoanController.class)
class LoanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private LoanService loanService;

    private UUID loanId;
    private LoanRequest loanRequest;
    private LoanResponse loanResponse;

    @BeforeEach
    void setUp() {
        loanId = UUID.randomUUID();
        loanRequest = new LoanRequest();
        loanRequest.setAmount(new BigDecimal("10000.00"));
        loanRequest.setInterestRate(new BigDecimal("12.5"));
        loanRequest.setTerm(12);

        loanResponse = new LoanResponse();
        loanResponse.setId(loanId);
        loanResponse.setAmount(new BigDecimal("10000.00"));
        loanResponse.setInterestRate(new BigDecimal("12.5"));
        loanResponse.setTerm(12);
        loanResponse.setCreationDate(LocalDate.now());
        loanResponse.setDueDate(LocalDate.now().plusMonths(12));
    }

    @Test
    @DisplayName("Crear préstamo - caso exitoso")
    void testCreateLoan_Success() throws Exception {
        when(loanService.createLoan(any(LoanRequest.class))).thenReturn(loanResponse);

        ResultActions result = mockMvc.perform(post("/api/loans")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loanRequest)));

        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(loanId.toString()))
                .andExpect(jsonPath("$.amount").value(10000.00))
                .andExpect(jsonPath("$.interestRate").value(12.5))
                .andExpect(jsonPath("$.term").value(12));
    }

    @Test
    @DisplayName("Obtener préstamo por ID - caso exitoso")
    void testGetLoanById_Success() throws Exception {
        when(loanService.getLoanById(loanId)).thenReturn(Optional.of(loanResponse));

        ResultActions result = mockMvc.perform(get("/api/loans/{id}", loanId));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(loanId.toString()))
                .andExpect(jsonPath("$.amount").value(10000.00));
    }

    @Test
    @DisplayName("Obtener préstamo por ID - no encontrado")
    void testGetLoanById_NotFound() throws Exception {
        when(loanService.getLoanById(loanId)).thenReturn(Optional.empty());

        ResultActions result = mockMvc.perform(get("/api/loans/{id}", loanId));

        result.andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Listar todos los préstamos - caso exitoso")
    void testGetAllLoans_Success() throws Exception {
        when(loanService.getAllLoans()).thenReturn(java.util.List.of(loanResponse));

        ResultActions result = mockMvc.perform(get("/api/loans"));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value(loanId.toString()));
    }

    @Test
    @DisplayName("Actualizar préstamo - caso exitoso")
    void testUpdateLoan_Success() throws Exception {
        when(loanService.updateLoan(eq(loanId), any(LoanRequest.class))).thenReturn(Optional.of(loanResponse));

        ResultActions result = mockMvc.perform(put("/api/loans/{id}", loanId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loanRequest)));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(loanId.toString()));
    }

    @Test
    @DisplayName("Eliminar préstamo - caso exitoso")
    void testDeleteLoan_Success() throws Exception {
        doNothing().when(loanService).deleteLoan(loanId);

        ResultActions result = mockMvc.perform(delete("/api/loans/{id}", loanId));

        result.andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Crear préstamo con monto inválido - bad request")
    void testCreateLoan_InvalidAmount() throws Exception {
        LoanRequest invalidRequest = new LoanRequest();
        invalidRequest.setAmount(new BigDecimal("-1000"));
        invalidRequest.setInterestRate(new BigDecimal("10"));
        invalidRequest.setTerm(12);

        when(loanService.createLoan(any(LoanRequest.class)))
                .thenThrow(new com.prestamos.api.exception.LoanValidationException("El monto debe ser positivo"));

        ResultActions result = mockMvc.perform(post("/api/loans")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidRequest)));

        result.andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Crear préstamo con tasa de interés inválida - bad request")
    void testCreateLoan_InvalidInterestRate() throws Exception {
        LoanRequest invalidRequest = new LoanRequest();
        invalidRequest.setAmount(new BigDecimal("1000"));
        invalidRequest.setInterestRate(new BigDecimal("150"));
        invalidRequest.setTerm(12);

        when(loanService.createLoan(any(LoanRequest.class)))
                .thenThrow(new com.prestamos.api.exception.LoanValidationException("La tasa de interés debe estar entre 0 y 100"));

        ResultActions result = mockMvc.perform(post("/api/loans")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidRequest)));

        result.andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Crear préstamo con plazo inválido - bad request")
    void testCreateLoan_InvalidTerm() throws Exception {
        LoanRequest invalidRequest = new LoanRequest();
        invalidRequest.setAmount(new BigDecimal("1000"));
        invalidRequest.setInterestRate(new BigDecimal("10"));
        invalidRequest.setTerm(0);

        when(loanService.createLoan(any(LoanRequest.class)))
                .thenThrow(new com.prestamos.api.exception.LoanValidationException("El plazo debe ser un número entero positivo"));

        ResultActions result = mockMvc.perform(post("/api/loans")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidRequest)));

        result.andExpect(status().isBadRequest());
    }
}