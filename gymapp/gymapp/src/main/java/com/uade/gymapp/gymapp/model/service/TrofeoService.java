package com.uade.gymapp.gymapp.model.service;

import org.springframework.stereotype.Service;

@Service
public abstract class TrofeoService {

    public abstract void otorgarTrofeo(SocioService socioService);

    public abstract boolean cumpleCondicion(SocioService socioService);

}
