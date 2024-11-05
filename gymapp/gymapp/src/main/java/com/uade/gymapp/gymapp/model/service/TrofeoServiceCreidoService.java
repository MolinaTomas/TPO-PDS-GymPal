package com.uade.gymapp.gymapp.model.service;

import org.springframework.stereotype.Service;

@Service
public class TrofeoServiceCreidoService extends TrofeoService {
    @Override
    public void otorgarTrofeo(SocioService socioService) {

    }

    @Override
    public boolean cumpleCondicion(SocioService socioService) {
        return false;
    }
}
