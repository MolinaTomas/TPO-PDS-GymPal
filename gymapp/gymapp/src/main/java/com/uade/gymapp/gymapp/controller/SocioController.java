package com.uade.gymapp.gymapp.controller;

import com.uade.gymapp.gymapp.model.dto.SocioDTO;
import com.uade.gymapp.gymapp.model.entity.Objetivo;
import com.uade.gymapp.gymapp.model.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuario")
public class SocioController {

    @Autowired
    private SocioService socioService;

    @PutMapping("/{id}/objetivo")
    public ResponseEntity<SocioDTO> actualizarObjetivo(@PathVariable Long id, @RequestBody Objetivo nuevoObjetivo) throws Exception {

        SocioDTO socioActualizado = socioService.setObjetivo(id, nuevoObjetivo);
        return ResponseEntity.ok(socioActualizado);
    }

}
