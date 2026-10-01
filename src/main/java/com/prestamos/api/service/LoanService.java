package com.prestamos.api.service;

import com.prestamos.api.model.dto.LoanRequest;
import com.prestamos.api.model.dto.LoanResponse;
import java.util.List;
import java.util.UUID;

public interface LoanService {

    LoanResponse createLoan(LoanRequest request);

    LoanResponse getLoanById(UUID id);

    List<LoanResponse> getAllLoans();

    LoanResponse updateLoan(UUID id, LoanRequest request);

    void deleteLoan(UUID id);
}