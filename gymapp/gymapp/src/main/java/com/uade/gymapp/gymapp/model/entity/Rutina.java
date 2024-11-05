package com.uade.gymapp.gymapp.model.entity;

import com.uade.gymapp.gymapp.model.service.EstadoEntrenamiento;

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
    private List<Entrenamiento> entrenamientos;
    private List<Trofeo> observadores; //TODO revisar logica de observers
    private EstadoEntrenamiento estadoEntrenamiento;


}