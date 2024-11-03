package com.uade.gymapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Entity
public class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private int series;
    private int repeticiones;
    private double peso;
    private int nivelAerobico;
    private ExigenciaMuscular exigenciaMuscular;

    public Ejercicio() {
    }

    public Ejercicio(String nombre, String descripcion, int series, int repeticiones, double peso, int nivelAerobico, ExigenciaMuscular exigenciaMuscular) {
        // Validar que los valores ingresados sean válidos
        if (series <= 0 || repeticiones <= 0 || peso < 0 || nivelAerobico < 0) {
            throw new IllegalArgumentException("Los valores ingresados no son válidos");
        }
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.series = series;
        this.repeticiones = repeticiones;
        this.peso = peso;
        this.nivelAerobico = nivelAerobico;
        this.exigenciaMuscular = exigenciaMuscular;
    }

    public void modificarRepeticiones(int nuevasRepeticiones) {
        this.repeticiones = nuevasRepeticiones;
    }

    public void modificarPeso(double peso) {
        this.peso = peso;
    }

    public void modificarSeries(int series) {
        this.series = series;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getSeries() {
        return series;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public double getPeso() {
        return peso;
    }

    public int getNivelAerobico() {
        return nivelAerobico;
    }

    public void setNivelAerobico(int nivelAerobico) {
        this.nivelAerobico = nivelAerobico;
    }

    public ExigenciaMuscular getExigenciaMuscular() {
        return exigenciaMuscular;
    }

    public void setExigenciaMuscular(ExigenciaMuscular exigenciaMuscular) {
        this.exigenciaMuscular = exigenciaMuscular;
    }
}
