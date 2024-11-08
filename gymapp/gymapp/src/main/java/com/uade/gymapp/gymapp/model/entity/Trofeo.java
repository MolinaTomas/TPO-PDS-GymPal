package com.uade.gymapp.gymapp.model.entity;

//import com.uade.gymapp.gymapp.model.service.NotificadorService;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Trofeo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "socioId") // Relación con Socio
    private Socio socio;

//    @Transient // NotificadorService es un servicio
//    private NotificadorService notificadorService;
}

