package com.uade.gymapp;

import com.uade.gymapp.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*
@SpringBootApplication
public class Application {
    @Autowired
    private SocioRepository socioRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            // Crear objetivos disponibles
            Objetivo bajarPeso = new BajarPeso();
            Objetivo mantenerFigura = new MantenerFigura();
            Objetivo tonificar = new TonificarCuerpo();

            // Crear algunos ejercicios básicos
            List<Ejercicio> ejercicios = new ArrayList<>();
            Ejercicio ejercicio1 = new Ejercicio();
            // Configurar ejercicio1
            ejercicios.add(ejercicio1);

            // Crear un entrenamiento de ejemplo
            Entrenamiento entrenamiento = new Entrenamiento(60, ejercicios, new Date());

            // Crear un socio de ejemplo
            List<Trofeo> trofeos = new ArrayList<>();
            List<Medicion> mediciones = new ArrayList<>();

            Socio socio = new Socio(
                    1,
                    "Juan",
                    "Pérez",
                    "M",
                    25,
                    175,
                    "juan@example.com",
                    bajarPeso,
                    new EntrenamientoPreparado(),
                    trofeos,
                    mediciones);
        };
    }
}*/
