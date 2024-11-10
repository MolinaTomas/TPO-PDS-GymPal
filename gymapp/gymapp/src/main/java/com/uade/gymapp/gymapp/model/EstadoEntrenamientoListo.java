package com.uade.gymapp.gymapp.model;

public class EstadoEntrenamientoListo implements EstadoEntrenamiento {
    @Override
    public void iniciar(Entrenamiento entrenamiento) {
        System.out.println("Entrenamiento iniciado.");
        entrenamiento.setEstado(new EstadoEntrenamientoEnCurso());
    }

    @Override
    public void finalizar(Entrenamiento entrenamiento) {
        System.out.println("El entrenamiento no puede finalizar porque aún no ha comenzado.");
    }
}