package com.app.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.web.entitys.Seleccion;



public interface ISeleccionRepository extends JpaRepository<Seleccion, Integer>{
	
	
	public List<Seleccion>findByGrupo(String grupo);

}
