package com.uade.gymapp.gymapp.model.observer;

import com.uade.gymapp.gymapp.model.Socio;
import com.uade.gymapp.gymapp.model.Trofeo;

import javax.swing.*;
import java.time.LocalDateTime;

public class TrofeoCreidoObserver implements TrofeoObserver {
    @Override
    public void otorgarTrofeo(Socio socio) {
        long conteo = socio.getMediciones().stream()
                .filter(m -> m.getFechaYhora().getMonth() == LocalDateTime.now().getMonth())
                .count();

        boolean yaTieneTrofeo = socio.getTrofeos().stream()
                .anyMatch(t -> t.getNombre().equals("Trofeo al Creído"));

        if (conteo > 3 && !yaTieneTrofeo) {
            Trofeo trofeo = new Trofeo(null, "Trofeo al Creído", LocalDateTime.now());
            socio.addTrofeo(trofeo);
            System.out.println("Trofeo otorgado al creído para el usuario: " + socio.getName());
            //JOptionPane.showMessageDialog(pantalla, "Has obtenido el Trofeo al Creído! Por haber hecho más de 3 mediciones en el mes ;)", "Trofeo al Creído", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}