package challenge.app.gestortareas.repository;

import challenge.app.gestortareas.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository  extends JpaRepository<Tarea, Long> {
    List<Tarea> findByProyectoId(Long proyectoId);
}
