package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Carrera;
import com.example.demo.services.CarreraEstudianteService;

@RestController
public class CarreraEstudianteControllerJpa {

	@Qualifier("carreraEstudianteService")
	@Autowired
	private final CarreraEstudianteService service;


	//	private final EstudianteRepository estudianteRepository;
	//	private final CarreraRepository carreraRepository;
	//	
	public CarreraEstudianteControllerJpa(@Qualifier("carreraEstudianteService")CarreraEstudianteService service) {
		this.service = service;
	}
	
	
	// ALERTA NO ANDA
	// ALERTA -> LE PODEMOS PASAR LA ENTIDAD
	//	@PostMapping("matricular/{estudianteId}/{carreraID}")
	//	public CarreraEstudiante matricularEstudiante(@PathVariable int estudianteId, @PathVariable int carreraID) {
	//		Estudiante es = estudianteRepository.getEstudianteById(estudianteId);
	//		Carrera ca = carreraRepository.getCarreraById(carreraID);
	//		
	//		CarreraEstudiante ce = new CarreraEstudiante(ca, es, LocalDate.now(), null);
	//		return repository.save(ce);
	//	}

	@GetMapping("/carreras")
	public List<Carrera>getCarrerasOrder(){
		return service.getCarrerasInOrder();
	}


	
}
