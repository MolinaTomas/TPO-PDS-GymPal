package com.uade.gymapp.gymapp.model;


import lombok.Data;

@Data
public class ValoresIdeales {

    private double masaMuscularIdeal;
    private double porcentajeGrasaIdeal;

    public ValoresIdeales(String sexo) {
        if (sexo.equalsIgnoreCase("masculino")) {
            this.masaMuscularIdeal = 38.0;
            this.porcentajeGrasaIdeal = 15.0;// Ejemplo de valor ideal en porcentaje para hombres
        } else if (sexo.equalsIgnoreCase("femenino")) {
            this.masaMuscularIdeal = 30.0;
            this.porcentajeGrasaIdeal = 22;// Ejemplo de valor ideal en porcentaje para mujeres
        } else {
            throw new IllegalArgumentException("Sexo no válido. Debe ser 'masculino' o 'femenino'.");
        }
    }
}
