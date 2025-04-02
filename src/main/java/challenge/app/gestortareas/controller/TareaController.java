package challenge.app.gestortareas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import challenge.app.gestortareas.entity.Tarea;
import challenge.app.gestortareas.service.TareaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping
    private List<Tarea> listarTodas() {
        return tareaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtenerPorId(@PathVariable Long id) {
        return tareaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/proyecto/{proyectoId}")
    public List<Tarea> listarPorProyecto(@PathVariable Long proyectoId) {
        return tareaService.listarPorProyectoId(proyectoId);
    }

    @PostMapping
    public ResponseEntity<Tarea> guardar(@RequestBody Tarea tarea) {
        Tarea nueva = tareaService.guardar(tarea);
        return ResponseEntity.ok(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizar(@PathVariable Long id, @RequestBody Tarea tarea) {
        try {
            Tarea actualizada = tareaService.actualizar(id, tarea);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tareaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
