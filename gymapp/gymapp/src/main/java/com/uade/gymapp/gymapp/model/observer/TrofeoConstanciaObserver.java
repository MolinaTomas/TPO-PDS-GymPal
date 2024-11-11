package com.uade.gymapp.gymapp.model.observer;

import com.uade.gymapp.gymapp.model.Medicion;
import com.uade.gymapp.gymapp.model.Socio;
import com.uade.gymapp.gymapp.model.Trofeo;
import com.uade.gymapp.gymapp.model.Rutina;

import java.time.LocalDateTime;

public class TrofeoConstanciaObserver implements TrofeoObserver {
    @Override
    public void otorgarTrofeo(Socio socio, Medicion medicion) {
        Rutina rutina = socio.getRutina();

        boolean yaTieneTrofeo = socio.getTrofeos().stream()
                .anyMatch(t -> t.getNombre().equals("Trofeo a la Constancia"));

        if (rutina != null && !yaTieneTrofeo && rutina.getEntrenamientos().stream()
                .allMatch(e -> e.getEjerciciosRealizados().size() == e.getEjercicios().size())) {
            Trofeo trofeo = new Trofeo(null, "Trofeo a la Constancia", LocalDateTime.now());
            socio.addTrofeo(trofeo);
            System.out.println("Trofeo a la Constancia");
        }
    }
}
