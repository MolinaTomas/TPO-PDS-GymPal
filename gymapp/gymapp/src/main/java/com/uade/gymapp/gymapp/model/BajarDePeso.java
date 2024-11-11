package com.uade.gymapp.gymapp.model;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class BajarDePeso extends Objetivo {

    private double pesoIdeal; // Peso objetivo al que debe llegar el usuario
    private final int duracionMinima = 60; // en minutos (1 hora)
    private final int duracionMaxima = 90; // en minutos (1.5 horas)
    private final int nivelAerobicoMinimo = 3;
    private int cantidadEntrenamientos;

    @Override
    public boolean isAerobicoValido(int nivelAerobico) {
        return nivelAerobico >= 3;
    }

    @Override
    public boolean isEjercicioValido(Ejercicio ejercicio) {
        return isAerobicoValido(ejercicio.getNivelAerobico());
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
        // Utilizar las mediciones para calcular el progreso del socio
        for (Medicion medicion : socio.getMediciones()) {
            if (medicion.getPeso() <= this.pesoIdeal) {
                this.cumplido = true;
                break;
            }
        }
    }

}

