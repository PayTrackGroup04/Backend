package com.paytrack.bonos.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;

@Embeddable
public class Dinero {

    private BigDecimal monto;

    @Enumerated(EnumType.STRING)
    private TipoMoneda moneda;

    protected Dinero() {}

    public Dinero(BigDecimal monto, TipoMoneda moneda) {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El monto no puede ser nulo ni negativo.");
        }
        if (moneda == null) {
            throw new IllegalArgumentException("La moneda no puede ser nula.");
        }
        this.monto = monto;
        this.moneda = moneda;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public TipoMoneda getMoneda() {
        return moneda;
    }

}
