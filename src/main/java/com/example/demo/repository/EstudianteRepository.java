package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{

	@Query("SELECT e FROM Estudiante e WHERE e.libreta= :libreta")
	public Estudiante getEstudianteById(int libreta);
	
	@Query("SELECT e FROM Estudiante e WHERE e.genero= :genero")
	public List<Estudiante>getEstudianteByGenero(String genero);
	
}
