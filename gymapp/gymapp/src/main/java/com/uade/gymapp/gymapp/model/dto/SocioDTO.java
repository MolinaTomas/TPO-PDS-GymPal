package com.uade.gymapp.gymapp.model.dto;

import com.uade.gymapp.gymapp.model.entity.MedicionService;
import com.uade.gymapp.gymapp.model.entity.Objetivo;
import com.uade.gymapp.gymapp.model.entity.Rutina;
import com.uade.gymapp.gymapp.model.entity.Trofeo;

import java.util.List;

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

    public SocioDTO(Long id, String name, String apellido, String sexo, int edad, int altura, String mail,
            Objetivo objetivo, List<Trofeo> trofeos, List<MedicionService> mediciones, Rutina rutina) {
        this.id = id;
        this.name = name;
        this.apellido = apellido;
        this.sexo = sexo;
        this.edad = edad;
        this.altura = altura;
        this.mail = mail;
        this.objetivo = objetivo;
        this.trofeos = trofeos;
        this.mediciones = mediciones;
        this.rutina = rutina;
    }

    // Getters y Setters
}
