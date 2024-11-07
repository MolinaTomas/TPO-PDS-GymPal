package com.uade.gymapp.gymapp.model.dto;

public class EjercicioRefuerzoDTO {
    private Long id;
    private EjercicioDTO ejercicioBase;

    public EjercicioRefuerzoDTO(Long id, EjercicioDTO ejercicioBase) {
        this.id = id;
        this.ejercicioBase = ejercicioBase;
    }

    // Getters y Setters
}
