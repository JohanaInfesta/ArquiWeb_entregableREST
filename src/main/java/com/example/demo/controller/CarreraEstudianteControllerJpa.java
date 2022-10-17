package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CarreraEstudiante;
import com.example.demo.model.Estudiante;
import com.example.demo.model.dto.CarreraDTO;
import com.example.demo.model.dto.ReporteDTO;
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
		@PostMapping("matricular/{libreta}/{carreraID}")
		public CarreraEstudiante matricularEstudiante(@PathVariable int libreta, @PathVariable int carreraID) {
			return service.matricularEstudiante(libreta, carreraID);
	//		
	//		CarreraEstudiante ce = new CarreraEstudiante(ca, es, LocalDate.now(), null);
	//		return repository.save(ce);
		}

	@GetMapping("/carreras")
	public List<CarreraDTO>getCarrerasOrder(){
		return service.getCarrerasInOrder();
	}

	@GetMapping("/estudiantes/{carreraID}/{ciudad}")
	public List<Estudiante>getEstudiantesCarrerasByCiudad(@PathVariable int carreraID, @PathVariable String ciudad){
		System.out.println(carreraID);
		return service.getEstudiantesCarrera(carreraID, ciudad);
	}
	
	@GetMapping("/reporte")
	public List<ReporteDTO>getReporte(){
		return service.generarReporte();
	}
	
}
