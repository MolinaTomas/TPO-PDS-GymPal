package com.uade.gymapp.gymapp.model.dto;

import com.uade.gymapp.gymapp.model.entity.MedicionService;
import com.uade.gymapp.gymapp.model.entity.Objetivo;
import com.uade.gymapp.gymapp.model.entity.Rutina;
import com.uade.gymapp.gymapp.model.entity.Trofeo;
import lombok.Data;

import java.util.List;

@Data
public class SocioDTO {
    private Long id;
    private String name;
    private String apellido;
    private String sexo;
    private int edad;
    private int altura;
    private String mail;
    private Objetivo objetivo;
    private List<Trofeo> trofeos;
    private List<MedicionService> mediciones;
    private Rutina rutina;

}
