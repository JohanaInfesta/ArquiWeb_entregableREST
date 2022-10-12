package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Carrera {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int carreraID;
	
	@Column
	private String nombre;
	
 	@OneToMany(mappedBy = "carrera", fetch=FetchType.LAZY)
	private List<CarreraEstudiante>estudiantes;
 	
 	@Column
 	private int duracionAnios;

	public Carrera() {
		super();
	}

	public Carrera(String nombre, int duracionAnios) {
		this.nombre = nombre;
		this.duracionAnios = duracionAnios;
	}

	public int getCarreraID() {
		return carreraID;
	}

	public String getNombre() {
		return nombre;
	}

	public List<CarreraEstudiante> getEstudiantes() {
		return estudiantes;
	}

	public int getDuracionAnios() {
		return duracionAnios;
	}

	@Override
	public String toString() {
		return "Carrera [nombre=" + nombre + ", duracionAnios=" + duracionAnios + "]";
	}
 	
 	
}
