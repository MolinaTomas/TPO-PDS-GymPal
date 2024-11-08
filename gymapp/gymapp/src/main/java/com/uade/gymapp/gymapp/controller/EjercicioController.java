package com.uade.gymapp.gymapp.controller;

//import com.uade.gymapp.gymapp.model.service.EjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ejercicios")
public class EjercicioController {
//    @Autowired
//    private EjercicioService ejercicioService;

//    @GetMapping
//    public List<Ejercicio> obtenerEjercicios() {
//        return ejercicioService.obtenerTodosLosEjercicios();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Ejercicio> obtenerEjercicioPorId(@PathVariable Long id) {
//        Ejercicio ejercicio = ejercicioService.obtenerEjercicioPorId(id);
//        return ejercicio != null ? ResponseEntity.ok(ejercicio) : ResponseEntity.notFound().build();
//    }
//
//    @PostMapping
//    public Ejercicio crearEjercicio(@RequestBody Ejercicio ejercicio) {
//        return ejercicioService.crearEjercicio(ejercicio);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminarEjercicio(@PathVariable Long id) {
//        ejercicioService.eliminarEjercicio(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PostMapping("/{id}/realizar")
//    public ResponseEntity<EjercicioRealizado> realizarEjercicio(@PathVariable Long id, @RequestBody EjercicioRealizadoDto dto) {
//        Ejercicio ejercicio = ejercicioService.obtenerEjercicioPorId(id);
//        if (ejercicio == null) {
//            return ResponseEntity.notFound().build();
//        }
//
////        TODO ver de cambiar la logica de creacion de EjercicioRealizado, se podria hacer en controller
////        Entrenamiento entrenamiento = ...; // Obtener el entrenamiento actual
////
////        EjercicioRealizado ejercicioRealizado = ejercicioService.registrarEjercicioRealizado(entrenamiento, dto.getSeries(), dto.getRepeticiones(), dto.getPeso(), dto.getNivelAerobico());
//
//        return ResponseEntity.ok(ejercicioRealizado);
//    }
}