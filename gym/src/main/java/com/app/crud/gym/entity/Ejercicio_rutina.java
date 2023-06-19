package com.app.crud.gym.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="ejercicio_rutina")
public class Ejercicio_rutina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="id_ejercicio")
	private Integer id_ejercicio;
	@Column(name="id_rutina")
	private Integer id_rutina;

}
