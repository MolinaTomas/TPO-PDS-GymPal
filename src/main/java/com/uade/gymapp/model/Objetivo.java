package com.uade.gymapp.model;

import java.util.List;

public abstract class Objetivo {
    private Rutina rutina;
    private List<Trofeo> observadores;

    public abstract Rutina generarRutina();

    public abstract void calcularProgreso();

    public void cumplirObjetivo() {

    }

    public void suscribirObservador(Trofeo observador) {
        this.observadores.add(observador);
    }

    public void eliminarObservador(Trofeo observador) {
        this.observadores.remove(observador);
    }
}
