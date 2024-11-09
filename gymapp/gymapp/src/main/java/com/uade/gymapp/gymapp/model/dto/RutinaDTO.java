package com.uade.gymapp.gymapp.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RutinaDTO {
    private Long id;
    private List<EntrenamientoDTO> entrenamientos;
    private ObjetivoDTO objetivo;

    public RutinaDTO(Long id, List<EntrenamientoDTO> entrenamientos, ObjetivoDTO objetivo) {
        this.id = id;
        this.entrenamientos = entrenamientos;
        this.objetivo = objetivo;
    }
}
