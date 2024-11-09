package com.uade.gymapp.gymapp.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicionDTO {
    private double peso;
    private double porcentajeGrasaCorporal;
    private double masaMuscular;

    public MedicionDTO() {
    }

    public MedicionDTO(double peso, double porcentajeGrasaCorporal, double masaMuscular) {
        this.peso = peso;
        this.porcentajeGrasaCorporal = porcentajeGrasaCorporal;
        this.masaMuscular = masaMuscular;
    }

}
