package com.prestamos.api.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "loans")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "El monto del préstamo es obligatorio")
    @Positive(message = "El monto debe ser mayor que cero")
    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;

    @NotNull(message = "La tasa de interés es obligatoria")
    @DecimalMin(value = "0.0", message = "La tasa de interés no puede ser menor a 0")
    @DecimalMax(value = "100.0", message = "La tasa de interés no puede ser mayor a 100")
    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal interestRate;

    @NotNull(message = "El plazo es obligatorio")
    @Min(value = 1, message = "El plazo debe ser al menos 1 mes")
    @Column(nullable = false)
    private Integer term;

    @Column(nullable = false)
    private LocalDate creationDate;

    @Column(nullable = false)
    private LocalDate dueDate;

    @PrePersist
    protected void onCreate() {
        creationDate = LocalDate.now();
        dueDate = creationDate.plusMonths(term);
    }

    public void updateFromRequest(BigDecimal newAmount, BigDecimal newInterestRate, Integer newTerm) {
        this.amount = newAmount;
        this.interestRate = newInterestRate;
        this.term = newTerm;
        this.dueDate = this.creationDate.plusMonths(this.term);
    }
}