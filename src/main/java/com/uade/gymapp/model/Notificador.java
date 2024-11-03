package com.uade.gymapp.model;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class Notificador {
    private List<Notificacion> historialNotificaciones;
    private FirebaseMessaging firebaseMessaging; // Servicio de Firebase

    public Notificador() {
        this.historialNotificaciones = new ArrayList<>();
        // Inicializar Firebase Messaging (esto requeriría configuración adicional)
    }

    public void enviarNotificacion(Trofeo trofeo, Socio socio, Notificacion notificacion) {
        String mensaje = generarMensaje(trofeo, socio);
        notificacion.setMensaje(mensaje);

        // Guardar en el historial
        historialNotificaciones.add(notificacion);

        // Enviar notificación push a través de Firebase
        enviarNotificacionPush(socio, mensaje);
    }

    private void enviarNotificacionPush(Socio socio, String mensaje) {
        // Aquí iría la lógica de envío usando Firebase Cloud Messaging
        Message message = Message.builder()
                .setToken(socio.getDeviceToken()) // Necesitarías agregar deviceToken a Socio
                .setNotification(Notification.builder()
                        .setTitle("¡Nuevo Trofeo!")
                        .setBody(mensaje)
                        .build())
                .build();

        try {
            String response = FirebaseMessaging.getInstance().send(message);
            System.out.println("Notificación push enviada exitosamente: " + response);
        } catch (FirebaseMessagingException e) {
            System.err.println("Error al enviar notificación push: " + e.getMessage());
        }
    }

    private String generarMensaje(Trofeo trofeo, Socio socio) {
        return String.format("¡Felicitaciones %s! Has ganado el trofeo: %s - %s",
                socio.getName(),
                trofeo.getTipo(),
                trofeo.getDescripcion());
    }

    public List<Notificacion> getHistorialNotificaciones() {
        return historialNotificaciones;
    }
}