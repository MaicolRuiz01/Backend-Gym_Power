package com.app.crud.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.crud.gym.entity.Ejercicio;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Integer>{

}
