package com.uade.gymapp.model;

public abstract class Trofeo {
    private String tipo;
    private String descripcion;
    private Notificador notificador;

    public abstract void otorgarTrofeo(Socio socio);

    public abstract boolean cumpleCondicion(Socio socio);

}
