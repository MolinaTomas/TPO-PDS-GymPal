package com.uade.gymapp.gymapp.model.service;
import org.springframework.stereotype.Service;

@Service
public interface IMedicion {
    void registrarMedicion();

    void registrarMedicionPeso(double peso);
}
