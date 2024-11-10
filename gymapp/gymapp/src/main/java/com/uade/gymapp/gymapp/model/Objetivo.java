package com.uade.gymapp.gymapp.model;

import com.uade.gymapp.gymapp.model.dto.ObjetivoDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Objetivo {
    private Long id;
    private boolean cumplido;
    private double progresoActual;

    public Objetivo() {
    }

    public Objetivo(Long id, boolean cumplido, double progresoActual) {
        this.id = id;
        this.cumplido = cumplido;
        this.progresoActual = progresoActual;
    }

    public ObjetivoDTO toDto() {
        return new ObjetivoDTO(id, cumplido, progresoActual);
    }
}