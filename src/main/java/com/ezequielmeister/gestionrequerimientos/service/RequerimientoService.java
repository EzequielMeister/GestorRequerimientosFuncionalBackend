package com.ezequielmeister.gestionrequerimientos.service;

import com.ezequielmeister.gestionrequerimientos.model.Requerimiento;
import com.ezequielmeister.gestionrequerimientos.repository.RequerimientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequerimientoService {

    private final RequerimientoRepository repository;

    public RequerimientoService(RequerimientoRepository repository) {
        this.repository = repository;
    }

    public List<Requerimiento> listarTodos() {
        return repository.findAll();
    }

    public Requerimiento guardar(Requerimiento req) {
        return repository.save(req);
    }

    public Requerimiento actualizar(Long id, Requerimiento detalles) {
        Requerimiento existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Requerimiento no encontrado con id " + id));

        existente.setTitulo(detalles.getTitulo());
        existente.setDescripcion(detalles.getDescripcion());
        existente.setPrioridad(detalles.getPrioridad());
        existente.setEstado(detalles.getEstado());

        return repository.save(existente);
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("No existe requerimiento con id " + id);
        }
        repository.deleteById(id);
    }
}
