package com.uade.gymapp.model;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class Trofeo {
    private String tipo;
    private String descripcion;
    @Autowired
    private Notificador notificador;

    public abstract void otorgarTrofeo(Socio socio);

    public abstract boolean cumpleCondicion(Socio socio);

    public Trofeo() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Notificador getNotificador() {
        return notificador;
    }

    public void setNotificador(Notificador notificador) {
        this.notificador = notificador;
    }
}
