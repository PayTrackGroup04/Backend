package com.paytrack.bonos.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public class TasaInteres{

    private BigDecimal valor; // Representa la tasa anual (ej: 0.08 para 8%)

    protected TasaInteres() {}

    public TasaInteres(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

}
