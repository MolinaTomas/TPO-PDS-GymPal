package com.uade.gymapp.gymapp.model;

import com.uade.gymapp.gymapp.model.dto.EjercicioRefuerzoDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EjercicioRefuerzo extends Ejercicio{
    private Ejercicio ejercicioBase;

    public EjercicioRefuerzo(Ejercicio ejercicioBase) {
        super();
        this.ejercicioBase = ejercicioBase;
    }

    @Override
    public int getRepeticiones() {
        return this.ejercicioBase.getRepeticiones() + 3;
    }

    @Override
    public double getPeso() {
        return this.ejercicioBase.getPeso() + 5;
    }

    @Override
    public int getSeries() {
        return this.ejercicioBase.getSeries() + 1;
    }

    public EjercicioRefuerzoDTO haciaDto() {
        return new EjercicioRefuerzoDTO(ejercicioBase.toDto());
    }
}
