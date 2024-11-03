package com.uade.gymapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class EjercicioRealizado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Entrenamiento entrenamiento;
    private Ejercicio ejercicio;
    private LocalDateTime fecha;
    private int seriesRealizadas;
    private int repeticionesHechas;
    private double pesoLevantado;

    // Constructor
    public EjercicioRealizado(Entrenamiento entrenamiento, Ejercicio ejercicio, LocalDateTime fecha,
            int seriesRealizadas, int repeticionesHechas, double pesoLevantado) {
        this.entrenamiento = entrenamiento;
        this.ejercicio = ejercicio;
        this.fecha = fecha;
        this.seriesRealizadas = seriesRealizadas;
        this.repeticionesHechas = repeticionesHechas;
        this.pesoLevantado = pesoLevantado;
    }

    // Getters y Setters
    public Entrenamiento getEntrenamiento() {
        return entrenamiento;
    }

    public void setEntrenamiento(Entrenamiento entrenamiento) {
        this.entrenamiento = entrenamiento;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getSeriesRealizadas() {
        return seriesRealizadas;
    }

    public void setSeriesRealizadas(int seriesRealizadas) {
        this.seriesRealizadas = seriesRealizadas;
    }

    public int getRepeticionesHechas() {
        return repeticionesHechas;
    }

    public void setRepeticionesHechas(int repeticionesHechas) {
        this.repeticionesHechas = repeticionesHechas;
    }

    public double getPesoLevantado() {
        return pesoLevantado;
    }

    public void setPesoLevantado(double pesoLevantado) {
        this.pesoLevantado = pesoLevantado;
    }
}
