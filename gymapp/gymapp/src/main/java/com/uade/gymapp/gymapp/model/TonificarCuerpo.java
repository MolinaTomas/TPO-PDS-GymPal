package com.uade.gymapp.gymapp.model;

public class TonificarCuerpo extends Objetivo {

    @Override
    public boolean isAerobicoValido(int nivelAerobico) {
        return nivelAerobico <= 4;
    }

    @Override
    public boolean isEjercicioValido(Ejercicio ejercicio) {
        return !isAerobicoValido(ejercicio.getNivelAerobico())
                && ejercicio.getExigenciaMuscular() == ExigenciaMuscular.ALTO;
    }

    @Override
    public int getTiempoEntrenamientoMin() {
        return 120; // 2 horas
    }

    @Override
    public int getTiempoEntrenamientoMax() {
        return 150; // 2.5 horas
    }
}