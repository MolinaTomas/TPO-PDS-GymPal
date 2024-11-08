package com.uade.gymapp.gymapp.model;

import com.uade.gymapp.gymapp.model.ExigenciaMuscular;
import com.uade.gymapp.gymapp.model.dto.EjercicioDTO;

public class Ejercicio {
    private Long id;
    private String nombre;
    private String descripcion;
    private int series;
    private int repeticiones;
    private double peso;
    private int nivelAerobico;
    private ExigenciaMuscular exigenciaMuscular;
    private String videoUrl;

    public Ejercicio(Long id, String nombre, String descripcion, int series, int repeticiones, double peso,
            int nivelAerobico, ExigenciaMuscular exigenciaMuscular, String videoUrl) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.series = series;
        this.repeticiones = repeticiones;
        this.peso = peso;
        this.nivelAerobico = nivelAerobico;
        this.exigenciaMuscular = exigenciaMuscular;
        this.videoUrl = videoUrl;
    }

    public EjercicioDTO toDto() {
        return new EjercicioDTO(id, nombre, descripcion, series, repeticiones, peso, nivelAerobico, exigenciaMuscular,
                videoUrl);
    }
}
