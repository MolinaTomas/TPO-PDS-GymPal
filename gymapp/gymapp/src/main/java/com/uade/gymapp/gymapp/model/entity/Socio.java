package com.uade.gymapp.gymapp.model.entity;


import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

}
