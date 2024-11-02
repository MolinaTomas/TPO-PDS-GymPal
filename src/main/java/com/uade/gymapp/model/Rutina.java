package com.uade.gymapp.model;

import com.uade.gymapp.model.Intefaces.EstadoEntrenamiento;
import java.util.List;

public class Rutina {
    private List<Entrenamiento> entrenamientos;
    private List<Trofeo> observadores;
    private EstadoEntrenamiento estadoEntrenamiento;

    public Rutina(EstadoEntrenamiento estadoInicial) {
        this.estadoEntrenamiento = estadoInicial;
    }

    public EstadoEntrenamiento getEstadoEntrenamiento() {
        return estadoEntrenamiento;
    }

    public void setEstadoEntrenamiento(EstadoEntrenamiento estadoEntrenamiento) {
        this.estadoEntrenamiento = estadoEntrenamiento;
    }

    public void comenzar() {
        estadoEntrenamiento.comenzar();
    }

    public void finalizar() {
        estadoEntrenamiento.finalizar();
    }

    public void reforzarRutina() {
        // Implementación específica
    }

    public void registrarProgreso() {

    }

    public void suscribirObservador(Trofeo observador) {

    }

    public void eliminarObservador(Trofeo observador) {

    }
}
