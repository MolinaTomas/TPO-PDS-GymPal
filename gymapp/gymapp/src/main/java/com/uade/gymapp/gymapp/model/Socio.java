package com.uade.gymapp.gymapp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import com.uade.gymapp.gymapp.model.observer.TrofeoObserver;
import com.uade.gymapp.gymapp.controller.RutinaController;

@Getter
@Setter
public class Socio {
    private String name;
    private String apellido;
    private String sexo;
    private int edad;
    private int altura;
    private String mail;
    private String password;
    private Objetivo objetivo;
    private List<Trofeo> trofeos;
    private List<Medicion> Mediciones;
    private Rutina rutina;
    private List<Entrenamiento> entrenamientosCompletados;
    private List<TrofeoObserver> observadores = new ArrayList<>();
    private RutinaController rutinaController = new RutinaController();

    public Socio() {
        this.trofeos = new ArrayList<>();
        this.Mediciones = new ArrayList<>();
        this.entrenamientosCompletados = new ArrayList<>();
    }

    // Constructor
    public Socio(String name, String apellido, String sexo, int edad,
            int altura, String mail, String password, Objetivo objetivo, List<Trofeo> trofeos,
            List<Medicion> listaMediciones, Rutina rutina) {
        this.name = name;
        this.apellido = apellido;
        this.sexo = sexo;
        this.edad = edad;
        this.altura = altura;
        this.mail = mail;
        this.password = password;
        this.objetivo = objetivo;
        this.trofeos = trofeos != null ? trofeos : new ArrayList<>();
        this.Mediciones = listaMediciones != null ? listaMediciones : new ArrayList<>();
        this.rutina = rutina;
        this.entrenamientosCompletados = new ArrayList<>();
    }

    public void addTrofeo(Trofeo trofeo) {
        this.trofeos.add(trofeo);
    }

    public void addMedicion(Medicion medicion) {
        this.Mediciones.add(medicion);
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
            observador.otorgarTrofeo(this, null);
        }
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
        // Crea una nueva rutina basada en el nuevo objetivo
        Rutina nuevaRutina = new Rutina(objetivo);
        this.rutina = nuevaRutina;
    }

    public void setObjetivo(String objetivoSeleccionado) {
        switch (objetivoSeleccionado.toLowerCase()) {
            case "bajar de peso":
                this.objetivo = new BajarDePeso(); // El objetivo es una instancia concreta del objetivo
                break;
            case "tonificar cuerpo":
                this.objetivo = new TonificarCuerpo();
                break;
            case "mantener la figura":
                this.objetivo = new MantenerFigura();
                break;
            default:
                throw new IllegalArgumentException("Objetivo no válido");
        }
    }

}