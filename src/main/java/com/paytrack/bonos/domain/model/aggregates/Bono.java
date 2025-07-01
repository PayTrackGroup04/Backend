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

    @Column(nullable = false)
    private Long usuarioId;

    @Column(nullable = false)
    private BigDecimal valorNominal;

    @Column(nullable = false)
    private BigDecimal tasaCupon;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTasa tipoTasa;

    @Enumerated(EnumType.STRING)
    private Capitalizacion capitalizacion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FrecuenciaPago frecuenciaPago;

    @Column(nullable = false)
    private int plazoAnios;

    @Column(nullable = false)
    private int graciaTotal;

    @Column(nullable = false)
    private int graciaParcial;

    @Column(nullable = false)
    private LocalDate fechaEmision;

    @Column(nullable = false)
    private int numeroDiasPorAno;

    @Column(nullable = false)
    private BigDecimal cavali;

    @Column(nullable = false)
    private BigDecimal estructuracion;

    @Column(nullable = false)
    private BigDecimal colocacion;

    @Enumerated(EnumType.STRING)
    private MetodoAmortizacion metodoAmortizacion;

    @Enumerated(EnumType.STRING)
    private TipoMoneda moneda;

    public Bono() {}

    public Bono(
            Long usuarioId,
            BigDecimal valorNominal,
            BigDecimal tasaCupon,
            TipoTasa tipoTasa,
            Capitalizacion capitalizacion,
            FrecuenciaPago frecuenciaPago,
            int plazoAnios,
            int graciaTotal,
            int graciaParcial,
            LocalDate fechaEmision,
            int numeroDiasPorAno,
            BigDecimal cavali,
            BigDecimal estructuracion,
            BigDecimal colocacion,
            MetodoAmortizacion metodoAmortizacion,
            TipoMoneda moneda
    ) {
        this.usuarioId = usuarioId;
        this.valorNominal = valorNominal;
        this.tasaCupon = tasaCupon;
        this.tipoTasa = tipoTasa;
        this.capitalizacion = capitalizacion;
        this.frecuenciaPago = frecuenciaPago;
        this.plazoAnios = plazoAnios;
        this.graciaTotal = graciaTotal;
        this.graciaParcial = graciaParcial;
        this.fechaEmision = fechaEmision;
        this.numeroDiasPorAno = numeroDiasPorAno;
        this.cavali = cavali;
        this.estructuracion = estructuracion;
        this.colocacion = colocacion;
        this.metodoAmortizacion = metodoAmortizacion;
        this.moneda = moneda;
    }

    // Getters
    public Long getId() { return id; }
    public Long getUsuarioId() { return usuarioId; }
    public BigDecimal getValorNominal() { return valorNominal; }
    public BigDecimal getTasaCupon() { return tasaCupon; }
    public TipoTasa getTipoTasa() { return tipoTasa; }
    public Capitalizacion getCapitalizacion() { return capitalizacion; }
    public FrecuenciaPago getFrecuenciaPago() { return frecuenciaPago; }
    public int getPlazoAnios() { return plazoAnios; }
    public int getGraciaTotal() { return graciaTotal; }
    public int getGraciaParcial() { return graciaParcial; }
    public LocalDate getFechaEmision() { return fechaEmision; }
    public int getNumeroDiasPorAno() { return numeroDiasPorAno; }
    public BigDecimal getCavali() { return cavali; }
    public BigDecimal getEstructuracion() { return estructuracion; }
    public BigDecimal getColocacion() { return colocacion; }
    public MetodoAmortizacion getMetodoAmortizacion() { return metodoAmortizacion; }
    public TipoMoneda getMoneda() { return moneda; }
}