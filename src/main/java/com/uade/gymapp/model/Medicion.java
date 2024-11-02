package com.uade.gymapp.model;

import com.uade.gymapp.model.Intefaces.IMedicion;

import java.util.Date;
import java.util.List;

public class Medicion implements IMedicion {
    private Date fecha;
    private double peso;
    private double grasaCorporal;
    private double masaMuscular;
    private IMedicion medidor;
    private List<Trofeo> observadores;

    public Medicion(double peso) {
        this.peso = peso;
    }

    public void suscribirObservador(Trofeo observador) {
        this.observadores.add(observador);
    }

    public void eliminarObservador(Trofeo observador) {
        this.observadores.remove(observador);
    }

    @Override
    public void registrarMedicion() {

    }

    @Override
    public void registrarMedicionPeso(double nuevoPeso) {
        this.peso = nuevoPeso;
        // TODO ver si falta logica adicional
    }
}
