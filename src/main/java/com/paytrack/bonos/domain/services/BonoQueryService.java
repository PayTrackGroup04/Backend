package com.paytrack.bonos.domain.services;

import com.paytrack.bonos.domain.model.aggregates.Bono;

import java.util.List;
import java.util.Optional;

public interface BonoQueryService {
    Optional<Bono> getById(Long id);
    List<Bono> getAll();
    List<Bono>getByUsuarioId(Long usuarioId);
}
