package com.uade.gymapp.gymapp.model.repository;

import com.uade.gymapp.gymapp.model.entity.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SocioRepository extends JpaRepository<Socio, Long> {
}
