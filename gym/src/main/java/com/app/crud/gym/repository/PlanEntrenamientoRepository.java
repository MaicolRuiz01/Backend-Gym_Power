package com.app.crud.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.crud.gym.entity.PlanEntrenamiento;

public interface PlanEntrenamientoRepository extends JpaRepository<PlanEntrenamiento, Integer> {

}
