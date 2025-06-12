package com.paytrack.bonos.domain.model.aggregates;

import com.paytrack.bonos.domain.model.valueobjects.*;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Bono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Dinero precioVenta;

    private BigDecimal porcentajeCuotaInicial;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "monto", column = @Column(name = "monto_prestamo")),
            @AttributeOverride(name = "moneda", column = @Column(name = "moneda_prestamo"))
    })
    private Dinero prestamo;

    @Enumerated(EnumType.STRING)
    private FrecuenciaPago frecuenciaPago;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "valor", column = @Column(name = "plazo_valor")),
            @AttributeOverride(name = "unidad", column = @Column(name = "plazo_unidad"))
    })
    private PeriodoTiempo plazo;

    @Embedded
    private TasaInteres tea;

    private int numeroPeriodos;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "duracion.valor", column = @Column(name = "gracia_valor")),
            @AttributeOverride(name = "duracion.unidad", column = @Column(name = "gracia_unidad")),
            @AttributeOverride(name = "tipo", column = @Column(name = "gracia_tipo"))
    })
    private PlazoGracia plazoGracia;

    private LocalDate fechaInicio;

    public Bono() {}

    public Bono(
            Dinero precioVenta,
            BigDecimal porcentajeCuotaInicial,
            Dinero prestamo,
            FrecuenciaPago frecuenciaPago,
            PeriodoTiempo plazo,
            TasaInteres tea,
            int numeroPeriodos,
            PlazoGracia plazoGracia,
            LocalDate fechaInicio
    ) {
        this.precioVenta = precioVenta;
        this.porcentajeCuotaInicial = porcentajeCuotaInicial;
        this.prestamo = prestamo;
        this.frecuenciaPago = frecuenciaPago;
        this.plazo = plazo;
        this.tea = tea;
        this.numeroPeriodos = numeroPeriodos;
        this.plazoGracia = plazoGracia;
        this.fechaInicio = fechaInicio;
    }

    public Long getId() {
        return id;
    }

    public Dinero getPrecioVenta() {
        return precioVenta;
    }

    public BigDecimal getPorcentajeCuotaInicial() {
        return porcentajeCuotaInicial;
    }

    public Dinero getPrestamo() {
        return prestamo;
    }

    public FrecuenciaPago getFrecuenciaPago() {
        return frecuenciaPago;
    }

    public PeriodoTiempo getPlazo() {
        return plazo;
    }

    public TasaInteres getTea() {
        return tea;
    }

    public int getNumeroPeriodos() {
        return numeroPeriodos;
    }

    public PlazoGracia getPlazoGracia() {
        return plazoGracia;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

}
