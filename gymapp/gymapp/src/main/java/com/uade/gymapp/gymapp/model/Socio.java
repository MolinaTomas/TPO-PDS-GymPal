package com.uade.gymapp.gymapp.model;

import com.uade.gymapp.gymapp.model.dto.SocioDTO;
import com.uade.gymapp.gymapp.model.entity.Trofeo;

import java.util.List;

public class Socio {
    private Long id;
    private String name;
    private String apellido;
    private String sexo;
    private int edad;
    private int altura;
    private String mail;
    private Objetivo objetivo;
    private List<Trofeo> trofeos;
//    private List<MedicionService> mediciones;
    private Rutina rutina;

//    public Socio(Long id, String name, String apellido, String sexo, int edad, int altura, String mail,
//            Objetivo objetivo, List<Trofeo> trofeos, List<MedicionService> mediciones, Rutina rutina) {
//        this.id = id;
//        this.name = name;
//        this.apellido = apellido;
//        this.sexo = sexo;
//        this.edad = edad;
//        this.altura = altura;
//        this.mail = mail;
//        this.objetivo = objetivo;
//        this.trofeos = trofeos;
//        this.mediciones = mediciones;
//        this.rutina = rutina;
//    }
//
//    public SocioDTO toDto() {
//        return new SocioDTO(id, name, apellido, sexo, edad, altura, mail, objetivo, trofeos, mediciones, rutina);
//    }
}
