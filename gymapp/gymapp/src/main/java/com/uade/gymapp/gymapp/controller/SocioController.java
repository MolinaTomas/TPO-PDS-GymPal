package com.uade.gymapp.gymapp.controller;

import com.uade.gymapp.gymapp.model.BajarDePeso;
import com.uade.gymapp.gymapp.model.Objetivo;
import com.uade.gymapp.gymapp.model.Rutina;
import com.uade.gymapp.gymapp.model.Socio;
import com.uade.gymapp.gymapp.model.dto.SocioDTO;
import com.uade.gymapp.gymapp.model.observer.TrofeoConstanciaObserver;
import com.uade.gymapp.gymapp.model.observer.TrofeoCreidoObserver;
import com.uade.gymapp.gymapp.model.observer.TrofeoDedicacionObserver;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SocioController {

    private List<Socio> usuarios = new ArrayList<>(); // "simulación" de un repositorio de usuarios vacio
    private static Socio usuarioActual; // Variable estática para el usuario actual
    private RutinaController rutinaController = new RutinaController();

    // Constructor to add the admin user
    public SocioController() {
        Socio admin = new Socio();
        admin.setName("admin");
        admin.setApellido("admin");
        admin.setSexo("M");
        admin.setEdad(30);
        admin.setAltura(175);
        admin.setMail("admin");
        admin.setPassword("123");
        admin.setObjetivo(new BajarDePeso());
        TrofeoCreidoObserver creidoObserver = new TrofeoCreidoObserver();
        admin.addObserver(creidoObserver);
        TrofeoConstanciaObserver constanciaObserver = new TrofeoConstanciaObserver();
        admin.addObserver(constanciaObserver);
        TrofeoDedicacionObserver dedicacionObserver = new TrofeoDedicacionObserver();
        admin.addObserver(dedicacionObserver);
        rutinaController.crearRutina(admin, admin.getObjetivo());
        usuarios.add(admin);
    }

    // Método para registrar un nuevo usuario
    public ResponseEntity<String> register(SocioDTO socioDTO) {
        // Verificar si el usuario ya existe
        for (Socio usuario : usuarios) {
            if (usuario.getMail().equals(socioDTO.getMail())) {
                return ResponseEntity.status(409).body("El usuario ya existe");
            }
        }

        // Si no existe, lo creo
        Socio nuevoUsuario = new Socio();
        nuevoUsuario.setName(socioDTO.getName());
        nuevoUsuario.setApellido(socioDTO.getApellido());
        nuevoUsuario.setSexo(socioDTO.getSexo());
        nuevoUsuario.setEdad(socioDTO.getEdad());
        nuevoUsuario.setAltura(socioDTO.getAltura());
        nuevoUsuario.setMail(socioDTO.getMail());
        nuevoUsuario.setPassword(socioDTO.getPassword());
        nuevoUsuario.setObjetivo(socioDTO.getObjetivo());

        // Crear una Rutina basada en el Objetivo

        nuevoUsuario.setRutina(nuevaRutina);
        rutinaController.crearRutina(nuevoUsuario, nuevoUsuario.getObjetivo());

        usuarios.add(nuevoUsuario); // Agrego el usuario a la lista
        usuarioActual = nuevoUsuario; // Establezco el usuario actual

        TrofeoCreidoObserver creidoObserver = new TrofeoCreidoObserver();
        usuarioActual.addObserver(creidoObserver);

        return ResponseEntity.ok("Usuario registrado exitosamente!");
    }

    // Método para autenticar usuario
    public ResponseEntity<String> login(@RequestBody SocioDTO socioDTO) {
        for (Socio usuario : usuarios) {
            if (usuario.getMail().equals(socioDTO.getMail())) {
                if (usuario.getPassword().equals(socioDTO.getPassword())) {
                    usuarioActual = usuario; // Establezco el usuario actual
                    return ResponseEntity.ok("Inicio de sesión exitoso");
                } else {
                    return ResponseEntity.status(401).body("Contraseña incorrecta");
                }
            }
        }
        return ResponseEntity.status(404).body("Correo electrónico no encontrado");
    }

    // Método para cerrar sesión
    public void logout() {
        usuarioActual = null; // Limpio la variable del usuario actual
    }

    // Método para obtener el usuario actual
    public static Socio getUsuarioActual() {
        return usuarioActual;
    }

    // Método para modificar el usuario actual
    public static void setUsuarioActual(Socio socio) {
        usuarioActual = socio;
    }

    // Método para modificar datos del usuario actual
    public static void updateUsuarioActual(SocioDTO socioDTO) {
        usuarioActual.setName(socioDTO.getName());
        usuarioActual.setApellido(socioDTO.getApellido());
        usuarioActual.setSexo(socioDTO.getSexo());
        usuarioActual.setEdad(socioDTO.getEdad());
        usuarioActual.setAltura(socioDTO.getAltura());
        usuarioActual.setMail(socioDTO.getMail());
        usuarioActual.setPassword(socioDTO.getPassword());

        // Reviso si el objetivo cambió
        if (!usuarioActual.getObjetivo().equals(socioDTO.getObjetivo())) {
            usuarioActual.setObjetivo(socioDTO.getObjetivo());

            // Creo una nueva Rutina basada en el nuevo Objetivo
            Rutina nuevaRutina = new Rutina(socioDTO.getObjetivo());
            usuarioActual.setRutina(nuevaRutina);
        }
    }

    // Método para devolver la lista de usuarios registrados
    public List<Socio> getUsuariosRegistrados() {
        return usuarios;
    }
}