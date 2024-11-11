package com.uade.gymapp.gymapp.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EjercicioRefuerzoDTO {
    private EjercicioDTO ejercicioBase;

    public EjercicioRefuerzoDTO (EjercicioDTO ejercicioBase) {
        this.ejercicioBase = ejercicioBase;
    }
}
