package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.model.Carrera;
import com.example.demo.repository.CarreraEstudianteRepository;

@Service
public class CarreraEstudianteService {

	@Qualifier("carreraEstudianteRepository")
	@Autowired
	private CarreraEstudianteRepository repository;

	public CarreraEstudianteService(@Qualifier("carreraEstudianteRepository")CarreraEstudianteRepository repository) {
		this.repository = repository;
	}
	//falta matricular carrera
	
	
	/**
	 * 2
	 * f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
	 * @return
	 */
	public List<Carrera>getCarrerasInOrder(){
		System.out.println(repository.getCarrerasOrder());
		return repository.getCarrerasOrder();
	}
	
}
