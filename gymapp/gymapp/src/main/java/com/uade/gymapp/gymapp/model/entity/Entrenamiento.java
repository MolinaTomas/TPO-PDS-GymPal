package com.uade.gymapp.gymapp.model.entity;

import com.uade.gymapp.gymapp.model.service.EstadoEntrenamiento;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private int duracion; // en horas
    @OneToMany
    private List<Ejercicio> ejercicios;
    private Date fecha;
    private EstadoEntrenamiento estadoEntrenamiento;
    private EjercicioRealizadoRepository ejercicioRealizadoRepository;


}
