package com.ezequielmeister.gestionrequerimientos.repository;

import com.ezequielmeister.gestionrequerimientos.model.Requerimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequerimientoRepository extends JpaRepository<Requerimiento, Long> { }
