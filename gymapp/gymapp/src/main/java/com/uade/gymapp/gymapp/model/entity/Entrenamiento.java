package com.uade.gymapp.gymapp.model.entity;

import com.uade.gymapp.gymapp.model.service.EstadoEntrenamientoService;

import java.util.Date;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Entrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int duracion;
    private Date fecha;

    @OneToMany(mappedBy = "entrenamiento") // Relación bidireccional con Ejercicio
    private List<Ejercicio> ejercicios;

    @Transient // EstadoEntrenamientoService es un servicio, no se mapea en la BD
    private EstadoEntrenamientoService estadoEntrenamientoService;
}

