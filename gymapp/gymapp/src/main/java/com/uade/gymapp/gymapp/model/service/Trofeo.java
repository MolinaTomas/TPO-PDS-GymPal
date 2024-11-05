package com.uade.gymapp.gymapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public abstract class Trofeo {

    public abstract void otorgarTrofeo(Socio socio);

    public abstract boolean cumpleCondicion(Socio socio);

}
