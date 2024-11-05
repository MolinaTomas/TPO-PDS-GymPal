package com.uade.gymapp.gymapp.model.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texto;
    private Date fecha;


}
