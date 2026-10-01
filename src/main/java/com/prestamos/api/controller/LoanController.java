package com.prestamos.api.controller;

import com.prestamos.api.model.dto.LoanRequest;
import com.prestamos.api.model.dto.LoanResponse;
import com.prestamos.api.service.LoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/loans")
@Tag(name = "Gestión de Préstamos", description = "API REST para la gestión de solicitudes de préstamos")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @Operation(summary = "Crear un nuevo préstamo", description = "Registra una nueva solicitud de préstamo en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Préstamo creado exitosamente",
                     content = @Content(schema = @Schema(implementation = LoanResponse.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos",
                     content = @Content(schema = @Schema(implementation = Error.class))),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                     content = @Content(schema = @Schema(implementation = Error.class)))
    })
    @PostMapping
    public ResponseEntity<LoanResponse> createLoan(
            @Valid @RequestBody LoanRequest request) {
        LoanResponse created = loanService.createLoan(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Operation(summary = "Obtener un préstamo por ID", description = "Recupera los detalles de un préstamo específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Préstamo encontrado",
                     content = @Content(schema = @Schema(implementation = LoanResponse.class))),
        @ApiResponse(responseCode = "404", description = "Préstamo no encontrado",
                     content = @Content(schema = @Schema(implementation = Error.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<LoanResponse> getLoanById(
            @Parameter(description = "UUID del préstamo", required = true) @PathVariable UUID id) {
        LoanResponse loan = loanService.getLoanById(id);
        return ResponseEntity.ok(loan);
    }

    @Operation(summary = "Listar todos los préstamos", description = "Obtiene una lista de todos los préstamos registrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de préstamos obtenida exitosamente",
                     content = @Content(schema = @Schema(implementation = LoanResponse.class)))
    })
    @GetMapping
    public ResponseEntity<List<LoanResponse>> getAllLoans() {
        List<LoanResponse> loans = loanService.getAllLoans();
        return ResponseEntity.ok(loans);
    }

    @Operation(summary = "Actualizar un préstamo", description = "Modifica los datos de un préstamo existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Préstamo actualizado exitosamente",
                     content = @Content(schema = @Schema(implementation = LoanResponse.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos",
                     content = @Content(schema = @Schema(implementation = Error.class))),
        @ApiResponse(responseCode = "404", description = "Préstamo no encontrado",
                     content = @Content(schema = @Schema(implementation = Error.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<LoanResponse> updateLoan(
            @Parameter(description = "UUID del préstamo", required = true) @PathVariable UUID id,
            @Valid @RequestBody LoanRequest request) {
        LoanResponse updated = loanService.updateLoan(id, request);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Eliminar un préstamo", description = "Elimina un préstamo del sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Préstamo eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Préstamo no encontrado",
                     content = @Content(schema = @Schema(implementation = Error.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(
            @Parameter(description = "UUID del préstamo", required = true) @PathVariable UUID id) {
        loanService.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }
}