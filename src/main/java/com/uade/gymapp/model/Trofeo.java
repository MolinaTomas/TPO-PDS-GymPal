package com.uade.gymapp.model;

import javax.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public abstract class Trofeo {
    private String tipo;
    private String descripcion;
    @Autowired
    private Notificador notificador;

    public abstract void otorgarTrofeo(Socio socio);

    public abstract boolean cumpleCondicion(Socio socio);
}
