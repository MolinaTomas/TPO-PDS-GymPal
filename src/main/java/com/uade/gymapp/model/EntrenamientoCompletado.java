package com.uade.gymapp.model;

import com.uade.gymapp.model.Intefaces.EstadoEntrenamiento;

public class EntrenamientoCompletado implements EstadoEntrenamiento {
    private static final String NOMBRE_ESTADO = "Entrenamiento Completado";
    public void comenzar(Entrenamiento entrenamiento) {
        throw new UnsupportedOperationException("El entrenamiento ya ha sido completado");
    }

    public void finalizar(Entrenamiento entrenamiento) {
        throw new UnsupportedOperationException("El entrenamiento ya ha sido completado");
    }

    public String mostrarNombre() {
        return NOMBRE_ESTADO;
    }
}
