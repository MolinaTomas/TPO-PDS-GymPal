package com.uade.gymapp.gymapp.model.service;


import org.springframework.stereotype.Service;

@Service
public class EjercicioRefuerzo extends Ejercicio {

    private void reforzarEjercicio() {

    }

    @Override
    public EjercicioRealizado realizarEjercicio(int series, int repeticiones, float peso, int nivelAerobico) {

    }

    @Override
    public void modificarRepeticiones(int nuevasRepeticiones) {
    }

    @Override
    public void modificarPeso(float peso) {
        ejercicioBase.modificarPeso(peso * FACTOR_PESO);
    }

    @Override
    public void modificarSeries(int series) {
        ejercicioBase.modificarSeries(series * FACTOR_SERIES);
    }

    // Getters que reflejan los valores reforzados
    @Override
    public int getRepeticiones() {
        return ejercicioBase.getRepeticiones() * FACTOR_REPETICIONES;
    }

    @Override
    public float getPeso() {
        return ejercicioBase.getPeso() * FACTOR_PESO;
    }

    @Override
    public int getSeries() {
        return ejercicioBase.getSeries() * FACTOR_SERIES;
    }

    public Ejercicio getEjercicioBase() {

    }
}