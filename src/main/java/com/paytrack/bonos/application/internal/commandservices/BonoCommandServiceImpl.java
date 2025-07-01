package com.paytrack.bonos.application.internal.commandservices;

import com.paytrack.bonos.domain.model.aggregates.Bono;
import com.paytrack.bonos.domain.model.commands.CrearBonoCommand;
import com.paytrack.bonos.domain.services.BonoCommandService;
import com.paytrack.bonos.infrastructure.persistance.jpa.repositories.BonoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BonoCommandServiceImpl implements BonoCommandService {

    private final BonoRepository bonoRepository;

    public BonoCommandServiceImpl(BonoRepository bonoRepository) {
        this.bonoRepository = bonoRepository;
    }

    @Override
    public Optional<Bono> handle(CrearBonoCommand command) {
        Bono bono = new Bono(
                command.usuarioId(),
                command.valorNominal(),
                command.tasaCupon(),
                command.tipoTasa(),
                command.capitalizacion(),
                command.frecuenciaPago(),
                command.plazoAnios(),
                command.graciaTotal(),
                command.graciaParcial(),
                command.fechaEmision(),
                command.numeroDiasPorAno(),
                command.cavali(),
                command.estructuracion(),
                command.colocacion(),
                command.metodoAmortizacion(),
                command.moneda()
        );
        Bono savedBono = bonoRepository.save(bono);
        return Optional.of(savedBono);
    }

}
