package com.uade.gymapp.gymapp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import com.uade.gymapp.gymapp.model.observer.TrofeoObserver;

@Getter
@Setter
public class Socio {
    private Long id;
    private String name;
    private String apellido;
    private String sexo;
    private int edad;
    private int altura;
    private String mail;
    private String password;
    private Objetivo objetivo;
    private List<Trofeo> trofeos;
    private List<Medicion> listaMediciones;
    private Rutina rutina;
    private List<Entrenamiento> entrenamientosCompletados;
    private List<TrofeoObserver> observadores = new ArrayList<>();

    public Socio() {
        this.trofeos = new ArrayList<>();
        this.listaMediciones = new ArrayList<>();
        this.entrenamientosCompletados = new ArrayList<>();
    }

    // Constructor
    public Socio(Long id, String name, String apellido, String sexo, int edad,
            int altura, String mail, String password, Objetivo objetivo, List<Trofeo> trofeos,
            List<Medicion> listaMediciones, Rutina rutina) {
        this.id = id;
        this.name = name;
        this.apellido = apellido;
        this.sexo = sexo;
        this.edad = edad;
        this.altura = altura;
        this.mail = mail;
        this.password = password;
        this.objetivo = objetivo;
        this.trofeos = trofeos != null ? trofeos : new ArrayList<>();
        this.listaMediciones = listaMediciones != null ? listaMediciones : new ArrayList<>();
        this.rutina = rutina;
        this.entrenamientosCompletados = new ArrayList<>();
    }

    public void addTrofeo(Trofeo trofeo) {
        this.trofeos.add(trofeo);
    }

    public void addMedicion(Medicion medicion) {
        this.listaMediciones.add(medicion);
    }

    public void addEntrenamientoCompletado(Entrenamiento entrenamiento) {
        this.entrenamientosCompletados.add(entrenamiento);
    }

    public void addObserver(TrofeoObserver observador) {
        this.observadores.add(observador);
    }

    public void removeObserver(TrofeoObserver observador) {
        this.observadores.remove(observador);
    }

    public void notifyObservers() {
        for (TrofeoObserver observador : observadores) {
            observador.otorgarTrofeo(this);
        }
    }

    // public SocioDTO toDto() {
    // return new SocioDTO(id, name, apellido, sexo, edad, altura, mail, objetivo,
    // trofeos, mediciones, rutina);
    // }
}