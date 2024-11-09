package com.uade.gymapp.gymapp.model;

import java.time.LocalDateTime;

public class Mediciones {
    private LocalDateTime fecha;
    private double peso;
    private double porcentajeGrasaCorporal;
    private double masaMuscular;

    public Mediciones() {
    }

    public Mediciones(double peso, double porcentajeGrasaCorporal, double masaMuscular) {
        this.peso = peso;
        this.porcentajeGrasaCorporal = porcentajeGrasaCorporal;
        this.masaMuscular = masaMuscular;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPorcentajeGrasaCorporal() {
        return porcentajeGrasaCorporal;
    }

    public void setPorcentajeGrasaCorporal(double porcentajeGrasaCorporal) {
        this.porcentajeGrasaCorporal = porcentajeGrasaCorporal;
    }

    public double getMasaMuscular() {
        return masaMuscular;
    }

    public void setMasaMuscular(double masaMuscular) {
        this.masaMuscular = masaMuscular;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
