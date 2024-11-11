package com.uade.gymapp.gymapp.model;

import com.uade.gymapp.gymapp.model.dto.EjercicioRealizadoDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EjercicioRealizado {
    private Long id;
    private Entrenamiento entrenamiento;
    private Ejercicio ejercicio;
    private LocalDateTime fecha;
    private int seriesRealizadas;
    private int repeticionesHechas;
    private double pesoLevantado;

    public EjercicioRealizado() {}

    public EjercicioRealizado(Entrenamiento entrenamiento, Ejercicio ejercicio, LocalDateTime fecha,
                              int seriesRealizadas, int repeticionesHechas, double pesoLevantado) {
        this.entrenamiento = entrenamiento;
        this.ejercicio = ejercicio;
        this.fecha = fecha;
        this.seriesRealizadas = seriesRealizadas;
        this.repeticionesHechas = repeticionesHechas;
        this.pesoLevantado = pesoLevantado;
    }

    public EjercicioRealizado(Long id, Entrenamiento entrenamiento, Ejercicio ejercicio, LocalDateTime fecha,
            int seriesRealizadas, int repeticionesHechas, double pesoLevantado) {
        this.id = id;
        this.entrenamiento = entrenamiento;
        this.ejercicio = ejercicio;
        this.fecha = fecha;
        this.seriesRealizadas = seriesRealizadas;
        this.repeticionesHechas = repeticionesHechas;
        this.pesoLevantado = pesoLevantado;
    }

//    public EjercicioRealizadoDTO toDto() {
//        return new EjercicioRealizadoDTO(id, entrenamiento.toDto(), ejercicio.toDto(), fecha, seriesRealizadas,
//                repeticionesHechas, pesoLevantado);
//    }
}
