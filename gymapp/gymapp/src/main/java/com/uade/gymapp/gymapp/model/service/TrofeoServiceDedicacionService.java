package com.uade.gymapp.gymapp.model.service;

import org.springframework.stereotype.Service;

@Service
public class TrofeoServiceDedicacionService extends TrofeoService {
    @Override
    public void otorgarTrofeo(SocioService socioService) {

    }

    public boolean cumpleCondicion(SocioService socioService) {
        return false;
    }
}
