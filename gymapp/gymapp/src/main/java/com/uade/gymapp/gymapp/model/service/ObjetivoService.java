package com.uade.gymapp.gymapp.model.service;


import com.uade.gymapp.gymapp.model.entity.Trofeo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class ObjetivoService {
    private List<Trofeo> Observadores;

    public abstract RutinaService generarRutina(SocioService socioService);

    public abstract void calcularProgreso();

    public void cumplirObjetivo() {

    }

    public void actualizarProgreso(double nuevoProgreso) {

    }

    public void suscribirObservador(TrofeoService observador) {

    }

    public void eliminarObservador(TrofeoService observador) {

    }

    private void notificarObservadores() {

    }

}