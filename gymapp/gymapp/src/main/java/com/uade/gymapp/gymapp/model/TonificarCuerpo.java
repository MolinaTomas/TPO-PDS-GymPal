package com.uade.gymapp.gymapp.model;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
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
    public Rutina generarRutina() {
        Rutina rutina = new Rutina();
        rutina.setObjetivo(this);
        rutina.generarEntrenamientos();
        return rutina;
    }

    @Override
    public void calcularProgreso(Socio socio) {

    }

}