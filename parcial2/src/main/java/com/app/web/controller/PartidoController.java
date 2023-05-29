package com.app.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.web.entitys.Partido;
import com.app.web.entitys.Resultado;
import com.app.web.repository.IPartidoRepository;


@RestController
@RequestMapping("/partidos")
@CrossOrigin
public class PartidoController {
	
	
	@Autowired
	private IPartidoRepository partidoRepo;
	
	@GetMapping
	public List<Partido>lista(){
		return partidoRepo.findAll();
	}
	
	@GetMapping("/{id}/resultados")
	public List<Resultado> partidoResultado(@PathVariable Integer id){
		Optional<Partido>partido=partidoRepo.findById(id);
		if(partido.isPresent()) {
			return partido.get().getResultados();
		}
		return null;
	}

}
