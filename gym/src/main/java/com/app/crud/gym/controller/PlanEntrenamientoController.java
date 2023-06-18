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


import com.app.crud.gym.entity.PlanEntrenamiento;
import com.app.crud.gym.repository.PlanEntrenamientoRepository;

@RestController
@RequestMapping("/plan")
public class PlanEntrenamientoController {
	
	@Autowired
	PlanEntrenamientoRepository planRepository;
	
	@GetMapping
	public ResponseEntity<?> listaPlan() {

		try {

			return ResponseEntity.ok(planRepository.findAll());

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

	}

	@PostMapping("/save")
	public ResponseEntity<?> savePlan(@RequestBody PlanEntrenamiento plan){
		
		try {
			return ResponseEntity.ok(planRepository.save(plan));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updatePlan(@RequestBody PlanEntrenamiento plan, @PathVariable Integer id){
		
		try {
			Optional<PlanEntrenamiento> PlanCurrent=planRepository.findById(id);
			
			if(PlanCurrent.isPresent()) {
				PlanEntrenamiento planReturn=PlanCurrent.get();
				
				
				planReturn.setNombre(plan.getNombre());
				planReturn.setDescripcion(plan.getDescripcion());
				
				return ResponseEntity.ok(planRepository.save(planReturn));
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findByIdPlan(@PathVariable Integer id){
		
		try {
			Optional<PlanEntrenamiento> PlanCurrent=planRepository.findById(id);
			if(PlanCurrent.isPresent()) {
				
				return ResponseEntity.ok(PlanCurrent);
				
			}
			
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePlan(@PathVariable Integer id){
		
		try {
			
			Optional<PlanEntrenamiento> PlanCurrent=planRepository.findById(id);
			
			if(PlanCurrent.isPresent()) {
				
				planRepository.deleteById(PlanCurrent.get().getId());
				return ResponseEntity.ok(true);
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

}
