package com.paytrack.bonos.interfaces.rest.resources;

import com.paytrack.bonos.domain.model.valueobjects.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ActualizarBonoResource(
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
) {}
