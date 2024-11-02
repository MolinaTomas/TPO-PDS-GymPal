package com.uade.gymapp.model;

import java.util.List;
import java.time.LocalDate;

public class TrofeoCreido extends Trofeo{
    @Override
    public void otorgarTrofeo(Socio socio) {

    }

    @Override
    public boolean cumpleCondicion(Socio socio) {
        List<Medicion> mediciones = socio.getMediciones();
        List<Medicion> medicionesDelMes;
        LocalDate fechaActual = LocalDate.now();
        int mesActual = fechaActual.getMonthValue();
        int anioActual = fechaActual.getYear();

        for (Medicion medicion : mediciones) {
            if (medicion.getFecha().getMonth()==mesActual-1 && medicion.)
        }
    }
}
