package com.uade.gymapp.gymapp.model;

import com.uade.gymapp.gymapp.model.dto.EntrenamientoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class Entrenamiento {
    private int duracion;
    private Date fecha;
    private List<Ejercicio> ejercicios;
    private List<EjercicioRealizado> ejerciciosRealizados;
    private EstadoEntrenamiento estado;

    public Entrenamiento(int duracion) {
        this.duracion = duracion;
        this.ejerciciosRealizados = new ArrayList<>();
        this.estado = new EstadoEntrenamientoListo(); // Estado Inicial
    }

    public void iniciar() {
        estado.iniciar(this);
    }

    public void finalizar() {
        estado.finalizar(this);
    }

    public void addEjercicioRealizado(EjercicioRealizado ejercicioRealizado) {
        this.ejerciciosRealizados.add(ejercicioRealizado);
    }

    public EntrenamientoDTO toDto() {
        return new EntrenamientoDTO(duracion, fecha, ejercicios.stream().map(Ejercicio::toDto).toList());
    }
}
