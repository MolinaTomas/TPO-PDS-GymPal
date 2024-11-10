package com.uade.gymapp.gymapp.model;

import com.uade.gymapp.gymapp.model.dto.EntrenamientoDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
public class Entrenamiento {
    private Long id;
    private int duracion;
    private Date fecha;
    private List<Ejercicio> ejercicios;
    private List<EjercicioRealizado> ejerciciosRealizados;
    private EstadoEntrenamiento estado;

    public Entrenamiento(Long id, int duracion, Date fecha, List<Ejercicio> ejercicios) {
        this.id = id;
        this.duracion = duracion;
        this.fecha = fecha;
        this.ejercicios = ejercicios;
        this.ejerciciosRealizados = new ArrayList<>();
        this.estado = new EstadoEntrenamientoListo(); // Initial state
    }

    public void iniciar() {
        estado.iniciar(this);
    }

    public void finalizar() {
        estado.finalizar(this);
    }

    public void addEjercicioRealizado(EjercicioRealizado ejercicioRealizado) {
        this.ejerciciosRealizados.add(ejercicioRealizado);
    }

    public EntrenamientoDTO toDto() {
        return new EntrenamientoDTO(id, duracion, fecha, ejercicios.stream().map(Ejercicio::toDto).toList());
    }
}
