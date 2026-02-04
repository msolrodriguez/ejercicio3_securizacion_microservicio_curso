package com.ejercicio.service;

import java.math.BigDecimal;
import java.util.List;

import com.ejercicio.model.Curso;

public interface CursoService {
	
	List<Curso> listadoCursos();
	List<Curso> altaCurso(Curso curso);
	List<Curso> eliminarCurso(String codCurso);
	void actulizarDuracion(String codCurso, Integer numeroHoras);
	Curso buscarCurso(String codCurso);
	List<Curso> cursosXRangoPrecio(BigDecimal precioMinimo, BigDecimal precioMaximo);	
	Integer obtenerIdMayor();
	Curso buscarCursoXNombre(Curso curso);

}
