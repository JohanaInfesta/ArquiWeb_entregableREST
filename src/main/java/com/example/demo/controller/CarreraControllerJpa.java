package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Carrera;
import com.example.demo.repository.CarreraRepository;


@RestController
public class CarreraControllerJpa {

	@Qualifier("carreraRepository")
	@Autowired
	private final CarreraRepository repository;
	
	public CarreraControllerJpa(@Qualifier("carreraRepository") CarreraRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/carrera/{carreraID}")
	Optional<Carrera>one(@PathVariable int carreraID){
		return repository.findById(carreraID);
	}
	
}
