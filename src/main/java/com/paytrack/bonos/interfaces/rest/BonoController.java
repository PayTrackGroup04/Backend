package com.paytrack.bonos.interfaces.rest;

import com.paytrack.bonos.domain.model.aggregates.Bono;
import com.paytrack.bonos.domain.services.BonoCommandService;
import com.paytrack.bonos.domain.services.BonoQueryService;
import com.paytrack.bonos.interfaces.rest.resources.ActualizarBonoResource;
import com.paytrack.bonos.interfaces.rest.resources.BonoResource;
import com.paytrack.bonos.interfaces.rest.resources.CrearBonoResource;
import com.paytrack.bonos.interfaces.rest.transform.ActualizarBonoCommandFromResourceAssembler;
import com.paytrack.bonos.interfaces.rest.transform.BonoResourceFromEntityAssembler;
import com.paytrack.bonos.interfaces.rest.transform.CrearBonoCommandFromResourceAssembler;
import com.paytrack.iam.infrastructure.authorization.sfs.model.UserDetailsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bonos")
public class BonoController {

    private final BonoCommandService bonoCommandService;
    private final BonoQueryService bonoQueryService;

    public BonoController(BonoCommandService bonoCommandService, BonoQueryService bonoQueryService) {
        this.bonoCommandService = bonoCommandService;
        this.bonoQueryService = bonoQueryService;
    }


    //Crear bono
    /**@PostMapping
    public ResponseEntity<BonoResource> crear(@RequestBody CrearBonoResource resource) {
        var command = CrearBonoCommandFromResourceAssembler.toCommandFromResource(resource);
        Optional<Bono> resultado = bonoCommandService.handle(command);

        return resultado
                .map(BonoResourceFromEntityAssembler::toResourceFromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }**/

    @PostMapping
    public ResponseEntity<BonoResource> crear(
            @RequestBody CrearBonoResource resource,
            @AuthenticationPrincipal UserDetailsImpl usuarioAutenticado
    ) {
        Long usuarioId = usuarioAutenticado.getId(); // ID seguro desde sesión

        var command = CrearBonoCommandFromResourceAssembler.toCommandFromResource(resource, usuarioId);
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

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<BonoResource>> obtenerPorUsuario(@PathVariable Long usuarioId) {
        var bonos = bonoQueryService.getByUsuarioId(usuarioId);
        var resources = bonos.stream()
                .map(BonoResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(resources);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BonoResource> actualizar(
            @PathVariable Long id,
            @RequestBody ActualizarBonoResource resource,
            @AuthenticationPrincipal UserDetailsImpl usuario
    ) {
        var command = ActualizarBonoCommandFromResourceAssembler.toCommandFromResource(id, usuario.getId(), resource);
        return bonoCommandService.handleUpdate(command)
                .map(BonoResourceFromEntityAssembler::toResourceFromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }


}
