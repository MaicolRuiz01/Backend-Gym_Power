package com.app.crud.gym.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.crud.gym.entity.Ejercicio;
import com.app.crud.gym.repository.EjercicioRepository;
@CrossOrigin
@RestController
@RequestMapping("/ejercicio")
public class EjercicioController {

	@Autowired
	EjercicioRepository ejerciciorepository;

	@GetMapping
	public ResponseEntity<?> listaEjercicios() {

		try {

			return ResponseEntity.ok(ejerciciorepository.findAll());

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

	}

	@PostMapping("/save")
	public ResponseEntity<?> saveEjercicio(@RequestBody Ejercicio ejercicio){
		
		try {
			return ResponseEntity.ok(ejerciciorepository.save(ejercicio));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateEjercicio(@RequestBody Ejercicio ejercicio, @PathVariable Integer id){
		
		try {
			Optional<Ejercicio> EjercicioCurrent=ejerciciorepository.findById(id);
			
			if(EjercicioCurrent.isPresent()) {
				Ejercicio ejercicioReturn=EjercicioCurrent.get();
				
				ejercicioReturn.setNombre(ejercicio.getNombre());
				ejercicioReturn.setLink(ejercicio.getLink());
				ejercicioReturn.setDescripcion(ejercicio.getDescripcion());
				ejercicioReturn.setRepeticiones(ejercicio.getRepeticiones());
				
				return ResponseEntity.ok(ejerciciorepository.save(ejercicioReturn));
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findByIdEjercicio(@PathVariable Integer id){
		
		try {
			Optional<Ejercicio> ejercicioCurrent=ejerciciorepository.findById(id);
			if(ejercicioCurrent.isPresent()) {
				
				return ResponseEntity.ok(ejercicioCurrent);
				
			}
			
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEjercicio(@PathVariable Integer id){
		
		try {
			
			Optional<Ejercicio> ejercicioCurrent=ejerciciorepository.findById(id);
			
			if(ejercicioCurrent.isPresent()) {
				
				ejerciciorepository.deleteById(ejercicioCurrent.get().getId());
				return ResponseEntity.ok(true);
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	
}
