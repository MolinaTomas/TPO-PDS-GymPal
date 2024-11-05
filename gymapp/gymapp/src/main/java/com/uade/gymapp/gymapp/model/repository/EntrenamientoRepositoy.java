package com.uade.gymapp.gymapp.model.repository;

import com.uade.gymapp.gymapp.model.entity.Entrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenamientoRepositoy extends JpaRepository<Entrenamiento, Long> {
}
