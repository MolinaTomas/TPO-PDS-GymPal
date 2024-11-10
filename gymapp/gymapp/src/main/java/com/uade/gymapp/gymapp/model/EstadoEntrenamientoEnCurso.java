package com.uade.gymapp.gymapp.model;

public class EstadoEntrenamientoEnCurso implements EstadoEntrenamiento {
    @Override
    public void iniciar(Entrenamiento entrenamiento) {
        System.out.println("El entrenamiento ya está en curso.");
    }

    @Override
    public void finalizar(Entrenamiento entrenamiento) {
        System.out.println("Entrenamiento finalizado.");
        entrenamiento.setEstado(new EstadoEntrenamientoFinalizado());
    }
}