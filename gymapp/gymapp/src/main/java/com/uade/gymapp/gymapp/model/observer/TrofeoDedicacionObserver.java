package com.uade.gymapp.gymapp.model.observer;

import java.time.LocalDateTime;

import com.uade.gymapp.gymapp.model.Socio;
import com.uade.gymapp.gymapp.model.Trofeo;

public class TrofeoDedicacionObserver implements TrofeoObserver {
    @Override
    public void otorgarTrofeo(Socio socio) {
        if (socio.getObjetivo().isCumplido()) {
            Trofeo trofeo = new Trofeo(null, "Trofeo a la Dedicación", LocalDateTime.now());
            socio.addTrofeo(trofeo);
        }
    }
}
