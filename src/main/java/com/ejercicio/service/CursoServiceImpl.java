package com.ejercicio.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.dao.CursoDao;
import com.ejercicio.model.Curso;

@Service
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	private CursoDao cursoDao;

	@Override
	public List<Curso> listadoCursos() {		
		return cursoDao.findAll();
	}

	@Override
	public List<Curso> altaCurso(Curso curso) {		
		cursoDao.save(curso);
		return cursoDao.findAll();
	}

	@Override
	public List<Curso> eliminarCurso(String codCurso) {
		
		Curso cursoEncontrado= this.buscarCurso(codCurso);
		if (cursoEncontrado!=null) {
			cursoDao.delete(cursoEncontrado);
		}	
		
		return cursoDao.findAll();
	}

	@Override
	public void actulizarDuracion(String codCurso, Integer numeroHoras) {
		
		Curso cursoEncontrado= this.buscarCurso(codCurso);
		if (cursoEncontrado!=null) {
			cursoEncontrado.setDuracion(numeroHoras);
			cursoDao.save(cursoEncontrado);
		}

	}

	@Override
	public Curso buscarCurso(String codCurso) {			
		return cursoDao.findByCodCurso(codCurso);
	}

	@Override
	public List<Curso> cursosXRangoPrecio(BigDecimal precioMinimo, BigDecimal precioMaximo) {
		
		return cursoDao.findByPrecioBetween(precioMinimo, precioMaximo);
	}

	@Override
	public Integer obtenerIdMayor() {
		return cursoDao.findTopByOrderByIdDesc().getId();
	}

	@Override
	public Curso buscarCursoXNombre(Curso curso) {		
		return cursoDao.findByNombre(curso.getNombre());
	}

}
