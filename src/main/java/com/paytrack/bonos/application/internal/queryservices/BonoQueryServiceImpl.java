package com.paytrack.bonos.application.internal.queryservices;

import com.paytrack.bonos.domain.model.aggregates.Bono;
import com.paytrack.bonos.domain.services.BonoQueryService;
import com.paytrack.bonos.infrastructure.persistance.jpa.repositories.BonoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BonoQueryServiceImpl implements BonoQueryService {

    private final BonoRepository bonoRepository;

    public BonoQueryServiceImpl(BonoRepository bonoRepository) {
        this.bonoRepository = bonoRepository;
    }

    @Override
    public Optional<Bono> getById(Long id) {
        return bonoRepository.findById(id);
    }

    @Override
    public List<Bono> getAll() {
        return bonoRepository.findAll();
    }
}
