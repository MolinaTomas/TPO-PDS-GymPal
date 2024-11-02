package com.uade.gymapp.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Objetivo {
    private Rutina rutina;
    private List<Trofeo> observadores;
    private boolean cumplido;
    private double progresoActual;
    private double progresoObjetivo;

    public Objetivo() {
        this.observadores = new ArrayList<>();
        this.cumplido = false;
        this.progresoActual = 0.0;
        this.progresoObjetivo = 100.0;
    }

    public abstract Rutina generarRutina();

    public abstract void calcularProgreso();

    public void cumplirObjetivo() {
        if (progresoActual >= progresoObjetivo) {
            this.cumplido = true;
            notificarObservadores();
        }
    }

    public void actualizarProgreso(double nuevoProgreso) {
        this.progresoActual = nuevoProgreso;
        calcularProgreso();
        if (progresoActual >= progresoObjetivo) {
            cumplirObjetivo();
        }
    }

    public void suscribirObservador(Trofeo observador) {
        if (!observadores.contains(observador)) {
            this.observadores.add(observador);
        }
    }

    public void eliminarObservador(Trofeo observador) {
        this.observadores.remove(observador);
    }

    private void notificarObservadores() {
        for (Trofeo observador : observadores) {
            observador.cumpleCondicion(null); // Aquí deberías pasar el Socio correspondiente
        }
    }

    // Getters y Setters
    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }

    public boolean isCumplido() {
        return cumplido;
    }

    public void setCumplido(boolean cumplido) {
        this.cumplido = cumplido;
    }

    public double getProgresoActual() {
        return progresoActual;
    }

    public void setProgresoActual(double progresoActual) {
        this.progresoActual = progresoActual;
    }

    public double getProgresoObjetivo() {
        return progresoObjetivo;
    }

    public void setProgresoObjetivo(double progresoObjetivo) {
        this.progresoObjetivo = progresoObjetivo;
    }

    public List<Trofeo> getObservadores() {
        return observadores;
    }
}