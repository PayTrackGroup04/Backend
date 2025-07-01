package com.paytrack.bonos.interfaces.rest.transform;

import com.paytrack.bonos.domain.model.commands.CrearBonoCommand;
import com.paytrack.bonos.domain.model.valueobjects.Dinero;
import com.paytrack.bonos.domain.model.valueobjects.PeriodoTiempo;
import com.paytrack.bonos.domain.model.valueobjects.PlazoGracia;
import com.paytrack.bonos.domain.model.valueobjects.TasaInteres;
import com.paytrack.bonos.interfaces.rest.resources.CrearBonoResource;

public class CrearBonoCommandFromResourceAssembler {

    public static CrearBonoCommand toCommandFromResource(CrearBonoResource resource, Long usuarioId) {
        return new CrearBonoCommand(
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
