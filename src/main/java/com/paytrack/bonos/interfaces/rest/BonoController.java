package com.paytrack.bonos.interfaces.rest;

import com.paytrack.bonos.domain.model.aggregates.Bono;
import com.paytrack.bonos.domain.services.BonoCommandService;
import com.paytrack.bonos.domain.services.BonoQueryService;
import com.paytrack.bonos.interfaces.rest.resources.BonoResource;
import com.paytrack.bonos.interfaces.rest.resources.CrearBonoResource;
import com.paytrack.bonos.interfaces.rest.transform.BonoResourceFromEntityAssembler;
import com.paytrack.bonos.interfaces.rest.transform.CrearBonoCommandFromResourceAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/bonos")
public class BonoController {

    private final BonoCommandService bonoCommandService;
    private final BonoQueryService bonoQueryService;

    public BonoController(BonoCommandService bonoCommandService, BonoQueryService bonoQueryService) {
        this.bonoCommandService = bonoCommandService;
        this.bonoQueryService = bonoQueryService;
    }


    // Crear bono
    @PostMapping
    public ResponseEntity<BonoResource> crear(@RequestBody CrearBonoResource resource) {
        var command = CrearBonoCommandFromResourceAssembler.toCommandFromResource(resource);
        Optional<Bono> resultado = bonoCommandService.handle(command);

        return resultado
                .map(BonoResourceFromEntityAssembler::toResourceFromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    // Obtener bono por ID
    @GetMapping("/{id}")
    public ResponseEntity<BonoResource> obtenerPorId(@PathVariable Long id) {
        Optional<Bono> resultado = bonoQueryService.getById(id);

        return resultado
                .map(BonoResourceFromEntityAssembler::toResourceFromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
