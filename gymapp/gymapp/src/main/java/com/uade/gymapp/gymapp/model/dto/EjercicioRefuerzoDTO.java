package com.uade.gymapp.gymapp.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EjercicioRefuerzoDTO {
    private Long id;
    private EjercicioDTO ejercicioBase;

    public EjercicioRefuerzoDTO(Long id, EjercicioDTO ejercicioBase) {
        this.id = id;
        this.ejercicioBase = ejercicioBase;
    }
}
