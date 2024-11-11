package com.uade.gymapp.gymapp.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Medicion {
    private LocalDateTime fechaYhora;
    private double peso;
    private double porcentajeGrasaCorporal;
    private double masaMuscular;

    public Medicion(String date, double peso, double porcentajeGrasaCorporal, double masaMuscular) {
    }

    public Medicion(LocalDateTime fechaYhora, double peso, double porcentajeGrasaCorporal, double masaMuscular) {
        this.fechaYhora = fechaYhora;
        this.peso = peso;
        this.porcentajeGrasaCorporal = porcentajeGrasaCorporal;
        this.masaMuscular = masaMuscular;
    }
}
