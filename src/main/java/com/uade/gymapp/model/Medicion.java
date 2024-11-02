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

    // Getters y Setters

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getGrasaCorporal() {
        return grasaCorporal;
    }

    public void setGrasaCorporal(double grasaCorporal) {
        this.grasaCorporal = grasaCorporal;
    }

    public double getMasaMuscular() {
        return masaMuscular;
    }

    public void setMasaMuscular(double masaMuscular) {
        this.masaMuscular = masaMuscular;
    }

    public IMedicion getMedidor() {
        return medidor;
    }

    public void setMedidor(IMedicion medidor) {
        this.medidor = medidor;
    }

    public List<Trofeo> getObservadores() {
        return observadores;
    }

    public void setObservadores(List<Trofeo> observadores) {
        this.observadores = observadores;
    }
}
