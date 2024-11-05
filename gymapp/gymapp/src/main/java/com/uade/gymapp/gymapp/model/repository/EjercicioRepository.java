package com.uade.gymapp.gymapp.model.repository;

import com.uade.gymapp.gymapp.model.entity.Ejercicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Long> {
}
