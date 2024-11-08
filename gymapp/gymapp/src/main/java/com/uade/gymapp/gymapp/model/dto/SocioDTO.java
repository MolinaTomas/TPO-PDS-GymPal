package com.uade.gymapp.gymapp.model.dto;

import com.uade.gymapp.gymapp.model.Mediciones;
import com.uade.gymapp.gymapp.model.Objetivo;
import com.uade.gymapp.gymapp.model.Rutina;
import com.uade.gymapp.gymapp.model.Trofeo;

import java.util.List;

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
    private List<Mediciones> mediciones;
    private Rutina rutina;

    public SocioDTO() {
    }

    public SocioDTO(Long id, String name, String apellido, String sexo, int edad, int altura, String mail,
            String password, Objetivo objetivo, List<Trofeo> trofeos, List<Mediciones> mediciones, Rutina rutina) {
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

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public List<Trofeo> getTrofeos() {
        return trofeos;
    }

    public void setTrofeos(List<Trofeo> trofeos) {
        this.trofeos = trofeos;
    }

    public List<Mediciones> getMediciones() {
        return mediciones;
    }

    public void setMediciones(List<Mediciones> mediciones) {
        this.mediciones = mediciones;
    }

    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }
}
