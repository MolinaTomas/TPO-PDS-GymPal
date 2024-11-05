package com.uade.gymapp.gymapp.model.entity;

import com.uade.gymapp.gymapp.model.service.IMedicion;

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
public class Medicion implements IMedicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private double peso;
    private double grasaCorporal;
    private double masaMuscular;
    private IMedicion medidor;
    private List<Trofeo> observadores;

}
