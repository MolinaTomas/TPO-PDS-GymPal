package com.uade.gymapp.model;

import javax.persistence.OneToOne;

public class EjercicioRefuerzo extends Ejercicio {
    @OneToOne
    private Ejercicio ejercicioBase;

    // Constructor
    public EjercicioRefuerzo(Ejercicio ejercicioBase) {
        this.ejercicioBase = ejercicioBase;
    }

    // Constructor vacío requerido por JPA
    public EjercicioRefuerzo() {
    }

    // Getters y Setters
    public Ejercicio getEjercicioBase() {
        return ejercicioBase;
    }

    public void setEjercicioBase(Ejercicio ejercicioBase) {
        this.ejercicioBase = ejercicioBase;
    }

    @Override
    public void modificarRepeticiones(int nuevasRepeticiones) {
        ejercicioBase.modificarRepeticiones(nuevasRepeticiones);
    }

    @Override
    public void modificarPeso(float peso) {
        ejercicioBase.modificarPeso(peso);
    }

    @Override
    public void modificarSeries(int series) {
        ejercicioBase.modificarSeries(series);
    }
}