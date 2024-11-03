package com.uade.gymapp.model;

import com.uade.gymapp.model.Intefaces.EstadoEntrenamiento;

public class EntrenamientoPreparado implements EstadoEntrenamiento {
    private static final String NOMBRE_ESTADO = "Entrenamiento Preparado";
    public void comenzar(Entrenamiento entrenamiento) {
        entrenamiento.setEstadoEntrenamiento(new EntrenamientoEnProgreso());
    }

    public void finalizar(Entrenamiento entrenamiento) {
        throw new UnsupportedOperationException("No se puede finalizar un entrenamiento antes de que este en progreso");
    }

    public String mostrarNombre() {
        return NOMBRE_ESTADO;
    }
}