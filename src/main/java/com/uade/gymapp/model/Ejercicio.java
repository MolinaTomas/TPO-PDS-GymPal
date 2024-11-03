package com.uade.gymapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Entity
public class Ejercicio { //TODO ver de incluir el video demostrativo del ejercicio
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private int series;
    private int repeticiones;
    private float peso;
    private int nivelAerobico;
    private ExigenciaMuscular exigenciaMuscular;
    private String videoUrl;

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Ejercicio() {
    }

    public Ejercicio(String nombre, String descripcion, int series, int repeticiones, float peso, int nivelAerobico, ExigenciaMuscular exigenciaMuscular) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.series = series;
        this.repeticiones = repeticiones;
        this.peso = peso;
        this.nivelAerobico = nivelAerobico;
        this.exigenciaMuscular = exigenciaMuscular;
    }

    public EjercicioRealizado realizarEjercicio(int series, int repeticiones, float peso, int nivelAerobico) {
        // Validar que los valores ingresados sean válidos
        if (series <= 0 || repeticiones <= 0 || peso < 0 || nivelAerobico < 0) {
            throw new IllegalArgumentException("Los valores ingresados no son válidos");
        }

        // Crear registro del ejercicio realizado
        EjercicioRealizado ejercicioRealizado = new EjercicioRealizado(
                null, // El entrenamiento se setea desde la clase Entrenamiento
                this,
                new Date(),
                series,
                repeticiones,
                peso);

        // Actualizar las métricas del ejercicio si superan las actuales
        if (series > this.series) {
            this.series = series;
        }
        if (repeticiones > this.repeticiones) {
            this.repeticiones = repeticiones;
        }
        if (peso > this.peso) {
            this.peso = peso;
        }
        if (nivelAerobico > this.nivelAerobico) {
            this.nivelAerobico = nivelAerobico;
        }

        // Retornar el ejercicio realizado para que pueda ser agregado al entrenamiento
        return ejercicioRealizado;
    }

    public void modificarRepeticiones(int nuevasRepeticiones) {
        this.repeticiones = nuevasRepeticiones;
    }

    public void modificarPeso(float peso) {
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

    public float getPeso() {
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
