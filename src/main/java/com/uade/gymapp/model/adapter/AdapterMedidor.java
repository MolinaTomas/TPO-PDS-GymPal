package com.uade.gymapp.model.adapter;

import com.uade.gymapp.model.Intefaces.IMedicion;
import com.uade.gymapp.model.Medicion;
import java.util.List;

public class AdapterMedidor implements IMedicion {
    private List<Medicion> historialMediciones; // TODO ver de cambiar donde esta el historial

    public AdapterMedidor(List<Medicion> historialMediciones) {
        this.historialMediciones = historialMediciones;
    }

    @Override
    public void registrarMedicion() {
        // TODO ver si hace falta agregar otro tipo de medicion
    }

    @Override
    public void registrarMedicionPeso(double peso) {
        Medicion nuevaMedicion = new Medicion(peso);
        historialMediciones.add(nuevaMedicion);
    }
}
