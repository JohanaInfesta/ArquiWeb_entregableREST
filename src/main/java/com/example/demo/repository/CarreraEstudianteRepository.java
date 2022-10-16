package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Carrera;
import com.example.demo.model.CarreraEstudiante;

public interface CarreraEstudianteRepository extends JpaRepository<CarreraEstudiante, Integer>{

//	@Query("INSERT INTO carrera_estudiante (fk_carrera, fk_estudiante, inscripcion) VALUES (fk_carrera= :c, fk_estudiante= :e, inscripcion= :d) nativeQuery = true")
//	public CarreraEstudiante matricularEstudiante(int e, int c, LocalDate d);
	
	@Query("SELECT new com.example.demo.model.Carrera(c.nombre, c.duracionAnios) " //se le puede agregar el count al select pero hay que hacer un DTO
			+ "FROM Carrera c JOIN c.inscripcion i "
//			+ "JOIN carrera_estudiante ce ON c.carreraid = ce.fk_carrera "
//			+ "WHERE c.carreraID = ce.carrera "
			+ "GROUP BY c.carreraID "
			+ "ORDER BY count(i) DESC")
	public List<Carrera>getCarrerasOrder();
}
