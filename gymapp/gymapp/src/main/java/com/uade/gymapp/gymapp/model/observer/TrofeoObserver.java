package com.uade.gymapp.gymapp.model.observer;

import com.uade.gymapp.gymapp.model.Medicion;
import com.uade.gymapp.gymapp.model.Socio;

import javax.swing.*;

public interface TrofeoObserver {
    void otorgarTrofeo(Socio socio, Medicion medicion);
}

// Para notificar a los observadores:
// socio.notifyObservers();