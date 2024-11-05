package com.uade.gymapp.gymapp.model.service;
import org.springframework.stereotype.Service;

@Service
public interface IMedicionService {
    void registrarMedicion();

    void registrarMedicionPeso(double peso);
}
