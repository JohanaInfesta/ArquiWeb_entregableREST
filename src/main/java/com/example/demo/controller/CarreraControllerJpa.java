package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Carrera;
import com.example.demo.services.CarreraService;


@RestController
public class CarreraControllerJpa {

	@Qualifier("carreraService")
	@Autowired
	private final CarreraService service;
	
	public CarreraControllerJpa(@Qualifier("carreraService")CarreraService service) {
		this.service = service;
	}

	@PostMapping("/carrera")
	Carrera agregarCarrera(@RequestBody Carrera c) {
		return service.addCarrera(c);
	}
	
}
