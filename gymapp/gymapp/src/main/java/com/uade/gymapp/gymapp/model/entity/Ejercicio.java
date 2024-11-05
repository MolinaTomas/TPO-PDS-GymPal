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
public class Ejercicio { //TODO ver de incluir el video demostrativo del ejercicio
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private int series;
    private int repeticiones;
    private double peso;
    private int nivelAerobico;
    private ExigenciaMuscular exigenciaMuscular;
    private String videoUrl;

}
