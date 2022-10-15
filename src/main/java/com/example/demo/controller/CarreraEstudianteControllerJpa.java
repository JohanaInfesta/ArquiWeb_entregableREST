package com.example.demo.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Carrera;
import com.example.demo.model.CarreraEstudiante;
import com.example.demo.model.Estudiante;
import com.example.demo.repository.CarreraEstudianteRepository;
import com.example.demo.repository.CarreraRepository;
import com.example.demo.repository.EstudianteRepository;

@RestController
public class CarreraEstudianteControllerJpa {

	@Qualifier("carreraEstudianteRepository")
	@Autowired
	private final CarreraEstudianteRepository repository;
	private final EstudianteRepository estudianteRepository;
	private final CarreraRepository carreraRepository;
	
	public CarreraEstudianteControllerJpa(@Qualifier("carreraEstudianteRepository") CarreraEstudianteRepository repository,
			@Qualifier("estudianteRepository") EstudianteRepository estudianteRepository,
			@Qualifier("carreraRepository") CarreraRepository carreraRepository) {
		this.repository = repository;
		this.carreraRepository = carreraRepository;
		this.estudianteRepository = estudianteRepository;
	}
	// ALERTA NO ANDA
	// ALERTA -> LE PODEMOS PASAR LA ENTIDAD
	@PostMapping("matricular/{estudianteId}/{carreraID}")
	public CarreraEstudiante matricularEstudiante(@PathVariable int estudianteId, @PathVariable int carreraID) {
		Estudiante es = estudianteRepository.getEstudianteById(estudianteId);
		Carrera ca = carreraRepository.getCarreraById(carreraID);
		
		CarreraEstudiante ce = new CarreraEstudiante(ca, es, LocalDate.now(), null);
		return repository.save(ce);
	}
}
