package com.uade.gymapp.gymapp.model;

import com.uade.gymapp.gymapp.controller.SocioController;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class TonificarCuerpo extends Objetivo {
    private double masaMuscularInicial;
    private double masaMuscularIdeal;
    private double porcentajeGrasaInicial;
    private double porcentajeGrasaIdeal;


    public TonificarCuerpo() {
        super();
        this.cumplido = false;
        this.masaMuscularInicial = SocioController.getUsuarioActual().getMediciones().get(0).getMasaMuscular();
        this.masaMuscularIdeal = masaMuscularInicial * 1.25;
        this.porcentajeGrasaInicial = SocioController.getUsuarioActual().getMediciones().get(0).getPorcentajeGrasaCorporal();
        this.porcentajeGrasaIdeal = porcentajeGrasaInicial * 0.8;
    }

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
    public boolean cumpleObjetivo(Socio socio, Medicion medicion) {
        if (medicion.getMasaMuscular() >= this.masaMuscularIdeal && medicion.getPorcentajeGrasaCorporal() <= this.porcentajeGrasaIdeal) {
            this.cumplido = true;
        }
        return this.cumplido;
    }

    @Override
    public List<Ejercicio> generarEntrenamientos() {
        List<Ejercicio> ejerciciosSeleccionados = new ArrayList<>();

        ejerciciosSeleccionados.add(new Ejercicio("Press de banca", "Press de banca con barra", 4, 4, 20.0, 2,
                ExigenciaMuscular.ALTO, "url_video_press_banca"));
        ejerciciosSeleccionados.add(new Ejercicio("Sentadillas", "Sentadillas con barra", 4, 4, 25.0, 3,
                ExigenciaMuscular.ALTO, "url_video_sentadillas"));
        ejerciciosSeleccionados.add(new Ejercicio("Peso muerto", "Peso muerto con barra", 4, 4, 30.0, 2,
                ExigenciaMuscular.ALTO, "url_video_peso_muerto"));
        ejerciciosSeleccionados.add(new Ejercicio("Dominadas", "Dominadas en barra", 4, 4, 15.0, 2,
                ExigenciaMuscular.ALTO, "url_video_dominadas"));
        ejerciciosSeleccionados.add(new Ejercicio("Flexiones", "Flexiones de brazos", 4, 4, 10.0, 4,
                ExigenciaMuscular.ALTO, "url_video_flexiones"));

        return ejerciciosSeleccionados;
    }
}