package com.uade.gymapp.gymapp.model;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
        rutina.setObjetivo(this);
        rutina.generarEntrenamientos();
        return rutina;
    }

    @Override
    public void calcularProgreso(Socio socio) {

    }

    @Override
    public List<Ejercicio> generarEntrenamientos() {
        List<Ejercicio> ejerciciosSeleccionados = new ArrayList<>();

        ejerciciosSeleccionados.add(new Ejercicio("Yoga", "Sesión de yoga", 2, 3, 0.0, 2,
                ExigenciaMuscular.MEDIO, "url_video_yoga"));
        ejerciciosSeleccionados.add(new Ejercicio("Pilates", "Clase de pilates", 2, 3, 0.0, 2,
                ExigenciaMuscular.MEDIO, "url_video_pilates"));
        ejerciciosSeleccionados.add(new Ejercicio("Caminata", "Caminata ligera", 2, 3, 5.0, 3,
                ExigenciaMuscular.MEDIO, "url_video_caminata"));
        ejerciciosSeleccionados.add(new Ejercicio("Ciclismo", "Ciclismo moderado", 2, 3, 10.0, 3,
                ExigenciaMuscular.MEDIO, "url_video_ciclismo"));
        ejerciciosSeleccionados.add(new Ejercicio("Natación suave", "Nadar suavemente", 2, 3, 15.0, 3,
                ExigenciaMuscular.MEDIO, "url_video_natacion_suave"));

        return ejerciciosSeleccionados;
    }

}