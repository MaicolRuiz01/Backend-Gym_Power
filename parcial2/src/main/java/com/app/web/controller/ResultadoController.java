package com.app.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.web.entitys.Resultado;
import com.app.web.repository.IResultadoRepository;


@RestController
@RequestMapping("/resultados")
@CrossOrigin
public class ResultadoController {
	@Autowired
	private IResultadoRepository resultadoRepo;
	
	
	@GetMapping
	public List<Resultado>lista(){
		return resultadoRepo.findAll();
	}
	
	@PostMapping
	public Resultado postResultado(@RequestBody Resultado resultado) {
		resultadoRepo.save(resultado);
		return resultado;
		
	}
	@PutMapping("/{id}")
	public Resultado putResultado(@PathVariable Integer id ,@RequestBody Resultado resultado) {
		Optional<Resultado>resultadoCurrent=resultadoRepo.findById(id);
		if(resultadoCurrent.isPresent()) {
			Resultado resultadoReturn=resultadoCurrent.get();
			resultadoReturn.setPartido(resultado.getPartido());
			resultadoReturn.setSeleccionId(resultado.getSeleccionId());
			resultadoReturn.setGoles(resultado.getGoles());
			resultadoReturn.setRojas(resultado.getRojas());
			resultadoReturn.setAmarillas(resultado.getAmarillas());
			resultadoRepo.save(resultadoReturn);
			return resultadoReturn;
		}
		return null;
	}

}
