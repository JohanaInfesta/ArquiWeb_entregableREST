package com.example.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Carrera;
import com.example.demo.model.Estudiante;
import com.example.demo.repository.CarreraRepository;
import com.example.demo.repository.EstudianteRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDatabase {

private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);
	

	@Bean
	CommandLineRunner initEstudiante(@Qualifier("estudianteRepository") EstudianteRepository repository) {
		return args -> {
			logger.info("preloading" + repository.save(new Estudiante("Seba", "Perez", 20, "masculino", 40520425, "Tandil")));
			logger.info("preloading" + repository.save(new Estudiante("Jose", "Gomez", 21, "masculino", 41520425, "Tandil")));
		};
	}
	
	
	@Bean
	CommandLineRunner initCarrera(@Qualifier("carreraRepository") CarreraRepository repository) {
		return args -> {
			logger.info("preloading" + repository.save(new Carrera("TUDAI", 3)));
		};
	}
}
