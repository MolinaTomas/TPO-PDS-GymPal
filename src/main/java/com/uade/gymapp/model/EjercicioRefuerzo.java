package com.uade.gymapp.model;

import javax.persistence.Entity;

@Entity
public class EjercicioRefuerzo extends Ejercicio {
    @Override
    public void modificarRepeticiones(int nuevasRepeticiones) {
    }

    @Override
    public void modificarPeso(float peso) {
    }

    @Override
    public void modificarSeries(int series) {
    }
}
