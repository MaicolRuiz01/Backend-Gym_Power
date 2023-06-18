package com.app.crud.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.crud.gym.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
