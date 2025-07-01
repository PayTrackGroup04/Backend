package com.paytrack.bonos.domain.model.commands;

import com.paytrack.bonos.domain.model.valueobjects.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CrearBonoCommand(
        Long usuarioId,
        BigDecimal valorNominal,
        BigDecimal tasaCupon,
        TipoTasa tipoTasa,
        Capitalizacion capitalizacion,
        FrecuenciaPago frecuenciaPago,
        int plazoAnios,
        int graciaTotal,
        int graciaParcial,
        LocalDate fechaEmision,
        int numeroDiasPorAno,
        BigDecimal cavali,
        BigDecimal estructuracion,
        BigDecimal colocacion,
        MetodoAmortizacion metodoAmortizacion,
        TipoMoneda moneda
) {
    public CrearBonoCommand {
        if (usuarioId == null || usuarioId <= 0) throw new IllegalArgumentException("Usuario inválido");
        if (valorNominal == null || tasaCupon == null || moneda == null) throw new IllegalArgumentException("Valores clave no pueden ser nulos");
    }
}
