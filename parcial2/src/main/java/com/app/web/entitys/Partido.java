package com.app.web.entitys;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Partido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private Date fecha;
	
	
	
	@ManyToOne
	@JoinColumn(name="estadio_id")
	private Estadio estadio;
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "partido")
	private List<Resultado>resultados;

}
