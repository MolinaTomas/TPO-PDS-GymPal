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
    private Entrenamiento entrenamiento;
    private Ejercicio ejercicio;
    private LocalDateTime fecha;
    private int seriesRealizadas;
    private int repeticionesHechas;
    private double pesoLevantado;

}
