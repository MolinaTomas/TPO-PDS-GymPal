package com.uade.gymapp.gymapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mediciones {
    private double peso;
    private double porcentajeGrasaCorporal;
    private double masaMuscular;

    public Mediciones() {
    }

    public Mediciones(double peso, double porcentajeGrasaCorporal, double masaMuscular) {
        this.peso = peso;
        this.porcentajeGrasaCorporal = porcentajeGrasaCorporal;
        this.masaMuscular = masaMuscular;
    }
}
