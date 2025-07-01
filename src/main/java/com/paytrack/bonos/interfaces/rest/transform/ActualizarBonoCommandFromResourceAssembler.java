package com.paytrack.bonos.interfaces.rest.transform;

import com.paytrack.bonos.domain.model.commands.ActualizarBonoCommand;
import com.paytrack.bonos.interfaces.rest.resources.ActualizarBonoResource;

public class ActualizarBonoCommandFromResourceAssembler {

    public static ActualizarBonoCommand toCommandFromResource(
            Long bonoId, Long usuarioId, ActualizarBonoResource resource
    ) {
        return new ActualizarBonoCommand(
                bonoId,
                usuarioId,
                resource.valorNominal(),
                resource.tasaCupon(),
                resource.tipoTasa(),
                resource.capitalizacion(),
                resource.frecuenciaPago(),
                resource.plazoAnios(),
                resource.graciaTotal(),
                resource.graciaParcial(),
                resource.fechaEmision(),
                resource.numeroDiasPorAno(),
                resource.cavali(),
                resource.estructuracion(),
                resource.colocacion(),
                resource.metodoAmortizacion(),
                resource.moneda()
        );
    }
}
