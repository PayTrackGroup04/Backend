package com.paytrack.bonos.domain.model.valueobjects;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class PeriodoTiempo {

    public enum UnidadTiempo {
        MESES,
        ANIOS
    }

    private int valor;

    @Enumerated(EnumType.STRING)
    private UnidadTiempo unidad;

    protected PeriodoTiempo() {}

    public PeriodoTiempo(int valor, UnidadTiempo unidad) {
        this.valor = valor;
        this.unidad = unidad;
    }

    public int getValor() {
        return valor;
    }

    public UnidadTiempo getUnidad() {
        return unidad;
    }

}
