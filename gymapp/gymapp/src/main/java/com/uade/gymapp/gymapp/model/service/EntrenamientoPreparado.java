package com.uade.gymapp.gymapp.model.service;

import com.uade.gymapp.gymapp.model.service.EstadoEntrenamiento;
import org.springframework.stereotype.Service;

@Service
public class EntrenamientoPreparado implements EstadoEntrenamiento {

    @Override
    public void comenzar(Entrenamiento entrenamiento) {

    }

    @Override
    public void finalizar(Entrenamiento entrenamiento) {

    }

    @Override
    public String mostrarNombre() {
        return "";
    }
}