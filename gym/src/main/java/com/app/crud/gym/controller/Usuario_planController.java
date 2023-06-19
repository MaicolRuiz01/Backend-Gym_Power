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


import com.app.crud.gym.entity.Usuario_plan;
import com.app.crud.gym.repository.Usuario_planRepository;

@RestController
@RequestMapping("/usuario/plan")
public class Usuario_planController {
	
	
	@Autowired
	Usuario_planRepository usuPlanRepo;
	
	@GetMapping()
	public ResponseEntity<?> listaUsuarioPlan(){
		try {
			
			return ResponseEntity.ok(usuPlanRepo.findAll());
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUsuarioPlan(@RequestBody Usuario_plan usuarioplan, @PathVariable Integer id){
		try {
			
			Optional<Usuario_plan> usuarioPlanCurrent =usuPlanRepo.findById(id);
			if(usuarioPlanCurrent.isPresent()) {									
				Usuario_plan usuarioPlanReturn = usuarioPlanCurrent.get();
				
				usuarioPlanReturn.setId_plan(usuarioplan.getId_plan());
				usuarioPlanReturn.setId_usuario(usuarioplan.getId_usuario());
	
				return ResponseEntity.ok(usuPlanRepo.save(usuarioPlanReturn));
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).body("no se encontro la herramienta");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getFindByIdUsuarioPlan(@PathVariable Integer id){
		try {
			
			Optional<Usuario_plan> usuarioPlanCurrent =usuPlanRepo.findById(id); 
			
			if(usuarioPlanCurrent.isPresent()) {									

				return ResponseEntity.ok(usuarioPlanCurrent);
				
			}
			
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveUsuarioPlan(@RequestBody Usuario_plan usuarioplan){
		try {
			return ResponseEntity.ok(usuPlanRepo.save(usuarioplan));
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	
	@DeleteMapping("/{id}")
		public ResponseEntity<?> deleteUsuarioPlan(@PathVariable Integer id){
			try {
				
				Optional<Usuario_plan> usuarioPlanCurrent =usuPlanRepo.findById(id);  
				
				if(usuarioPlanCurrent.isPresent()) {									
					
					usuPlanRepo.deleteById(usuarioPlanCurrent.get().getId());
					return ResponseEntity.ok(true);
					
				}
				
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
				
			} catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			
			
		
	}
	

}
