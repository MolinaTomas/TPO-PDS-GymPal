package com.uade.gymapp.gymapp.model.service;

import org.springframework.stereotype.Service;

@Service
public interface EstadoEntrenamientoService {
    void comenzar(EntrenamientoService entrenamientoService);
    void finalizar(EntrenamientoService entrenamientoService);
}
