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
        List<Entrenamiento> entrenamientos = new ArrayList<>();
        for (int i = 0; i < cantidadEntrenamientos; i++) {
            Entrenamiento entrenamiento = new Entrenamiento();
            List<Ejercicio> ejerciciosEntrenamiento = generarEjerciciosAerobicos();
            entrenamiento.setEjercicios(ejerciciosEntrenamiento);
            entrenamientos.add(entrenamiento);
        }
        rutina.setEntrenamientos();
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

    private List<Ejercicio> generarEjerciciosAerobicos() {
        List<Ejercicio> ejerciciosAerobicos = new ArrayList<>();

        // Crear ejercicios específicos para "Bajar de Peso"
        ejerciciosAerobicos.add(new Ejercicio("Running", "Correr en cinta", 3, 4, 10));
        ejerciciosAerobicos.add(new Ejercicio("Bicicleta", "Bicicleta fija", 3, 3, 15));
        ejerciciosAerobicos.add(new Ejercicio("Elíptico", "Ejercicio en elíptico", 3, 3, 20));
        ejerciciosAerobicos.add(new Ejercicio("Salto de soga", "Saltos de soga", 3, 3, 5));

        return ejerciciosAerobicos;
    }
}

