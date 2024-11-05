package com.uade.gymapp.gymapp.model.entity;

import com.uade.gymapp.gymapp.model.service.Notificador;
import org.springframework.beans.factory.annotation.Autowired;


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
    private Notificador notificador;

}
