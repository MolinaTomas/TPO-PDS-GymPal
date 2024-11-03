package com.uade.gymapp.model;

import java.util.List;

public class TrofeoConstancia extends Trofeo{
    @Override
    public void otorgarTrofeo(Socio socio) {
        if (cumpleCondicion(socio)) {
            socio.getTrofeos().add(this);
        }
    }

    @Override
    public boolean cumpleCondicion(Socio socio) {
        Rutina rutina = socio.getObjetivo().getRutina();
        boolean rutinaCompletada = true;
        List<Entrenamiento> entrenamientos = rutina.getEntrenamientos();

        for (Entrenamiento entrenamiento : entrenamientos) {
            if (entrenamiento.getEstadoEntrenamiento().getClass() != EntrenamientoCompletado.class) {
                rutinaCompletada = false;
                break;
            }
        }

        return rutinaCompletada;
    }
}
