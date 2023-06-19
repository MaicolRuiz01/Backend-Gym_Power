package com.app.crud.gym.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.crud.gym.entity.Ejercicio_rutina;

import com.app.crud.gym.repository.Ejercicio_rutinaRepository;


@RestController
@RequestMapping("/rutina/ejercicio")
public class Ejercicio_rutinaController {
	
	@Autowired
	 Ejercicio_rutinaRepository ejeRutRepo;
	
	@GetMapping()
	public ResponseEntity<?> listaEjercicioRutina(){
		try {
			
			return ResponseEntity.ok(ejeRutRepo.findAll());
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEjercicioRutina(@RequestBody Ejercicio_rutina ejerutina, @PathVariable Integer id){
		try {
			
			Optional<Ejercicio_rutina> ejerutinaCurrent =ejeRutRepo.findById(id);
			if(ejerutinaCurrent.isPresent()) {									
				Ejercicio_rutina ejerutinaReturn = ejerutinaCurrent.get();
				
				ejerutinaReturn.setId_ejercicio(ejerutina.getId_ejercicio());
				ejerutinaReturn.setId_rutina(ejerutina.getId_rutina());
	
				return ResponseEntity.ok(ejeRutRepo.save(ejerutinaReturn));
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).body("no se encontro la herramienta");
		}
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getFindByIdEjercicioRutina(@PathVariable Integer id){
		try {
			
			Optional<Ejercicio_rutina> ejerutinaCurrent =ejeRutRepo.findById(id);
			
			if(ejerutinaCurrent.isPresent()) {									

				return ResponseEntity.ok(ejerutinaCurrent);
				
			}
			
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
}

	@PostMapping("/save")
	public ResponseEntity<?> saveEjercicioRutina(@RequestBody Ejercicio_rutina ejerutina){
		try {
			return ResponseEntity.ok(ejeRutRepo.save(ejerutina));
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}

	
	@DeleteMapping("/{id}")
		public ResponseEntity<?> deleteEjercicioRutina(@PathVariable Integer id){
			try {
				
				Optional<Ejercicio_rutina> ejerutinaCurrent =ejeRutRepo.findById(id);  
				
				if(ejerutinaCurrent.isPresent()) {									
					
					ejeRutRepo.deleteById(ejerutinaCurrent.get().getId());
					return ResponseEntity.ok(true);
					
				}
				
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
				
			} catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			
			
		
	}
}
