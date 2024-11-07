package com.uade.gymapp.gymapp.model.dto;

import java.util.List;

public class RutinaDTO {
    private Long id;
    private List<EntrenamientoDTO> entrenamientos;
    private ObjetivoDTO objetivo;

    public RutinaDTO(Long id, List<EntrenamientoDTO> entrenamientos, ObjetivoDTO objetivo) {
        this.id = id;
        this.entrenamientos = entrenamientos;
        this.objetivo = objetivo;
    }

    // Getters y Setters
}
