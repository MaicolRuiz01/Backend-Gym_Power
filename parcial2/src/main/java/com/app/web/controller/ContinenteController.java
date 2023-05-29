package com.app.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.web.entitys.Continente;
import com.app.web.repository.IContinenteRepository;



@RestController
@RequestMapping("/continentes")
@CrossOrigin
public class ContinenteController {
	
	@Autowired
	private IContinenteRepository continenteRepo;
	
	@GetMapping
	public List<Continente>listar(){
		return continenteRepo.findAll();
		
	}
	
	
	
	
	@GetMapping("/{id}")
	public Optional<Continente>findContieneById(@PathVariable Integer id ){
		Optional<Continente> continente=continenteRepo.findById(id);
		if(continente.isPresent()) {
			return continente;
		}
		return null;
	}
	
	
	
	
	
	@PostMapping
	public Continente postContinente(@RequestBody Continente continente) {
		continenteRepo.save(continente);
		return continente;
	}
	
	
	
	
	@PutMapping("/{id}")
	public Continente putContinente(@PathVariable Integer id,@RequestBody Continente continente) {
		Optional<Continente>continenteCurrent=continenteRepo.findById(id);
		if(continenteCurrent.isPresent()) {
			Continente continenteReturn=continenteCurrent.get();
			continenteReturn.setNombre(continente.getNombre());
			continenteRepo.save(continenteReturn);
		}
		return null;
	}
	
	
	
	@DeleteMapping("/{id}")
	public Continente deleteContinente(@PathVariable Integer id) {
		Optional<Continente>continente=continenteRepo.findById(id);
		if(continente.isPresent()) {
			continenteRepo.deleteById(id);
			return continente.get();
		}
		return null;
	}

}
