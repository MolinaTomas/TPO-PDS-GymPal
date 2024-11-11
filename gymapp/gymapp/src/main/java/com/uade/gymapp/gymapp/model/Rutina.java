package com.uade.gymapp.gymapp.model;

import com.uade.gymapp.gymapp.model.dto.RutinaDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Rutina {
    private List<Entrenamiento> entrenamientos;
    private Objetivo objetivo;
    private List<Trofeo> Observadores;
    private static final int DURACION_SEMANAS = 4;

    public Rutina(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public RutinaDTO toDto() {
        return new RutinaDTO(entrenamientos.stream().map(Entrenamiento::toDto).toList(), objetivo.toDto());
    }

    public void agregarEntrenamiento(int dias, Entrenamiento entrenamiento) {
        if (entrenamiento.getEjercicios().stream().allMatch(objetivo::isEjercicioValido) &&
                isTiempoEntrenamientoValido(entrenamiento.getDuracion())) {
            entrenamientos.add(entrenamiento);
        } else {
            throw new IllegalArgumentException("Entrenamiento no válido para el objetivo actual.");
        }

        for(int i = 0; i < dias; i++) {

        }
    }

    public boolean isTiempoEntrenamientoValido(int duracion) {
        return duracion >= objetivo.getTiempoEntrenamientoMin() && duracion <= objetivo.getTiempoEntrenamientoMax();
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

    public void registrarProgreso() {

    }

    public void suscribirObservador(Trofeo observador) {
        this.Observadores.add(observador);
    }

    public void eliminarObservador(Trofeo observador) {
        this.Observadores.remove(observador);
    }
}
