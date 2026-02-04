package com.ejercicio.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.model.Curso;

public interface CursoDao extends JpaRepository<Curso, Integer> {

	Curso findByCodCurso(String codCurso);
	List<Curso> findByPrecioBetween(BigDecimal precioMinimo, BigDecimal precioMaximo);
	Curso findTopByOrderByIdDesc();	
	Curso findByNombre(String nombre);

}
