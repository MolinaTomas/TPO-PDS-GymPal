package com.uade.gymapp.model;

import com.uade.gymapp.model.Intefaces.EstadoEntrenamiento;

public class EntrenamientoEnProgreso implements EstadoEntrenamiento {
    private static final String NOMBRE_ESTADO = "Entrenamiento En Progreso";
    public void comenzar(Entrenamiento entrenamiento) {
        throw new UnsupportedOperationException("No se puede comenzar un entrenamiento el cual ya esta en progreso");
    }

    public void finalizar(Entrenamiento entrenamiento) {
        entrenamiento.setEstadoEntrenamiento(new EntrenamientoCompletado());
    }

    public String mostrarNombre() {
        return NOMBRE_ESTADO;
    }
}
