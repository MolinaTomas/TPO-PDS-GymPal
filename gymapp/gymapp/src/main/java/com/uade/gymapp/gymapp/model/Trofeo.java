package com.uade.gymapp.gymapp.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Trofeo {
    private Long id;
    private String nombre;
    private LocalDateTime fechaYhora;

    // Constructor
    public Trofeo(Long id, String nombre, LocalDateTime fechaYhora) {
        this.id = id;
        this.nombre = nombre;
        this.fechaYhora = fechaYhora;
    }
}
