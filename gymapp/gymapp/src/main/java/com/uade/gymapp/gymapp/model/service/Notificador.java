package com.uade.gymapp.gymapp.model.service;

import com.uade.gymapp.gymapp.model.entity.Notificacion;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Notificador {
    private List<Notificacion> historialNotificaciones;

    public Notificador() {
        this.historialNotificaciones = new ArrayList<>();
    }

    public void enviarNotificacion(Trofeo trofeo, Socio socio, Notificacion notificacion) {
        String mensaje = generarMensaje(trofeo, socio);
        notificacion.setMensaje(mensaje);

        // Guardar en el historial
        historialNotificaciones.add(notificacion);

        // Enviar notificación por Firebase
        enviarNotificacionPush(socio, mensaje);
    }

    private void enviarNotificacionPush(Socio socio, String mensaje) {

    }

    private String generarMensaje(Trofeo trofeo, Socio socio) {
        return String.format("¡Felicitaciones %s! Has ganado el trofeo: %s - %s",
                socio.getName(),
                trofeo.getTipo(),
                trofeo.getDescripcion()); // TODO verificar que datos queremos incluir en la notificacion
    }

}