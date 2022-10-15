package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Estudiante;
import com.example.demo.repository.EstudianteRepository;

@Service
public class EstudianteService {

	@Qualifier("estudianteRepository")
	@Autowired
	private EstudianteRepository repository;
	/**
	 * 2
	 * a) dar de alta un estudiante
	 * @param e
	 * @return
	 */
	public Estudiante addEstudiante(Estudiante e) {
		return repository.save(e);
	}
	
	/**
	 * 2
	 * c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
	 * 
	 * @return lista de estudiantes
	 */
	public List<Estudiante>getEstudiantesByCriterio(){
		return repository.findAll(orderBySurnameAsc());
	}
	
	/**
	 * Ordenamiento por apellido ASC
	 * @return ordenamiento arc por apellido
	 */
	private Sort orderBySurnameAsc() {
		return Sort.by(Sort.Direction.ASC, "apellido");
	}
	
	/**
	 * 2
	 * d) recuperar un estudiante, en base a su número de libreta universitaria.
	 * @param libreta
	 * @return
	 */
	public Estudiante getEstudiante(int libreta) {
		return repository.getEstudianteById(libreta);
	}
	
	
}
