package com.uade.gymapp.model;

public class TrofeoDedicacion extends Trofeo {
    @Override
    public void otorgarTrofeo(Socio socio) {
        if (cumpleCondicion(socio)) {
            socio.getTrofeos().add(this);
        }
    }

    public boolean cumpleCondicion(Socio socio) {
        Objetivo objetivo = socio.getObjetivo();
        if (objetivo.getProgresoActual() >= 100.00) {
            return true;
        } else {
            return false;
        }
    }
}
