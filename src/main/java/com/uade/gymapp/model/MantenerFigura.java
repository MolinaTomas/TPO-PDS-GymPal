package com.uade.gymapp.model;

import javax.persistence.Entity;

@Entity
public class MantenerFigura extends Objetivo {
    @Override
    public Rutina generarRutina() {
        return null;
    }

    @Override
    public void calcularProgreso() {
    }
}
