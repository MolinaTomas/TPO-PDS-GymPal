package com.uade.gymapp.gymapp.model.observer;
<<<<<<< HEAD
=======

>>>>>>> da8f4b74e6f73d065cd942a902f84df4f51538e3
import com.uade.gymapp.gymapp.model.Socio;
import com.uade.gymapp.gymapp.model.Trofeo;

import java.time.LocalDateTime;

public class TrofeoCreidoObserver implements TrofeoObserver {
    @Override
    public void otorgarTrofeo(Socio socio) {
        long count = socio.getListaMediciones().stream()
                .filter(m -> m.getFechaYhora().getMonth() == LocalDateTime.now().getMonth())
                .count();
        if (count > 3) {
            Trofeo trofeo = new Trofeo(null, "Trofeo al Creído", LocalDateTime.now());
            socio.addTrofeo(trofeo);
        }
    }
}