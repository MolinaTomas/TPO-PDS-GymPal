package com.uade.gymapp.model;

import com.uade.gymapp.model.Intefaces.EstadoEntrenamiento;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Entrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int duracion;
    @OneToMany
    private List<Ejercicio> ejercicios;
    private Date fecha;
    private EstadoEntrenamiento estadoEntrenamiento;

    // Constructor
    public Entrenamiento(int duracion, List<Ejercicio> ejercicios, Date fecha) {
        this.duracion = duracion;
        this.ejercicios = ejercicios;
        this.fecha = fecha;
        this.estadoEntrenamiento = new EntrenamientoPreparado();
    }

    public Entrenamiento() {

    }

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

    public void addEjercicio(Ejercicio dfd) {
        this.ejercicios = ejercicios;
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
    }


}
