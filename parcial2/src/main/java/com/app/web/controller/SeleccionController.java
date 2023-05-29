package com.app.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.web.entitys.Seleccion;
import com.app.web.repository.ISeleccionRepository;



@RestController
@RequestMapping("/selecciones")
@CrossOrigin
public class SeleccionController {
	@Autowired
	private ISeleccionRepository seleccionRepo;
	
	@GetMapping
	public List<Seleccion> lista(){
		return seleccionRepo.findAll();
	}
	@GetMapping("/{id}")
	public Optional<Seleccion> findSeleccionById(@PathVariable Integer id){
		Optional<Seleccion>seleccion=seleccionRepo.findById(id);
		if(seleccion.isPresent()) {
			return seleccion;
		}
		return null;
		
	}
	
	
	@PostMapping
	public Seleccion postSeleccion(@RequestBody Seleccion seleccion) {
		seleccionRepo.save(seleccion);
		return seleccion;
	}
	
	
	@PutMapping
	public Seleccion putSeleccion(@PathVariable Integer id,@RequestBody Seleccion seleccion) {
		Optional<Seleccion>seleccionCurrent=seleccionRepo.findById(id);
		
		
		if(seleccionCurrent.isPresent()) {
			Seleccion seleccionReturn =seleccionCurrent.get();
			seleccionReturn.setNombre(seleccion.getNombre());
			seleccionReturn.setContinente(seleccion.getContinente());
			seleccionReturn.setGrupo(seleccion.getGrupo());
			seleccionRepo.save(seleccionReturn);
			return seleccionReturn;
		}
		return null;
	}
	@DeleteMapping("/{id}")
	public Seleccion deleteSeleccion(@PathVariable Integer id ) {
		Optional<Seleccion>seleccion=seleccionRepo.findById(id);
		
		if(seleccion.isPresent()) {
			seleccionRepo.deleteById(id);
			return seleccion.get();
		}
		return null;
	}
	
	@GetMapping("/grupo/{grupo}")
	public List<Seleccion> seleccionByGrupo(@PathVariable String grupo){
		
		return seleccionRepo.findByGrupo(grupo);
	}
	
	@GetMapping
	public String lista(Model model) {
	    List<Seleccion> selecciones = seleccionRepo.findAll();
	    model.addAttribute("selecciones", selecciones);
	    return "index";
	}
	

	
	

}
