package com.uade.gymapp.gymapp.model;

import com.uade.gymapp.gymapp.model.dto.SocioDTO;
import com.uade.gymapp.gymapp.model.Trofeo;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Socio {
    private Long id;
    private String name;
    private String apellido;
    private String sexo;
    private int edad;
    private int altura;
    private String mail;
    private String password;
    private Objetivo objetivo;
    private List<Trofeo> trofeos;
    private List<Mediciones> listaMediciones;
    private Rutina rutina;

    public Socio() {
        this.listaMediciones = new ArrayList<>();
    }

    // Constructor
    public Socio(Long id, String name, String apellido, String sexo, int edad,
            int altura, String mail, String password, Objetivo objetivo, List<Trofeo> trofeos,
            List<Mediciones> listaMediciones, Rutina rutina) {
        this.id = id;
        this.name = name;
        this.apellido = apellido;
        this.sexo = sexo;
        this.edad = edad;
        this.altura = altura;
        this.mail = mail;
        this.password = password;
        this.objetivo = objetivo;
        this.trofeos = trofeos;
        this.listaMediciones = listaMediciones != null ? listaMediciones : new ArrayList<>();
        this.rutina = rutina;
    }

    public void addTrofeo(Trofeo trofeo) {
        this.trofeos.add(trofeo);
    }

    /*public void addMedicion(Mediciones medicion) {
        this.mediciones.add(medicion);
    }*/

    public List<Mediciones> getListaMediciones() {
        return listaMediciones;
    }

    // public SocioDTO toDto() {
    // return new SocioDTO(id, name, apellido, sexo, edad, altura, mail, objetivo,
    // trofeos, mediciones, rutina);
    // }
}