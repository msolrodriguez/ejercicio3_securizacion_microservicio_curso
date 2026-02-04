package com.ejercicio.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.model.Curso;
import com.ejercicio.service.CursoService;

@RestController
public class CursoController {

	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping(value="listadocursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> listadoCursos(){
		return cursoService.listadoCursos();
	}
	
	@PostMapping(value="altacurso", consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> altaCurso(@RequestBody Curso curso){
		return cursoService.altaCurso(curso);		
	}
	
	@DeleteMapping(value="curso/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminarCurso(@PathVariable String codCurso){
		return cursoService.eliminarCurso(codCurso);
	}
	
	@PutMapping(value="curso/{codCurso}/{numeroHoras}", produces=MediaType.APPLICATION_JSON_VALUE)
	public void actualizarDuracionCurso(@PathVariable String codCurso, @PathVariable Integer numeroHoras) {
		cursoService.actulizarDuracion(codCurso, numeroHoras);
	}
	
	@GetMapping(value="curso/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCursoXCodCurso(@PathVariable String codCurso) {
		return cursoService.buscarCurso(codCurso);
	}
	
	@GetMapping(value="curso/{precioMinimo}/{precioMaximo}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursosXRangoPrecio(@PathVariable BigDecimal precioMinimo, @PathVariable BigDecimal precioMaximo){
		return cursoService.cursosXRangoPrecio(precioMinimo, precioMaximo);
	}
	
	@GetMapping(value="obtenerid")
	public Integer obtenerIdMayor() {
		return cursoService.obtenerIdMayor();
	}
	
	@GetMapping(value="buscarcurso", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCursoXNombre(@RequestBody Curso curso) {
		return cursoService.buscarCursoXNombre(curso);
	}
}
