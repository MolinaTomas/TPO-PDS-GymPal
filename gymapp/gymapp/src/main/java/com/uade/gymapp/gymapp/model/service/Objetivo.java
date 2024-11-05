package com.uade.gymapp.gymapp.model.service;


import org.springframework.stereotype.Service;

@Service
public abstract class Objetivo {

    public abstract Rutina generarRutina(Socio socio);

    public abstract void calcularProgreso();

    public void cumplirObjetivo() {

    }

    public void actualizarProgreso(double nuevoProgreso) {

    }

    public void suscribirObservador(Trofeo observador) {

    }

    public void eliminarObservador(Trofeo observador) {

    }

    private void notificarObservadores() {

    }

}