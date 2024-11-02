package com.uade.gymapp.model;

import java.util.Date;

public class EjercicioRealizado {
    private Entrenamiento entrenamiento;
    private Ejercicio ejercicio;
    private Date fecha;
    private int seriesRealizadas;
    private int repeticionesHechas;
    private double pesoLevantado;

    // Constructor
    public EjercicioRealizado(Entrenamiento entrenamiento, Ejercicio ejercicio, Date fecha,
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
