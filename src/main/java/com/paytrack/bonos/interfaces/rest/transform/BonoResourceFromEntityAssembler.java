package com.paytrack.bonos.interfaces.rest.transform;

import com.paytrack.bonos.domain.model.aggregates.Bono;
import com.paytrack.bonos.interfaces.rest.resources.BonoResource;

public class BonoResourceFromEntityAssembler {
    public static BonoResource toResourceFromEntity(Bono bono) {
        return new BonoResource(
                bono.getId(),
                bono.getUsuarioId(),
                bono.getPrecioVenta().getMonto(),
                bono.getPrecioVenta().getMoneda(),
                bono.getPorcentajeCuotaInicial(),
                bono.getPrestamo().getMonto(),
                bono.getPrestamo().getMoneda(),
                bono.getFrecuenciaPago(),
                bono.getPlazo().getValor(),
                bono.getPlazo().getUnidad(),
                bono.getTea().getValor(),
                bono.getNumeroPeriodos(),
                bono.getPlazoGracia().getTipo(),
                bono.getPlazoGracia().getDuracion().getValor(),
                bono.getPlazoGracia().getDuracion().getUnidad(),
                bono.getFechaInicio()
        );
    }
}
