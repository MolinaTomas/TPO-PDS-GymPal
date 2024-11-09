package com.uade.gymapp.gymapp.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObjetivoDTO {
    private Long id;
    private boolean cumplido;
    private double progresoActual;

    public ObjetivoDTO(Long id, boolean cumplido, double progresoActual) {
        this.id = id;
        this.cumplido = cumplido;
        this.progresoActual = progresoActual;
    }
}
