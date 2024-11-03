package com.uade.gymapp.model;

import javax.persistence.OneToOne;

public class EjercicioRefuerzo extends Ejercicio {
    @OneToOne
    private Ejercicio ejercicioBase;
    private static final float FACTOR_PESO = 1.2f; // Porcentaje de aumento de peso. Ej: 1.2 = +20%
    private static final int FACTOR_REPETICIONES = 2; // Multiplicador de repeticiones o series. Ej: 2 = x2
    private static final int FACTOR_SERIES = 2;

    // Constructor
    public EjercicioRefuerzo(Ejercicio ejercicioBase) {
        super();
        this.ejercicioBase = ejercicioBase;
        this.setNombre(ejercicioBase.getNombre() + " (Reforzado)");
        this.setDescripcion(ejercicioBase.getDescripcion());
        reforzarEjercicio();
    }

    private void reforzarEjercicio() {
        // Aumentar peso en un 20%
        float nuevoPeso = ejercicioBase.getPeso() * FACTOR_PESO;
        ejercicioBase.modificarPeso(nuevoPeso);

        // Duplicar repeticiones
        int nuevasRepeticiones = ejercicioBase.getRepeticiones() * FACTOR_REPETICIONES;
        ejercicioBase.modificarRepeticiones(nuevasRepeticiones);

        // Duplicar series
        int nuevasSeries = ejercicioBase.getSeries() * FACTOR_SERIES;
        ejercicioBase.modificarSeries(nuevasSeries);

        // Aumentar nivel aeróbico
        this.setNivelAerobico(ejercicioBase.getNivelAerobico() + 1);

        // Mantener la misma exigencia muscular
        this.setExigenciaMuscular(ejercicioBase.getExigenciaMuscular());
    }

    @Override
    public EjercicioRealizado realizarEjercicio(int series, int repeticiones, float peso, int nivelAerobico) {
        ejercicioBase.realizarEjercicio(
                series * FACTOR_SERIES,
                repeticiones * FACTOR_REPETICIONES,
                peso * FACTOR_PESO,
                nivelAerobico + 1);
        return null;
    }

    @Override
    public void modificarRepeticiones(int nuevasRepeticiones) {
        ejercicioBase.modificarRepeticiones(nuevasRepeticiones * FACTOR_REPETICIONES);
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
        return ejercicioBase;
    }
}