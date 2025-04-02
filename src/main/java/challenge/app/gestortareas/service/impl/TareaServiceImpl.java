package challenge.app.gestortareas.service.impl;

import challenge.app.gestortareas.entity.Tarea;
import challenge.app.gestortareas.repository.TareaRepository;
import challenge.app.gestortareas.service.TareaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public List<Tarea> listarTodas() {
        return tareaRepository.findAll();
    }

    @Override
    public Optional<Tarea> obtenerPorId(Long id) {
        return tareaRepository.findById(id);
    }

    @Override
    public Tarea guardar(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public Tarea actualizar(Long id, Tarea tarea) {
        if (!tareaRepository.existsById(id)) {
            throw new RuntimeException("Tarea no encontrada con ID: " + id);
        }
        tarea.setId(id);
        return tareaRepository.save(tarea);
    }

    @Override
    public void eliminar(Long id) {
        tareaRepository.deleteById(id);
    }

    @Override
    public List<Tarea> listarPorProyectoId(Long proyectoId) {
        return tareaRepository.findByProyectoId(proyectoId);
    }
}
