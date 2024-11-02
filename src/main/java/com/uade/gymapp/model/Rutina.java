package com.uade.gymapp.model;

import com.uade.gymapp.model.Intefaces.EstadoEntrenamiento;
import java.util.ArrayList;
import java.util.List;

public class Rutina {
    private List<Entrenamiento> entrenamientos;
    private List<Trofeo> observadores; //TODO revisar logica de observers
    private EstadoEntrenamiento estadoEntrenamiento;

    public Rutina(EstadoEntrenamiento estadoInicial) {
        this.estadoEntrenamiento = estadoInicial;
        this.entrenamientos = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

    // Getters y Setters
    public List<Entrenamiento> getEntrenamientos() {
        return entrenamientos;
    }

    public void setEntrenamientos(List<Entrenamiento> entrenamientos) {
        this.entrenamientos = entrenamientos;
    }

    public EstadoEntrenamiento getEstadoEntrenamiento() {
        return estadoEntrenamiento;
    }

    public void setEstadoEntrenamiento(EstadoEntrenamiento estadoEntrenamiento) {
        this.estadoEntrenamiento = estadoEntrenamiento;
    }

    // TODO revisar si esto es correcto
    public void agregarEntrenamiento(Entrenamiento entrenamiento) {
        this.entrenamientos.add(entrenamiento);
    }

    public void reforzarRutina() {
        for (Entrenamiento entrenamiento : entrenamientos) {
            List<Ejercicio> ejerciciosReforzados = new ArrayList<>();
            for (Ejercicio ejercicio : entrenamiento.getEjercicios()) {
                ejerciciosReforzados.add(new EjercicioRefuerzo(ejercicio));
            }
            entrenamiento.setEjercicios(ejerciciosReforzados);
        }
    }

    public void registrarProgreso() {
        notificarObservadores();
    }

    public void suscribirObservador(Trofeo observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    public void eliminarObservador(Trofeo observador) {
        observadores.remove(observador);
    }

    private void notificarObservadores() {
        for (Trofeo observador : observadores) {
            // Aquí podrías implementar la lógica de notificación específica
        }
    }
}