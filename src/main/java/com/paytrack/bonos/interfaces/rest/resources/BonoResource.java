package com.paytrack.bonos.interfaces.rest.resources;

import com.paytrack.bonos.domain.model.valueobjects.FrecuenciaPago;
import com.paytrack.bonos.domain.model.valueobjects.PeriodoTiempo;
import com.paytrack.bonos.domain.model.valueobjects.TipoMoneda;
import com.paytrack.bonos.domain.model.valueobjects.TipoPlazoGracia;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BonoResource(
        Long id,
        Long usuarioId,
        BigDecimal precioVentaMonto,
        TipoMoneda precioVentaMoneda,
        BigDecimal porcentajeCuotaInicial,
        BigDecimal prestamoMonto,
        TipoMoneda prestamoMoneda,
        FrecuenciaPago frecuenciaPago,
        int plazoValor,
        PeriodoTiempo.UnidadTiempo plazoUnidad,
        BigDecimal tea,
        int numeroPeriodos,
        TipoPlazoGracia tipoPlazoGracia,
        int duracionGraciaValor,
        PeriodoTiempo.UnidadTiempo duracionGraciaUnidad,
        LocalDate fechaInicio
) {
}
