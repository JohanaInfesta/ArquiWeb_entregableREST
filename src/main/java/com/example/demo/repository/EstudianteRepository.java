package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{

	//querys faltantes
	@Query("SELECT e FROM Estudiante e WHERE e.libreta= :libreta")
	public Estudiante getEstudianteById(int libreta);
	
	
}
