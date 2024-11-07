package com.uade.gymapp.gymapp.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class EjercicioRealizado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "entrenamientoId") // Relación con Entrenamiento
    private Entrenamiento entrenamiento;

    @ManyToOne
    @JoinColumn(name = "EjercicioId") // Relación con Ejercicio
    private Ejercicio ejercicio;

    private LocalDateTime fecha;
    private int seriesRealizadas;
    private int repeticionesHechas;
    private double pesoLevantado;
}


