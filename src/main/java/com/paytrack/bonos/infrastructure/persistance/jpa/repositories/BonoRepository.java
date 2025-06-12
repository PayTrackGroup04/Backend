package com.paytrack.bonos.infrastructure.persistance.jpa.repositories;

import com.paytrack.bonos.domain.model.aggregates.Bono;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BonoRepository extends JpaRepository<Bono, Long> {
    Optional<Bono> findById(Long id);
    List<Bono> findAll();
    List<Bono> findByUsuarioId(Long usuarioId);

}
