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

    @OneToOne
    @JoinColumn(name = "objetivo_id") // Relación con Objetivo
    private Objetivo objetivo;

    @OneToMany(mappedBy = "socio") // Relación con Trofeo
    private List<Trofeo> trofeos;

    @OneToMany(mappedBy = "socio") // Relación con MedicionService
    private List<MedicionService> mediciones;

    @ManyToOne
    @JoinColumn(name = "rutinaId") // Relación con Rutina
    private Rutina rutina;
}


