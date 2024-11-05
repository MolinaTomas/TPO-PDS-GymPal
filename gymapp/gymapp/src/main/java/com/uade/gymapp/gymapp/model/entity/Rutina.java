package com.uade.gymapp.gymapp.model.entity;

import com.uade.gymapp.gymapp.model.entity.Socio;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Rutina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "rutinaId") // Relación con Entrenamiento
    private List<Entrenamiento> entrenamientos;

    @OneToOne(mappedBy = "rutina") // Relación con Objetivo
    private Objetivo objetivo;

    @OneToMany(mappedBy = "rutina")
    private List<Socio> socio;
}

