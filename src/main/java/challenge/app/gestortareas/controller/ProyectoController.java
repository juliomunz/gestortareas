package challenge.app.gestortareas.controller;

import challenge.app.gestortareas.entity.Proyecto;
import challenge.app.gestortareas.service.ProyectoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping
    public List<Proyecto> listarTodos() {
        return proyectoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> obtenerPorId(@PathVariable Long id) {
        return proyectoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Proyecto> guardar(@Valid @RequestBody Proyecto proyecto) {
        Proyecto nuevo = proyectoService.guardar(proyecto);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> actualizar(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        try{
            Proyecto actualizado = proyectoService.actualizar(id, proyecto);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        proyectoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
