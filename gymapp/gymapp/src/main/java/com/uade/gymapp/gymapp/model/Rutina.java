package com.uade.gymapp.gymapp.model;

import com.uade.gymapp.gymapp.model.dto.RutinaDTO;
import com.uade.gymapp.gymapp.model.observer.TrofeoObserver;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Rutina {
    private Long id;
    private List<Entrenamiento> entrenamientos;
    private Objetivo objetivo;
    private List<TrofeoObserver> Observadores;

    public Rutina(Long id, List<Entrenamiento> entrenamientos, Objetivo objetivo) {
        this.id = id;
        this.entrenamientos = entrenamientos;
        this.objetivo = objetivo;
    }

    public RutinaDTO toDto() {
        return new RutinaDTO(id, entrenamientos.stream().map(Entrenamiento::toDto).toList(), objetivo.toDto());
    }

    public void addEntrenamiento(Entrenamiento entrenamiento) {
        if (entrenamiento.getEjercicios().stream().allMatch(objetivo::isEjercicioValido) &&
                isTiempoEntrenamientoValido(entrenamiento.getDuracion())) {
            entrenamientos.add(entrenamiento);
        } else {
            throw new IllegalArgumentException("Entrenamiento no válido para el objetivo actual.");
        }
    }

    public boolean isTiempoEntrenamientoValido(int duracion) {
        return duracion >= objetivo.getTiempoEntrenamientoMin() && duracion <= objetivo.getTiempoEntrenamientoMax();
    }

    public void reforzarRutina(Socio socio) {
        notifyObservers(socio);
    }

    public void registrarProgreso(Socio socio) {
        notifyObservers(socio);
    }

    public void suscribirObservador(TrofeoObserver observador) {
        this.Observadores.add(observador);
    }

    public void eliminarObservador(TrofeoObserver observador) {
        this.Observadores.remove(observador);
    }

    public void notifyObservers(Socio socio) {
        for (TrofeoObserver observer : Observadores) {
            observer.otorgarTrofeo(socio);
        }
    }

    // Recordar agregar socio en notifyObservers y reforzarRutina cuando se codee
}
