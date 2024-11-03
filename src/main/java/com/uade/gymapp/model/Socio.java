package com.uade.gymapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSocio;
    private String name;
    private String apellido;
    private String sexo;
    private int edad;
    private int altura;
    private String mail;
    private Objetivo objetivo;
    private List<Trofeo> trofeos;
    // private List<EjercicioRealizado> progresoHistorial;
    private List<Medicion> mediciones;
    private String deviceToken; // Token para Firebase Cloud Messaging

    // Constructor
    public Socio(Long idSocio, String name, String apellido, String sexo, int edad, int altura,
            String mail, Objetivo objetivo, List<Trofeo> trofeos, List<Medicion> mediciones) {
        this.idSocio = idSocio;
        this.name = name;
        this.apellido = apellido;
        this.sexo = sexo;
        this.edad = edad;
        this.altura = altura;
        this.mail = mail;
        this.objetivo = objetivo;
        this.trofeos = trofeos;
        this.mediciones = mediciones;
    }

    // Getters y Setters
    public Long getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Long idSocio) {
        this.idSocio = idSocio;
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

    public List<Medicion> getMediciones() {
        return mediciones;
    }

    public void setMediciones(List<Medicion> mediciones) {
        this.mediciones = mediciones;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}
