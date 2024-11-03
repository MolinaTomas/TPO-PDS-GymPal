package com.uade.gymapp.model;

import com.uade.gymapp.model.Intefaces.EstadoEntrenamiento;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Entrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int duracion; // en horas
    @OneToMany
    private List<Ejercicio> ejercicios;
    private Date fecha;
    private EstadoEntrenamiento estadoEntrenamiento;

    // Constructor
    public Entrenamiento(int duracion, Date fecha) {
        this.duracion = duracion;
        this.ejercicios = new ArrayList<Ejercicio>(); // instancio arraylist
        this.fecha = fecha;
        this.estadoEntrenamiento = new EntrenamientoPreparado();
    }

    public Entrenamiento() {}

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public void addEjercicio(Ejercicio ejercicio) {
        this.ejercicios.add(ejercicio);
    }

    public void removeEjercicio(Ejercicio ejercicio) {
        this.ejercicios.remove(ejercicio);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public EstadoEntrenamiento getEstadoEntrenamiento() {
        return estadoEntrenamiento;
    }

    public void setEstadoEntrenamiento(EstadoEntrenamiento estadoEntrenamiento) {
        this.estadoEntrenamiento = estadoEntrenamiento;
        System.out.println("Estado actual: " + estadoEntrenamiento.mostrarNombre());
    }

    public void comenzarEntrenamiento() { // pasa el contexto que requiere el state
        estadoEntrenamiento.comenzar(this);
    }

    public void finalizarEntrenamiento() { // pasa el contexto que requiere el state
        estadoEntrenamiento.finalizar(this);
    }


}
