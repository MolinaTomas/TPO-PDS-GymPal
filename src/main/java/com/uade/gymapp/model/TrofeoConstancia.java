package com.uade.gymapp.model;

public class TrofeoConstancia extends Trofeo{
    @Override
    public void otorgarTrofeo(Socio socio) {

    }

    @Override
    public boolean cumpleCondicion(Socio socio) {
        return false;
    }
}