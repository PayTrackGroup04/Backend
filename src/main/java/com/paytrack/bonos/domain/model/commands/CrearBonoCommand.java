package com.paytrack.bonos.domain.model.commands;

import com.paytrack.bonos.domain.model.valueobjects.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CrearBonoCommand(Dinero precioVenta, BigDecimal porcentajeCuotaInicial, Dinero prestamo, FrecuenciaPago frecuenciaPago, PeriodoTiempo plazo, TasaInteres tea, int numeroPeriodos, PlazoGracia plazoGracia, LocalDate fechaInicio, Long usuarioId) {

    public CrearBonoCommand {
        if (precioVenta == null || porcentajeCuotaInicial == null || prestamo == null ||
                frecuenciaPago == null || plazo == null || tea == null ||
                plazoGracia == null || fechaInicio == null) {
            throw new IllegalArgumentException("Ninguno de los campos puede ser nulo");
        }

        if (porcentajeCuotaInicial.compareTo(BigDecimal.ZERO) < 0 ||
                porcentajeCuotaInicial.compareTo(BigDecimal.ONE) > 0) {
            throw new IllegalArgumentException("El porcentaje de cuota inicial debe estar entre 0 y 1");
        }

        if (numeroPeriodos <= 0) {
            throw new IllegalArgumentException("El número de periodos debe ser mayor que 0");
        }

        if (usuarioId == null || usuarioId <= 0) {
            throw new IllegalArgumentException("usuarioId inválido");
        }
    }

}
