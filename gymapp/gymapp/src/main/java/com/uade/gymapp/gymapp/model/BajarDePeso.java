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

    @Override
    public List<Ejercicio> generarEntrenamientos() {
        List<Ejercicio> ejerciciosSeleccionados = new ArrayList<>();

        ejerciciosSeleccionados.add(new Ejercicio("Running", "Correr en cinta", 3, 4, 10.0, 5,
                ExigenciaMuscular.BAJO, "url_video_running"));
        ejerciciosSeleccionados.add(new Ejercicio("Bicicleta", "Bicicleta fija", 3, 3, 15.0, 4,
                ExigenciaMuscular.BAJO, "url_video_bicicleta"));
        ejerciciosSeleccionados.add(new Ejercicio("Elíptico", "Ejercicio en elíptico", 3, 3, 20.0, 5,
                ExigenciaMuscular.BAJO, "url_video_eliptico"));
        ejerciciosSeleccionados.add(new Ejercicio("Salto de soga", "Saltos de soga", 3, 3, 5.0, 5,
                ExigenciaMuscular.BAJO, "url_video_soga"));
        ejerciciosSeleccionados.add(new Ejercicio("Natación", "Nadar en piscina", 3, 3, 30.0, 4,
                ExigenciaMuscular.BAJO, "url_video_natacion"));

        return ejerciciosSeleccionados;
    }

}

