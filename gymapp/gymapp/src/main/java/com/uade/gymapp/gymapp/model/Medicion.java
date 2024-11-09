package com.uade.gymapp.gymapp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@Setter
public class Medicion {
    private LocalDateTime fechaYhora;
    private double peso;
    private double porcentajeGrasaCorporal;
    private double masaMuscular;

    public Medicion() {
    }

    public Medicion(LocalDateTime fechaYhora, double peso, double porcentajeGrasaCorporal, double masaMuscular) {
        this.fechaYhora = fechaYhora;
        this.peso = peso;
        this.porcentajeGrasaCorporal = porcentajeGrasaCorporal;
        this.masaMuscular = masaMuscular;
    }
}
