package com.uade.gymapp.model.Intefaces;

import com.uade.gymapp.model.Entrenamiento;

public interface EstadoEntrenamiento {
    void comenzar(Entrenamiento entrenamiento);
    void finalizar(Entrenamiento entrenamiento);

    String mostrarNombre();
}
