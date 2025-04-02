package challenge.app.gestortareas.service.impl;

import challenge.app.gestortareas.entity.Proyecto;
import challenge.app.gestortareas.exception.RecursoNoEncontradoException;
import challenge.app.gestortareas.repository.ProyectoRepository;
import challenge.app.gestortareas.service.ProyectoService;
import jakarta.persistence.EntityNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProyectoServiceImpl implements ProyectoService {
    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public List<Proyecto> listarTodos() {
        return proyectoRepository.findAll();
    }

    @Override
    public Optional<Proyecto> obtenerPorId(Long id) {
        return Optional.ofNullable(proyectoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Proyecto no encontrado con ID: " + id)));
    }

    @Override
    public Proyecto guardar(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    @Override
    public Proyecto actualizar(Long id, Proyecto proyecto) {
        if (!proyectoRepository.existsById(id)) {
            throw new EntityNotFoundException("No se encontró el proyecto con id: " + id);
        }
        proyecto.setId(id);
        return proyectoRepository.save(proyecto);
    }

    @Override
    public void eliminar(Long id) {
        proyectoRepository.deleteById(id);
        }
}
