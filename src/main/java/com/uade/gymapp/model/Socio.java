package com.uade.gymapp.model;

import com.uade.gymapp.model.Intefaces.EstadoEntrenamiento;

import java.util.List;

public class Socio {
    private int idSocio;
    private String name;
    private String apellido;
    private String sexo;
    private int edad;
    private int altura;
    private String mail;
    private Objetivo objetivo;
    private EstadoEntrenamiento estadoEntrenamiento;
    private List<Trofeo> trofeos;
    private Progreso progresoHistorial;
    private List<Medicion> mediciones;

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public void comenzarEntrenamiento() {

    }

    public void finalizarEntrenamiento() {

    }
}
