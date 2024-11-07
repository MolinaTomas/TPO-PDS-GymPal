package com.uade.gymapp.gymapp.model.service;


import com.uade.gymapp.gymapp.model.dto.SocioDTO;
import com.uade.gymapp.gymapp.model.entity.Objetivo;
import com.uade.gymapp.gymapp.model.entity.Socio;
import com.uade.gymapp.gymapp.model.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocioService {

    @Autowired
    private SocioRepository socioRepository;
    @Autowired
    private BajarPesoService bajarPesoService;

    public SocioDTO getSocioById(Long id) throws Exception {
        Socio socio = socioRepository.findById(id).orElseThrow(() -> new Exception("No se encontro el Socio"));
        return socio.toSocioDTO();
    }

    public SocioDTO setObjetivo(Long id, int idObjetivo) throws Exception {
        Socio socio = socioRepository.findById(id).orElse(null);
        ObjetivoService bajarPeso = new BajarPesoService();
        ObjetivoService mantenerFigura = new MantenerFiguraService();
        ObjetivoService tonificarCuerpo = new TonificarCuerpoService();
        assert socio != null;
        if (idObjetivo == 1) {
            socio.setObjetivo(bajarPeso);
        }
        socio=socioRepository.save(socio);

        return socio.toSocioDTO();
    }
}
