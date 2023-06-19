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

import com.app.crud.gym.entity.Usuario;
import com.app.crud.gym.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@GetMapping
	public ResponseEntity<?> listaUsuario(){
		try {
			return ResponseEntity.ok(usuarioRepository.findAll());
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findByIdUsuario(@PathVariable Integer id){
		
		try {
			Optional<Usuario> UsuarioCurrent=usuarioRepository.findById(id);
			
			if(UsuarioCurrent.isPresent()) {
				return ResponseEntity.ok(UsuarioCurrent);
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario){
		try {
			return ResponseEntity.ok(usuarioRepository.save(usuario));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario, @PathVariable Integer id){
		try {
			Optional<Usuario> UsuarioCurrent= usuarioRepository.findById(id);
			if(UsuarioCurrent.isPresent()) {
				Usuario usuarioReturn = UsuarioCurrent.get();
				
				usuarioReturn.setId_rol(usuario.getId_rol());
				usuarioReturn.setNombre(usuario.getNombre());
				usuarioReturn.setApellido(usuario.getApellido());
				usuarioReturn.setDocumento(usuario.getDocumento());
				usuarioReturn.setGenero(usuario.getGenero());
				usuarioReturn.setFecha_nac(usuario.getFecha_nac());
				usuarioReturn.setCorreo(usuario.getCorreo());
				usuarioReturn.setContraseña(usuario.getContraseña());
				
				return ResponseEntity.ok(usuarioRepository.save(usuarioReturn));
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable Integer id){
		
		try {
			Optional<Usuario> UsuarioCurrent = usuarioRepository.findById(id);
			if(UsuarioCurrent.isPresent()) {
				
				usuarioRepository.deleteById(UsuarioCurrent.get().getId());
				
				return ResponseEntity.ok(true);
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
}
