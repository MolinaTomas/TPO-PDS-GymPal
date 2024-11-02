package com.uade.gymapp.model;

import javax.persistence.Entity;

@Entity
public class TrofeoDedicacion extends Trofeo {
    @Override
    public void otorgarTrofeo(Socio socio) {
    }

    @Override
    public boolean cumpleCondicion(Socio socio) {
        return false;
    }
}
