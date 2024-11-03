package com.uade.gymapp.repository;

import com.uade.gymapp.model.EjercicioRealizado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EjercicioRealizadoRepositorio extends JpaRepository<EjercicioRealizado, Long> {
//    List<Ejercicio> findByNombreContaining(String nombre);
//
//    @Query("SELECT e FROM Ejercicio e WHERE e.exigenciaMuscular = :exigencia")
//    List<Ejercicio> findByExigenciaMuscular(@Param("exigencia") ExigenciaMuscular exigencia);
}