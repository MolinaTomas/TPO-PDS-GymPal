package com.uade.gymapp.gymapp.model.service;

import com.uade.gymapp.gymapp.model.entity.Notificacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NotificadorService {
    private List<Notificacion> historialNotificaciones;

    public NotificadorService() {
        this.historialNotificaciones = new ArrayList<>();
    }

    public void enviarNotificacion(TrofeoService trofeoService, SocioService socioService, Notificacion notificacion) {

    }

    private void enviarNotificacionPush(SocioService socioService, String mensaje) {

    }

    private String generarMensaje(TrofeoService trofeoService, SocioService socioService) {
        return "";
    }

}