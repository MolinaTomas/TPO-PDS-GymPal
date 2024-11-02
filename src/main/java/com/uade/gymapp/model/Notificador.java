package com.uade.gymapp.model;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class Notificador {
    private List<Notificacion> historialNotificaciones;

    public Notificador() {
        this.historialNotificaciones = new ArrayList<>();
    }

    public void enviarNotificacion(Trofeo trofeo, Socio socio, Notificacion notificacion) {
        // Personalizar el mensaje según el tipo de trofeo
        String mensaje = generarMensaje(trofeo, socio);
        notificacion.setMensaje(mensaje);

        // Registrar la notificación en el historial
        historialNotificaciones.add(notificacion);

        // Enviar la notificación según el tipo
        switch (notificacion.getTipoNotificacion()) {
            case EMAIL:
                enviarEmail(socio.getMail(), mensaje);
                break;
            case PUSH:
                enviarNotificacionPush(socio, mensaje);
                break;
            case APP:
                mostrarNotificacionEnApp(socio, mensaje);
                break;
        }
    }

    private String generarMensaje(Trofeo trofeo, Socio socio) {
        return String.format("¡Felicitaciones %s! Has ganado el trofeo: %s - %s",
                socio.getName(),
                trofeo.getTipo(),
                trofeo.getDescripcion());
    }

    private void enviarEmail(String email, String mensaje) {
        // Implementación del envío de email
        System.out.println("Enviando email a " + email + ": " + mensaje);
    }

    private void enviarNotificacionPush(Socio socio, String mensaje) {
        // Implementación de notificación push
        System.out.println("Enviando notificación push a " + socio.getName() + ": " + mensaje);
    }

    private void mostrarNotificacionEnApp(Socio socio, String mensaje) {
        // Implementación de notificación en la app
        System.out.println("Mostrando notificación en app para " + socio