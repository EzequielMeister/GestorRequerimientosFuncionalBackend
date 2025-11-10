package com.ezequielmeister.gestionrequerimientos.controller;

import com.ezequielmeister.gestionrequerimientos.model.Requerimiento;
import com.ezequielmeister.gestionrequerimientos.service.RequerimientoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requerimientos")
public class RequerimientoController {

    private final RequerimientoService service;

    public RequerimientoController(RequerimientoService service) {
        this.service = service;
    }

    // GET - Listar todos
    @GetMapping
    public List<Requerimiento> listar() {
        return service.listarTodos();
    }

    // POST - Crear nuevo requerimiento
    @PostMapping
    public Requerimiento crear(@RequestBody Requerimiento req) {
        return service.guardar(req);
    }

    // PUT - Actualizar un requerimiento existente
    @PutMapping("/{id}")
    public ResponseEntity<Requerimiento> actualizar(@PathVariable Long id, @RequestBody Requerimiento detalles) {
        Requerimiento actualizado = service.actualizar(id, detalles);
        return ResponseEntity.ok(actualizado);
    }

    // DELETE - Eliminar requerimiento por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
