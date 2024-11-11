package com.uade.gymapp.gymapp.model;

import com.uade.gymapp.gymapp.model.dto.ObjetivoDTO;
import com.uade.gymapp.gymapp.model.observer.TrofeoDedicacionObserver;
import com.uade.gymapp.gymapp.model.observer.TrofeoObserver;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Objetivo {
    protected boolean cumplido;
    private double progresoActual;
    protected Rutina rutina;
    private List<TrofeoObserver> observers;

    public Objetivo() {
        this.progresoActual = 0.0;
        this.observers = new ArrayList<>();
        observers.add(new TrofeoDedicacionObserver());
    }

    public ObjetivoDTO toDto() {
        return new ObjetivoDTO(cumplido, progresoActual);
    }

    // Abstract methods for constraints
    public abstract boolean isAerobicoValido(int nivelAerobico);

    public abstract boolean isEjercicioValido(Ejercicio ejercicio);

    public abstract Rutina generarRutina();
    public abstract boolean cumpleObjetivo(Socio socio, Medicion medicion);

    public abstract List<Ejercicio> generarEntrenamientos();

    public void notifyObservers(Socio socio, Medicion medicion) {
        for (TrofeoObserver observer : observers) {
            observer.otorgarTrofeo(socio, medicion);
        }
    }
}