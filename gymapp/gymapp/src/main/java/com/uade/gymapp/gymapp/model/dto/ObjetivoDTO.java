package com.uade.gymapp.gymapp.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObjetivoDTO {
    private boolean cumplido;
    private double progresoActual;

    public ObjetivoDTO(boolean cumplido, double progresoActual) {
        this.cumplido = cumplido;
        this.progresoActual = progresoActual;
    }
}
