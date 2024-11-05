package com.uade.gymapp.gymapp.model.service;

import com.uade.gymapp.gymapp.model.entity.Trofeo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicionService implements IMedicionService {

    private List<Trofeo> Observadores;

    public void suscribirObservador(TrofeoService observador) {

    }

    public void eliminarObservador(TrofeoService observador) {

    }

    @Override
    public void registrarMedicion() {

    }

    @Override
    public void registrarMedicionPeso(double nuevoPeso) {

    }

    private void notificarObservadores() {

    }

}
