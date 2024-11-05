package com.uade.gymapp.gymapp.model.service;

import org.springframework.stereotype.Service;

@Service
public class BajarPesoService extends ObjetivoService {

    @Override
    public RutinaService generarRutina(SocioService socioService) {
        return null;
    }

    @Override
    public void calcularProgreso() {
    }

    private double calcularPesoObjetivo(SocioService socioService) {
        return 0;
    }
}
