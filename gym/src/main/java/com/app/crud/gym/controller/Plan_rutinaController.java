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

import com.app.crud.gym.entity.Plan_rutina;

import com.app.crud.gym.repository.Plan_rutinaRepository;

@RestController
@RequestMapping("/plan/rutina")
public class Plan_rutinaController {
	
	@Autowired
	 Plan_rutinaRepository planRutRepo;
	
	@GetMapping()
	public ResponseEntity<?> listaPlanRutina(){
		try {
			
			return ResponseEntity.ok(planRutRepo.findAll());
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUsuarioPlan(@RequestBody Plan_rutina planRutina, @PathVariable Integer id){
		try {
			
			Optional<Plan_rutina> Plan_rutinaCurrent =planRutRepo.findById(id);
			if(Plan_rutinaCurrent.isPresent()) {									
				Plan_rutina usuarioPlanReturn = Plan_rutinaCurrent.get();
				
				usuarioPlanReturn.setId_plan(planRutina.getId_plan());
				usuarioPlanReturn.setId_rutina(planRutina.getId_rutina());
	
				return ResponseEntity.ok(planRutRepo.save(usuarioPlanReturn));
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).body("no se encontro la herramienta");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getFindByIdPlanRutina(@PathVariable Integer id){
		try {
			
			Optional<Plan_rutina> Plan_rutinaCurrent =planRutRepo.findById(id); 
			
			if(Plan_rutinaCurrent.isPresent())  {									

				return ResponseEntity.ok(Plan_rutinaCurrent);
				
			}
			
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveUsuarioPlan(@RequestBody Plan_rutina planRutina){
		try {
			return ResponseEntity.ok(planRutRepo.save(planRutina));
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	
	@DeleteMapping("/{id}")
		public ResponseEntity<?> deleteUsuarioPlan(@PathVariable Integer id){
			try {
				
				Optional<Plan_rutina> Plan_rutinaCurrent =planRutRepo.findById(id);  
				
				if(Plan_rutinaCurrent.isPresent()) {									
					
					planRutRepo.deleteById(Plan_rutinaCurrent.get().getId());
					return ResponseEntity.ok(true);
					
				}
				
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
				
			} catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			
			
		
	}

}
