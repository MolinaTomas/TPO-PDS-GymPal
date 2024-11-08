package com.uade.gymapp.gymapp.model;

import com.uade.gymapp.gymapp.model.dto.EjercicioRefuerzoDTO;

public class EjercicioRefuerzo {
    private Long id;
    private Ejercicio ejercicioBase;

    public EjercicioRefuerzo(Long id, Ejercicio ejercicioBase) {
        this.id = id;
        this.ejercicioBase = ejercicioBase;
    }

    public EjercicioRefuerzoDTO toDto() {
        return new EjercicioRefuerzoDTO(id, ejercicioBase.toDto());
    }
}
