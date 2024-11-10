package com.uade.gymapp.gymapp.model;

public class BajarDePeso extends Objetivo {

    @Override
    public boolean isAerobicoValido(int nivelAerobico) {
        return nivelAerobico >= 3;
    }

    @Override
    public boolean isEjercicioValido(Ejercicio ejercicio) {
        return isAerobicoValido(ejercicio.getNivelAerobico());
    }

    @Override
    public int getTiempoEntrenamientoMin() {
        return 60; // 1 hora
    }

    @Override
    public int getTiempoEntrenamientoMax() {
        return 90; // 1.5 horas
    }
}