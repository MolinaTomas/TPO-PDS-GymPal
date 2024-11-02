package com.uade.gymapp.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Entrenamiento {
    private int duracion;
    @OneToMany
    private List<Ejercicio> ejercicios;
    private Date fecha;

    // Constructor
    public Entrenamiento(int duracion, List<Ejercicio> ejercicios, Date fecha) {
        this.duracion = duracion;
        this.ejercicios = ejercicios;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
