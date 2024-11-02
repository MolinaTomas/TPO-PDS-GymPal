package com.uade.gymapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Ejercicio {
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

    public void realizarEjercicio(int series, int repeticiones, float peso, int nivelAerobico) {

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
}
