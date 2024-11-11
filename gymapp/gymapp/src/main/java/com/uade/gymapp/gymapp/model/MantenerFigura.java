package com.uade.gymapp.gymapp.model;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class MantenerFigura extends Objetivo {
    private final int duracionMinima = 45; // en minutos
    private final int duracionMaxima = 80; // en minutos (1 hora y 20)
    private final int nivelAerobicoMinimo = 2;
    private final int nivelAerobicoMaximo = 4;
    private final String nivelMuscular = "medio-bajo";

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
    public Rutina generarRutina() {
        Rutina rutina = new Rutina();
        // Crear ejercicios específicos para mantener la figura (nivel aeróbico 2-4)
        List<Ejercicio> ejercicios = getEjerciciosModerados(nivelAerobicoMinimo, nivelAerobicoMaximo);
        // Asignar los ejercicios a la rutina
        rutina.setEntrenamientos(armarEntrenamientos(ejercicios));
        return rutina;
    }

}