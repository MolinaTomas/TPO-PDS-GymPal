package com.uade.gymapp.model;

import java.util.Date;

public class Notificacion {
    private String titulo;
    private String mensaje;
    private Date fecha;
    private boolean leida;
    private String deviceToken;
    private String respuestaFirebase; // Para almacenar la respuesta de Firebase

    public Notificacion(String deviceToken) {
        this.deviceToken = deviceToken;
        this.fecha = new Date();
        this.leida = false;
        this.titulo = "¡Nuevo Trofeo!"; // Título por defecto
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public boolean isLeida() {
        return leida;
    }

    public void marcarComoLeida() {
        this.leida = true;
    }

    public String getRespuestaFirebase() {
        return respuestaFirebase;
    }

    public void setRespuestaFirebase(String respuestaFirebase) {
        this.respuestaFirebase = respuestaFirebase;
    }
}