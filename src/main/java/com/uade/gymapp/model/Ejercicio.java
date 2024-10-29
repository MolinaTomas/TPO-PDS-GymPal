package com.uade.gymapp.model;


public abstract class Ejercicio {
    private String nombre;
    private String descripcion;
    private int series;
    private int repeticiones;
    private float peso;
    private int nivelAerobico;
    private ExigenciaMuscular exigenciaMuscular;

    public void realizarEjercicio(int series, int repeticiones, float peso, int nivelAerobico) {

    }

    public abstract void modificarRepeticiones(int nuevasRepeticiones);
    public abstract void modificarPeso(float peso);
    public abstract void modificarSeries(int series);
}
