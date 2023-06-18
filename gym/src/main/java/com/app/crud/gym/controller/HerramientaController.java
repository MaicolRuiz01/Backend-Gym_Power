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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.crud.gym.entity.Herramienta;
import com.app.crud.gym.repository.HerramientaRopisotory;
@CrossOrigin
@RestController
@RequestMapping("/herramientas")
public class HerramientaController {
	
	@Autowired
	HerramientaRopisotory herramientarepo;
	
	@GetMapping()
	public ResponseEntity<?> listaHerrmientas(){
		try {
			
			return ResponseEntity.ok(herramientarepo.findAll());
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).body("no se encontro la herramienta");
		}
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveHerrmientas(@RequestBody Herramienta herramienta){
		try {
			
			return ResponseEntity.ok(herramientarepo.save(herramienta));
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).body("no se encontro la herramienta");
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateHerrmientas(@RequestBody Herramienta herramienta, @PathVariable Integer id){
		try {
			
			Optional<Herramienta> herramientaCurrent =herramientarepo.findById(id); // se busca el objeto mediante el id yse guarda en un objeto optional
			
			if(herramientaCurrent.isPresent()) {									// pregunta si el objeto no es nullo
				Herramienta herramientaReturn = herramientaCurrent.get();
				
				herramientaReturn.setNombre(herramienta.getNombre());
				herramientaReturn.setDescripcion(herramienta.getDescripcion());
				
				
				return ResponseEntity.ok(herramientarepo.save(herramientaReturn));
				

			}
			
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).body("no se encontro la herramienta");
		}
	}
		
		
		@GetMapping("/{id}")
		public ResponseEntity<?> getFindByIdHerrmientas(@PathVariable Integer id){
			try {
				
				Optional<Herramienta> herramientaCurrent =herramientarepo.findById(id); 
				
				if(herramientaCurrent.isPresent()) {									

					return ResponseEntity.ok(herramientaCurrent);
					
				}
				
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
				
			} catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.CONFLICT).body("no se encontro la herramienta");
			}
			
			
		
	}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> deleteHerrmientas(@PathVariable Integer id){
			try {
				
				Optional<Herramienta> herramientaCurrent =herramientarepo.findById(id); 
				
				if(herramientaCurrent.isPresent()) {									
					
					herramientarepo.deleteById(herramientaCurrent.get().getId());
					return ResponseEntity.ok(true);
					
				}
				
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
				
			} catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.CONFLICT).body("no se encontro la herramienta");
			}
			
			
		
	}
		
		
	
	
	

}
