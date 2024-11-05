package com.uade.gymapp.gymapp.model.entity;

import com.uade.gymapp.gymapp.model.ExigenciaMuscular;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private int series;
    private int repeticiones;
    private double peso;
    private int nivelAerobico;

    @Enumerated(EnumType.STRING) // Suponiendo que ExigenciaMuscular es un enum
    private ExigenciaMuscular exigenciaMuscular;
    private String videoUrl;

    @ManyToOne
    @JoinColumn(name = "entrenamientoId") // Relación con Entrenamiento
    private Entrenamiento entrenamiento;
}

