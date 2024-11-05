package com.uade.gymapp.gymapp.model.service;

import com.uade.gymapp.gymapp.model.service.Entrenamiento;
import org.springframework.stereotype.Service;

@Service
public interface EstadoEntrenamiento {
    void comenzar(Entrenamiento entrenamiento);
    void finalizar(Entrenamiento entrenamiento);

    String mostrarNombre();
}
