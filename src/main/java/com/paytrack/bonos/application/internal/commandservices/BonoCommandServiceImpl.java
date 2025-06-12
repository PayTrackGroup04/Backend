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
                command.precioVenta(),
                command.porcentajeCuotaInicial(),
                command.prestamo(),
                command.frecuenciaPago(),
                command.plazo(),
                command.tea(),
                command.numeroPeriodos(),
                command.plazoGracia(),
                command.fechaInicio(),
                command.usuarioId()
        );

        Bono guardado = bonoRepository.save(bono);
        return Optional.of(guardado);
    }

}
