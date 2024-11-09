package com.uade.gymapp.gymapp.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MedicionDTO {
    private LocalDateTime fechaYhora;
    private double peso;
    private double porcentajeGrasaCorporal;
    private double masaMuscular;

    public MedicionDTO() {
    }

    public MedicionDTO(LocalDateTime fechaYhora, double peso, double porcentajeGrasaCorporal, double masaMuscular) {
        this.fechaYhora = fechaYhora;
        this.peso = peso;
        this.porcentajeGrasaCorporal = porcentajeGrasaCorporal;
        this.masaMuscular = masaMuscular;
    }

}
