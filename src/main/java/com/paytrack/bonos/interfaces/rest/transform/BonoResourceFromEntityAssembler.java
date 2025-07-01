package com.paytrack.bonos.interfaces.rest.transform;

import com.paytrack.bonos.domain.model.aggregates.Bono;
import com.paytrack.bonos.interfaces.rest.resources.BonoResource;

public class BonoResourceFromEntityAssembler {

    public static BonoResource toResourceFromEntity(Bono bono) {
        return new BonoResource(
                bono.getId(),
                bono.getUsuarioId(),
                bono.getValorNominal(),
                bono.getTasaCupon(),
                bono.getTipoTasa(),
                bono.getCapitalizacion(),
                bono.getFrecuenciaPago(),
                bono.getPlazoAnios(),
                bono.getGraciaTotal(),
                bono.getGraciaParcial(),
                bono.getFechaEmision(),
                bono.getNumeroDiasPorAno(),
                bono.getCavali(),
                bono.getEstructuracion(),
                bono.getColocacion(),
                bono.getMetodoAmortizacion(),
                bono.getMoneda()
        );
    }
}