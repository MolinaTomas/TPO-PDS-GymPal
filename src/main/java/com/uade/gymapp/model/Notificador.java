package com.uade.gymapp.model;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.google.firebase.messaging.FirebaseMessagingException;

@Component
public class Notificador {
    private List<Notificacion> historialNotificaciones;
    private FirebaseMessaging firebaseMessaging; // Servicio de Firebase

    public Notificador() {
        this.historialNotificaciones = new ArrayList<>();
        // Inicializar Firebase Messaging (falta testear!)
        this.firebaseMessaging = FirebaseMessaging.getInstance();
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
        // TODO verificar si esta es la correcta logica de Firebase
        Message message = Message.builder()
                .setToken(socio.getDeviceToken()) // Aca se deberia agregar deviceToken a Socio
                .setNotification(Notification.builder()
                        .setTitle("¡Nuevo Trofeo!")
                        .setBody(mensaje)
                        .build())
                .build();

        try {
            String response = firebaseMessaging.send(message);
            System.out.println("Notificación push enviada exitosamente: " + response);
        } catch (FirebaseMessagingException e) {
            System.err.println("Error al enviar notificación push: " + e.getMessage());
        }
    }

    private String generarMensaje(Trofeo trofeo, Socio socio) {
        return String.format("¡Felicitaciones %s! Has ganado el trofeo: %s - %s",
                socio.getName(),
                trofeo.getTipo(),
                trofeo.getDescripcion()); // TODO verificar que datos queremos incluir en la notificacion
    }

    public List<Notificacion> getHistorialNotificaciones() {
        return historialNotificaciones;
    }
}