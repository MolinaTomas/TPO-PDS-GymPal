package com.uade.gymapp.model;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class TrofeoCreido extends Trofeo{
    @Override
    public void otorgarTrofeo(Socio socio) {
        if (cumpleCondicion(socio)) {
            socio.getTrofeos().add(this);
        }
    }

    @Override
    public boolean cumpleCondicion(Socio socio) {
        List<Medicion> mediciones = socio.getMediciones();
        List<Medicion> medicionesDelMes = new ArrayList<>();
        LocalDate fechaActual = LocalDate.now();
        int mesActual = fechaActual.getMonthValue();
        int anioActual = fechaActual.getYear();

        for (Medicion medicion : mediciones) {
            if (medicion.getFecha().getMonth()==mesActual-1 && medicion.getFecha().getYear()==anioActual) {
                medicionesDelMes.add(medicion);
            }
        }

        if (medicionesDelMes.size()>=3) {
            return true;
        } else {
            return false;
        }
    }
}
