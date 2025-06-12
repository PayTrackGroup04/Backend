package com.paytrack.bonos.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class PlazoGracia{

    @Enumerated(EnumType.STRING)
    private TipoPlazoGracia tipo;

    @Embedded
    private PeriodoTiempo duracion;

    protected PlazoGracia() {}

    public PlazoGracia(TipoPlazoGracia tipo, PeriodoTiempo duracion) {
        this.tipo = tipo;
        this.duracion = duracion;
    }

    public TipoPlazoGracia getTipo() {
        return tipo;
    }

    public PeriodoTiempo getDuracion() {
        return duracion;
    }

}
