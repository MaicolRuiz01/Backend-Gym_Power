package com.app.web.entitys;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Resultado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name="partido_id")
	private Integer partido;
	@Column(name="seleccion_id")
	private Integer seleccionId;
	private Integer goles;
	private Integer amarillas;
	private Integer rojas;

}
