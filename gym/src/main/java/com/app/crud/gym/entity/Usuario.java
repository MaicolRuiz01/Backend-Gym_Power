package com.app.crud.gym.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="id_rol")
	private Integer id_rol;
	private String nombre;
	private String apellido;
	private String documento;
	private Date fecha_nac;
	private String correo;
	private String contraseña;
	private String genero;

}
