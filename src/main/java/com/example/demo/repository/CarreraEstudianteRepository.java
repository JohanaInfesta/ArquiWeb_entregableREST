package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CarreraEstudiante;

public interface CarreraEstudianteRepository extends JpaRepository<CarreraEstudiante, Integer>{

//	@Query("INSERT INTO carrera_estudiante (fk_carrera, fk_estudiante, inscripcion) VALUES (fk_carrera= :c, fk_estudiante= :e, inscripcion= :d) nativeQuery = true")
//	public CarreraEstudiante matricularEstudiante(int e, int c, LocalDate d);
}
