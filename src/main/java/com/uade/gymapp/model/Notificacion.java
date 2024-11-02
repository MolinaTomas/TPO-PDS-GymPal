package com.uade.gymapp.model;

import java.util.Date;

public class Notificacion {
    private String mensaje;
    private Date fecha;
    private TipoNotificacion tipoNotificacion;
    private boolean leida;

    public Notificacion(TipoNotificacion tipo) {
        this.tipoNotificacion = tipo;
        this.fecha = new Date();
        this.leida = false;
    }

    // Getters y Setters
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public TipoNotificacion getTipoNotificacion() {
        return tipoNotificacion;
    }

    public boolean isLeida() {
        return leida;
    }

    public void marcarComoLeida() {
        this.leida = true;
    }
}