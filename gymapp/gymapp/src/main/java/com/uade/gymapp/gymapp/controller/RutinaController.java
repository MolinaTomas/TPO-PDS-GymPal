package com.uade.gymapp.gymapp.controller;

import com.uade.gymapp.gymapp.model.*;

import java.util.*;

public class RutinaController {

    private List<Ejercicio> ejerciciosDisponibles;

    public void refuerzoRutina(Rutina rutina) {
        if (rutina == null || rutina.getEntrenamientos() == null) {
            System.out.println("Rutina o entrenamientos no disponibles");
            return;
        }

        for (Entrenamiento entrenamiento : rutina.getEntrenamientos()) {
            List<Ejercicio> ejercicios = entrenamiento.getEjercicios();
            for (int i = 0; i < ejercicios.size(); i++) {
                Ejercicio ejercicio = ejercicios.get(i);
                // Crear el decorador que incrementa repeticiones, series y peso
                EjercicioRefuerzo refuerzo = new EjercicioRefuerzo(ejercicio);
                ejercicios.set(i, refuerzo); // Reemplazar el ejercicio original con el decorador
            }
        }
    }
}
