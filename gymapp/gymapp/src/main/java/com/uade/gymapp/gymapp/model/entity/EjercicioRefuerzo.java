package com.uade.gymapp.gymapp.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class EjercicioRefuerzo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Ejercicio ejercicioBase;
    private static final float FACTOR_PESO = 1.2f; // Porcentaje de aumento de peso. Ej: 1.2 = +20%
    private static final int FACTOR_REPETICIONES = 2; // Multiplicador de repeticiones o series. Ej: 2 = x2
    private static final int FACTOR_SERIES = 2;
}