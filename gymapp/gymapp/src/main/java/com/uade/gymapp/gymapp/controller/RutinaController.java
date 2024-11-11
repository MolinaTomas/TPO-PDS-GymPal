package com.uade.gymapp.gymapp.controller;

import com.uade.gymapp.gymapp.model.*;

import java.util.*;

public class RutinaController {

    private List<Ejercicio> ejerciciosDisponibles;

    public RutinaController() {
        // Inicializamos la lista de ejercicios disponibles
        ejerciciosDisponibles = inicializarEjercicios();
    }

    private List<Ejercicio> inicializarEjercicios() {
        List<Ejercicio> ejercicios = new ArrayList<>();
        // Ejercicios de cardio (alto nivel aeróbico)
        ejercicios.add(new Ejercicio(1L, "Cinta de correr", "Carrera continua con intervalos de intensidad", 3, 1, 0.0,
                8, ExigenciaMuscular.BAJO, "url_video_cinta"));

        // Ejercicios de fuerza (pecho)
        ejercicios.add(new Ejercicio(2L, "Press de banca", "Press de banca con barra", 4, 12, 40.0, 2,
                ExigenciaMuscular.ALTO, "url_video_press"));

        // Ejercicios de piernas
        ejercicios.add(new Ejercicio(3L, "Sentadillas", "Sentadillas con peso corporal", 4, 15, 0.0, 4,
                ExigenciaMuscular.ALTO, "url_video_sentadillas"));

        // Ejercicios de core
        ejercicios.add(new Ejercicio(4L, "Plancha", "Plancha isométrica", 3, 1, 0.0, 3, ExigenciaMuscular.MEDIO,
                "url_video_plancha"));

        // Ejercicios de espalda
        ejercicios.add(new Ejercicio(5L, "Dominadas", "Dominadas en barra", 4, 8, 0.0, 3, ExigenciaMuscular.ALTO,
                "url_video_dominadas"));

        return ejercicios;
    }

    public void crearRutina(Socio socio, Objetivo objetivo) {
        List<Ejercicio> ejerciciosSeleccionados = seleccionarEjerciciosSegunObjetivo(objetivo);

        List<Entrenamiento> entrenamientos = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Entrenamiento entrenamiento = new Entrenamiento(9223372036854775807L, 45, new Date(),
                    ejerciciosSeleccionados);
            entrenamientos.add(entrenamiento);
        }

        Rutina rutina = new Rutina(objetivo);
        socio.setRutina(rutina);
    }

    private List<Ejercicio> seleccionarEjerciciosSegunObjetivo(Objetivo objetivo) {
        List<Ejercicio> ejerciciosSeleccionados = new ArrayList<>();

        if (objetivo instanceof BajarDePeso) {
            // Para bajar de peso: ejercicios con nivel aeróbico >= 3
            for (Ejercicio ejercicio : ejerciciosDisponibles) {
                if (ejercicio.getNivelAerobico() >= 3) {
                    ejerciciosSeleccionados.add(ejercicio);
                }
            }
        } else if (objetivo instanceof TonificarCuerpo) {
            // Para tonificar: ejercicios con nivel aeróbico <= 4 y exigencia muscular alta
            for (Ejercicio ejercicio : ejerciciosDisponibles) {
                if (ejercicio.getNivelAerobico() <= 4 &&
                        ejercicio.getExigenciaMuscular() == ExigenciaMuscular.ALTO) {
                    ejerciciosSeleccionados.add(ejercicio);
                }
            }
        } else {
            // Para mantener figura: ejercicios con nivel aeróbico entre 2 y 4 y exigencia
            // media-baja
            for (Ejercicio ejercicio : ejerciciosDisponibles) {
                if (ejercicio.getNivelAerobico() >= 2 &&
                        ejercicio.getNivelAerobico() <= 4 &&
                        (ejercicio.getExigenciaMuscular() == ExigenciaMuscular.MEDIO ||
                                ejercicio.getExigenciaMuscular() == ExigenciaMuscular.BAJO)) {
                    ejerciciosSeleccionados.add(ejercicio);
                }
            }
        }

        return ejerciciosSeleccionados;
    }

    public void refuerzoRutina(Rutina rutina) {
        if (rutina == null || rutina.getEntrenamientos() == null) {
            System.out.println("Rutina o entrenamientos no disponibles");
            return;
        }

        for (Entrenamiento entrenamiento : rutina.getEntrenamientos()) {
            for (Ejercicio ejercicio : entrenamiento.getEjercicios()) {
                // Incrementar repeticiones, series y peso a cada ejercicio
                ejercicio.setRepeticiones(ejercicio.getRepeticiones() + 1);
                ejercicio.setSeries(ejercicio.getSeries() + 1);
                ejercicio.setPeso(ejercicio.getPeso() + 2.5);
            }
        }
    }
}
