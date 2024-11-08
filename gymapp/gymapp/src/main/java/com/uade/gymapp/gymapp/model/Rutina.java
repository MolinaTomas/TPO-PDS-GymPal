package com.uade.gymapp.gymapp.model;

import com.uade.gymapp.gymapp.model.dto.RutinaDTO;

import java.util.List;

public class Rutina {
    private Long id;
    private List<Entrenamiento> entrenamientos;
    private Objetivo objetivo;

    public Rutina(Long id, List<Entrenamiento> entrenamientos, Objetivo objetivo) {
        this.id = id;
        this.entrenamientos = entrenamientos;
        this.objetivo = objetivo;
    }

    public RutinaDTO toDto() {
        return new RutinaDTO(id, entrenamientos.stream().map(Entrenamiento::toDto).toList(), objetivo.toDto());
    }
}
