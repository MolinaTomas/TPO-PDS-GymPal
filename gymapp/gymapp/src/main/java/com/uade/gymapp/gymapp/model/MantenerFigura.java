package com.uade.gymapp.gymapp.model;

public class MantenerFigura extends Objetivo {

    @Override
    public boolean isAerobicoValido(int nivelAerobico) {
        return nivelAerobico >= 2 && nivelAerobico <= 4;
    }

    @Override
    public boolean isEjercicioValido(Ejercicio ejercicio) {
        return isAerobicoValido(ejercicio.getNivelAerobico())
                && ejercicio.getExigenciaMuscular() != ExigenciaMuscular.ALTO;
    }

    @Override
    public int getTiempoEntrenamientoMin() {
        return 45; // 45 minutos
    }

    @Override
    public int getTiempoEntrenamientoMax() {
        return 120; // 2 horas
    }
}