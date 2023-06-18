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


import com.app.crud.gym.entity.Rol;

import com.app.crud.gym.repository.RolesRepository;

@RestController
@RequestMapping("/rol")
public class RolController {
	
	
	@Autowired
	RolesRepository rolRepository;
	
	@GetMapping
	public ResponseEntity<?> listaPlan() {

		try {

			return ResponseEntity.ok(rolRepository.findAll());

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

	}

	@PostMapping("/save")
	public ResponseEntity<?> saveRol(@RequestBody Rol rol){
		
		try {
			return ResponseEntity.ok(rolRepository.save(rol));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateRol(@RequestBody Rol rol, @PathVariable Integer id){
		
		try {
			Optional<Rol> rolCurrent=rolRepository.findById(id);
			
			if(rolCurrent.isPresent()) {
				Rol rolReturn=rolCurrent.get();
				
				
				rolReturn.setNombre(rol.getNombre());
				
				
				return ResponseEntity.ok(rolRepository.save(rolReturn));
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findByIdRol(@PathVariable Integer id){
		
		try {
			Optional<Rol> rolCurrent=rolRepository.findById(id);
			if(rolCurrent.isPresent()) {
				
				return ResponseEntity.ok(rolCurrent);
				
			}
			
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRol(@PathVariable Integer id){
		
		try {
			
			Optional<Rol> rolCurrent=rolRepository.findById(id);
			
			if(rolCurrent.isPresent()) {
				
				rolRepository.deleteById(rolCurrent.get().getId());
				return ResponseEntity.ok(true);
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	

}
