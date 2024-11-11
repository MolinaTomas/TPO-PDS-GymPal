package com.uade.gymapp.gymapp.model;

import com.uade.gymapp.gymapp.model.dto.RutinaDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Rutina {
    private Long id;
    private List<Entrenamiento> entrenamientos;
    private Objetivo objetivo;
    private List<Trofeo> Observadores;

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

    public void reforzarRutina() {

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
