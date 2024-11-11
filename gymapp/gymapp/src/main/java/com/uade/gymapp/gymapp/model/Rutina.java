package com.uade.gymapp.gymapp.model;

import com.uade.gymapp.gymapp.model.dto.RutinaDTO;
import com.uade.gymapp.gymapp.model.observer.TrofeoConstanciaObserver;
import com.uade.gymapp.gymapp.model.observer.TrofeoObserver;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Rutina {
    private List<Entrenamiento> entrenamientos;
    private Objetivo objetivo;
    private List<TrofeoObserver> observadores;

    public Rutina(Objetivo objetivo) {
        this.objetivo = objetivo;
        this.entrenamientos = new ArrayList<>();
        generarEntrenamientos();
        this.observadores = new ArrayList<>();
        observadores.add(new TrofeoConstanciaObserver());
    }

    public RutinaDTO toDto() {
        return new RutinaDTO(entrenamientos.stream().map(Entrenamiento::toDto).toList(), objetivo.toDto());
    }

    public void refuerzoRutina() {
        if (getEntrenamientos() == null) {
            System.out.println("entrenamientos no disponibles");
            return;
        }

        for (Entrenamiento entrenamiento : getEntrenamientos()) {
            for (Ejercicio ejercicio : entrenamiento.getEjercicios()) {
                // Incrementar repeticiones, series y peso a cada ejercicio
                ejercicio.setRepeticiones(ejercicio.getRepeticiones() + 1);
                ejercicio.setSeries(ejercicio.getSeries() + 1);
                ejercicio.setPeso(ejercicio.getPeso() + 2.5);
            }
        }
    }

    public void registrarProgreso(Socio socio) {
        notifyObservers(socio);
    }

    public void suscribirObservador(TrofeoObserver observador) {
        this.observadores.add(observador);
    }

    public void eliminarObservador(TrofeoObserver observador) {
        this.observadores.remove(observador);
    }

    public void notifyObservers(Socio socio) {
        for (TrofeoObserver observer : observadores) {
            observer.otorgarTrofeo(socio, null);
        }
    }

    // Recordar agregar socio en notifyObservers y reforzarRutina cuando se codee

    public void generarEntrenamientos() {
        for (int i = 0; i < 2; i++) {
            List<Ejercicio> ejerciciosSeleccionados = this.objetivo.generarEntrenamientos();

            Entrenamiento entrenamiento = new Entrenamiento();
            entrenamiento.setEjercicios(ejerciciosSeleccionados);

            this.entrenamientos.add(entrenamiento);
        }
    }
}
