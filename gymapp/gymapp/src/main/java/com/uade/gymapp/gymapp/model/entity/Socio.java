package com.uade.gymapp.gymapp.model.entity;


import java.util.List;

import com.uade.gymapp.gymapp.model.dto.SocioDTO;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String apellido;
    private String sexo;
    private int edad;
    private int altura;
    private String mail;

    @OneToOne
    @JoinColumn(name = "objetivo_id") // Relación con Objetivo
    private Objetivo objetivo;

    @OneToMany(mappedBy = "socio") // Relación con Trofeo
    private List<Trofeo> trofeos;

    @OneToMany(mappedBy = "socio") // Relación con MedicionService
    private List<MedicionService> mediciones;

    @ManyToOne
    @JoinColumn(name = "rutinaId") // Relación con Rutina
    private Rutina rutina;

//    public SocioDTO toSocioDTO() {
//        SocioDTO socioDTO = new SocioDTO();
//        socioDTO.setId(this.id);
//        socioDTO.setName(this.name);
//        socioDTO.setApellido(this.apellido);
//        socioDTO.setSexo(this.sexo);
//        socioDTO.setEdad(this.edad);
//        socioDTO.setAltura(this.altura);
//        socioDTO.setMail(this.mail);
//        socioDTO.setObjetivo(this.objetivo);
//        socioDTO.setTrofeos(this.trofeos);
//        socioDTO.setMediciones(this.mediciones);
//        socioDTO.setRutina(this.rutina);
//        return socioDTO;
//    }
}


