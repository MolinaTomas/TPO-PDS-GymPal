package com.uade.gymapp.service;

import com.uade.gymapp.model.Ejercicio;
import com.uade.gymapp.repository.EjercicioRealizadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjercicioService {
    @Autowired
    private EjercicioRealizadoRepositorio ejercicioRealizadoRepositorio;

    public List<Ejercicio> obtenerTodosLosEjercicios() {
        return ejercicioRealizadoRepositorio.findAll();
    }

    public Ejercicio obtenerEjercicioPorId(Long id) {
        return ejercicioRealizadoRepositorio.findById(id).orElse(null);
    }

    public Ejercicio crearEjercicio(Ejercicio ejercicio) {
        return ejercicioRealizadoRepositorio.save(ejercicio);
    }

    public void eliminarEjercicio(Long id) {
        ejercicioRealizadoRepositorio.deleteById(id);
    }
}