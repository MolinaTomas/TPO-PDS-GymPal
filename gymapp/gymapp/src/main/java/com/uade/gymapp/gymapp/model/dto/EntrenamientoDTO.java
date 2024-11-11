package com.uade.gymapp.gymapp.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class EntrenamientoDTO {
    private int duracion;
    private Date fecha;
    private List<EjercicioDTO> ejercicios;

    public EntrenamientoDTO(int duracion, Date fecha, List<EjercicioDTO> ejercicios) {
        this.duracion = duracion;
        this.fecha = fecha;
        this.ejercicios = ejercicios;
    }
}
