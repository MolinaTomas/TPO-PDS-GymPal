package com.uade.gymapp.model;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class Trofeo {
    private String tipo;
    private String descripcion;
    @Autowired
    private Notificador notificador;

    public abstract void otorgarTrofeo(Socio socio);

    public abstract boolean cumpleCondicion(Socio socio);
}
