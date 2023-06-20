package com.app.crud.gym.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.crud.gym.entity.Rutina;
import com.app.crud.gym.repository.RutinaRepository;

@RestController
@RequestMapping("/rutina")
@CrossOrigin
public class RutinaController {
	
	@Autowired
	RutinaRepository rutinaRepository;
	
	@GetMapping
	public ResponseEntity<?> listaRutina(){
		
		try {
			return ResponseEntity.ok(rutinaRepository.findAll());
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	@PostMapping("/save")
	public ResponseEntity<?> saveRutina(@RequestBody Rutina rutina){
		
		try {
			return ResponseEntity.ok(rutinaRepository.save(rutina));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findByIdRutina(@PathVariable Integer id){
		try {
			Optional<Rutina> RutinaCurrent=rutinaRepository.findById(id);
			if(RutinaCurrent.isPresent()) {
				
				return ResponseEntity.ok(RutinaCurrent);
				
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateRutina(@RequestBody Rutina rutina, @PathVariable Integer id){
		
		try {
			Optional<Rutina> RutinaCurrent=rutinaRepository.findById(id);
			if(RutinaCurrent.isPresent()) {
				Rutina RutinaReturn = RutinaCurrent.get();
				
				RutinaReturn.setTitulo(rutina.getTitulo());
				
				return ResponseEntity.ok(rutinaRepository.save(RutinaReturn));
				
				
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRutina(@PathVariable Integer id){
		
		try {
			Optional<Rutina> RutinaCurrent=rutinaRepository.findById(id);
			if(RutinaCurrent.isPresent()) {
				
				rutinaRepository.deleteById(RutinaCurrent.get().getId());
				 return ResponseEntity.ok(true);
			}
			
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}

}
