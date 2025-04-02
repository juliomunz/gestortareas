package challenge.app.gestortareas.service;

import challenge.app.gestortareas.entity.Proyecto;

import java.util.List;
import java.util.Optional;
public interface ProyectoService {
    List<Proyecto> listarTodos();
    Optional<Proyecto> obtenerPorId(Long id);
    Proyecto guardar(Proyecto proyecto);
    Proyecto actualizar(Long id, Proyecto proyecto);

    void eliminar(Long id);
}
