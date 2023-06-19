package com.app.crud.gym.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="ejercicios")
@Data
public class Ejercicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	@ManyToOne
	@JoinColumn(name = "id_herramienta")
	private Herramienta herramienta;
	private String nombre;
	private String link;
	private String descripcion;
	private String repeticiones;
	
	

}
