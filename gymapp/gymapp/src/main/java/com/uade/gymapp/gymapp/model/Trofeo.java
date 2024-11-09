package com.uade.gymapp.gymapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Trofeo {
    private Long id;
    private String nombre;

    // Constructor
    public Trofeo(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
