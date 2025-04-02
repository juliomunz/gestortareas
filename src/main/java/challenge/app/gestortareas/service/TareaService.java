package challenge.app.gestortareas.service;

import challenge.app.gestortareas.entity.Tarea;

import java.util.List;
import java.util.Optional;

public interface TareaService {

    List<Tarea> listarTodas();
    Optional<Tarea> obtenerPorId(Long id);
    Tarea guardar(Tarea tarea);
    Tarea actualizar(Long id, Tarea tarea);
    void eliminar(Long id);
    List<Tarea> listarPorProyectoId(Long proyectoId);
}
