package com.uade.gymapp.gymapp.model.dto;

import com.uade.gymapp.gymapp.model.Medicion;
import com.uade.gymapp.gymapp.model.Objetivo;
import com.uade.gymapp.gymapp.model.Rutina;
import com.uade.gymapp.gymapp.model.Trofeo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SocioDTO {
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
    private List<Medicion> mediciones;
    private Rutina rutina;

    public SocioDTO() {
    }

    public SocioDTO(Long id, String name, String apellido, String sexo, int edad, int altura, String mail,
                    String password, Objetivo objetivo, List<Trofeo> trofeos, List<Medicion> mediciones, Rutina rutina) {
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
        this.mediciones = mediciones;
        this.rutina = rutina;
    }

    public void addTrofeo(Trofeo trofeo) {
        this.trofeos.add(trofeo);
    }

    public void addMedicion(Medicion medicion) {
        this.mediciones.add(medicion);
    }
}
