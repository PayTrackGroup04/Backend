package com.paytrack.bonos.domain.services;

import com.paytrack.bonos.domain.model.aggregates.Bono;
import com.paytrack.bonos.domain.model.commands.ActualizarBonoCommand;
import com.paytrack.bonos.domain.model.commands.CrearBonoCommand;

import java.util.Optional;

public interface BonoCommandService {

    Optional<Bono> handle(CrearBonoCommand command);
    Optional<Bono> handleUpdate(ActualizarBonoCommand command);


}
