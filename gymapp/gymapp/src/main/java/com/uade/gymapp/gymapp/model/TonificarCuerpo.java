package com.uade.gymapp.gymapp.model;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class TonificarCuerpo extends Objetivo {
    private final int nivelAerobicoMaximo = 4;
    private final String nivelMuscular = "alto"; // Ejercicios fuertes en ejercitación muscular
    private final int duracionMinima = 120; // en minutos (2 horas)
    private final int duracionMaxima = 150; // en minutos (2.5 horas)
    private double masaMuscularIdeal;
    private double porcentajeGrasaIdeal;

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
        // Crear ejercicios específicos para tonificar cuerpo (fuerza muscular)
        List<Ejercicio> ejercicios = getEjerciciosFuerza(nivelAerobicoMaximo);
        // Asignar los ejercicios a la rutina
        rutina.setEntrenamientos(armarEntrenamientos(ejercicios));
        return rutina;
    }

}