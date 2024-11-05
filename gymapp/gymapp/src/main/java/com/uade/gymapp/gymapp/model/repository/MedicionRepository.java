package com.uade.gymapp.gymapp.model.repository;

import com.uade.gymapp.gymapp.model.entity.MedicionService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicionRepository extends JpaRepository<MedicionService, Long> {
}
