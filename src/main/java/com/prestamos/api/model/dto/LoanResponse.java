package com.prestamos.api.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Schema(description = "DTO para la respuesta de préstamos")
public class LoanResponse {
    @Schema(description = "Identificador único del préstamo", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @Schema(description = "Monto del préstamo", example = "1000.00")
    private BigDecimal amount;

    @Schema(description = "Tasa de interés del préstamo", example = "5.5")
    private BigDecimal interestRate;

    @Schema(description = "Plazo del préstamo en meses", example = "12")
    private Integer term;

    @Schema(description = "Fecha de creación del préstamo", example = "2023-10-01")
    private LocalDate creationDate;

    @Schema(description = "Fecha de vencimiento del préstamo", example = "2024-10-01")
    private LocalDate dueDate;
}