package com.uade.gymapp.gymapp.model;

public class EstadoEntrenamientoFinalizado implements EstadoEntrenamiento {
    @Override
    public void iniciar(Entrenamiento entrenamiento) {
        System.out.println("El entrenamiento ya ha finalizado y no puede reiniciarse.");
    }

    @Override
    public void finalizar(Entrenamiento entrenamiento) {
        System.out.println("El entrenamiento ya está finalizado.");
    }
}