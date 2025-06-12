package com.paytrack.bonos.interfaces.rest.transform;

import com.paytrack.bonos.domain.model.commands.CrearBonoCommand;
import com.paytrack.bonos.domain.model.valueobjects.Dinero;
import com.paytrack.bonos.domain.model.valueobjects.PeriodoTiempo;
import com.paytrack.bonos.domain.model.valueobjects.PlazoGracia;
import com.paytrack.bonos.domain.model.valueobjects.TasaInteres;
import com.paytrack.bonos.interfaces.rest.resources.CrearBonoResource;

public class CrearBonoCommandFromResourceAssembler {
    public static CrearBonoCommand toCommandFromResource(CrearBonoResource resource) {
        return new CrearBonoCommand(
                new Dinero(resource.precioVentaMonto(), resource.precioVentaMoneda()),
                resource.porcentajeCuotaInicial(),
                new Dinero(resource.prestamoMonto(), resource.prestamoMoneda()),
                resource.frecuenciaPago(),
                new PeriodoTiempo(resource.plazoValor(), resource.plazoUnidad()),
                new TasaInteres(resource.tea()),
                resource.numeroPeriodos(),
                new PlazoGracia(
                        resource.tipoPlazoGracia(),
                        new PeriodoTiempo(resource.duracionGraciaValor(), resource.duracionGraciaUnidad())
                ),
                resource.fechaInicio()
        );
    }
}
