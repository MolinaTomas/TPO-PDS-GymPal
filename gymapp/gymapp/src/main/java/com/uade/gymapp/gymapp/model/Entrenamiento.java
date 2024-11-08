package com.uade.gymapp.gymapp.model;

import com.uade.gymapp.gymapp.model.dto.EntrenamientoDTO;

import java.util.Date;
import java.util.List;

public class Entrenamiento {
    private Long id;
    private int duracion;
    private Date fecha;
    private List<Ejercicio> ejercicios;

    public Entrenamiento(Long id, int duracion, Date fecha, List<Ejercicio> ejercicios) {
        this.id = id;
        this.duracion = duracion;
        this.fecha = fecha;
        this.ejercicios = ejercicios;
    }

    public EntrenamientoDTO toDto() {
        return new EntrenamientoDTO(id, duracion, fecha, ejercicios.stream().map(Ejercicio::toDto).toList());
    }
}
