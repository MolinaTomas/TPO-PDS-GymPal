package com.uade.gymapp.gymapp.model.dto;

import java.util.Date;
import java.util.List;

public class EntrenamientoDTO {
    private Long id;
    private int duracion;
    private Date fecha;
    private List<EjercicioDTO> ejercicios;

    public EntrenamientoDTO(Long id, int duracion, Date fecha, List<EjercicioDTO> ejercicios) {
        this.id = id;
        this.duracion = duracion;
        this.fecha = fecha;
        this.ejercicios = ejercicios;
    }

    // Getters y Setters
}
