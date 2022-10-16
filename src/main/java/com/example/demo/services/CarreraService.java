package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.model.Carrera;
import com.example.demo.repository.CarreraRepository;

@Service
public class CarreraService {
	@Qualifier("carreraRepository")
	@Autowired
	private CarreraRepository repository;

	public CarreraService(@Qualifier("carreraRepository")CarreraRepository repository) {
		this.repository = repository;
	}

	public Carrera addCarrera(Carrera c) {
		return repository.save(c);
	}
	
}
