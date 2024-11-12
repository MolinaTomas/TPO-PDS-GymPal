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
            List<Ejercicio> ejercicios = entrenamiento.getEjercicios();
            for (int i = 0; i < ejercicios.size(); i++) {
                Ejercicio ejercicio = ejercicios.get(i);
                // Crear el decorador que incrementa repeticiones, series y peso
                EjercicioRefuerzo refuerzo = new EjercicioRefuerzo(ejercicio);
                ejercicios.set(i, refuerzo); // Reemplazar el ejercicio original con el decorador
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
            observer.otorgarTrofeo(socio, socio.getMediciones().get(0));
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
