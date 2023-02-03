package com.gestion.empleados.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.empleados.modelo.Documentos;

@Repository
public interface DocumentosRepositorio extends JpaRepository<Documentos, Long>{
	
}
