package com.prestamos.api.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(description = "DTO para la creación y actualización de préstamos")
public class LoanRequest {
    @NotNull(message = "El monto no puede ser nulo")
    @Positive(message = "El monto debe ser positivo")
    @Schema(description = "Monto del préstamo", example = "1000.00")
    private BigDecimal amount;

    @NotNull(message = "La tasa de interés no puede ser nula")
    @DecimalMin(value = "0.0", message = "La tasa de interés debe ser mayor o igual a 0")
    @DecimalMax(value = "100.0", message = "La tasa de interés debe ser menor o igual a 100")
    @Schema(description = "Tasa de interés del préstamo", example = "5.5")
    private BigDecimal interestRate;

    @NotNull(message = "El plazo no puede ser nulo")
    @Min(value = 1, message = "El plazo debe ser al menos 1")
    @Schema(description = "Plazo del préstamo en meses", example = "12")
    private Integer term;
}