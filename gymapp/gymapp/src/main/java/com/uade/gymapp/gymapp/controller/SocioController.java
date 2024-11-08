package com.uade.gymapp.gymapp.controller;

import com.uade.gymapp.gymapp.model.Socio;
import com.uade.gymapp.gymapp.model.dto.SocioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/usuario")
public class SocioController {

    private List<Socio> usuarios = new ArrayList<>(); // "simulación" de un repositorio de usuarios vacio

    // crear un nuevo usuario
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody SocioDTO socioDTO) {
        // verifico si el usuario ya existe
        for (Socio usuario : usuarios) {
            if (usuario.getMail().equals(socioDTO.getMail())) {
                return ResponseEntity.status(409).body("El usuario ya existe");
            }
        }

        // si no existe, lo creo
        Socio nuevoUsuario = new Socio();
        nuevoUsuario.setName(socioDTO.getName());
        nuevoUsuario.setApellido(socioDTO.getApellido());
        nuevoUsuario.setSexo(socioDTO.getSexo());
        nuevoUsuario.setEdad(socioDTO.getEdad());
        nuevoUsuario.setAltura(socioDTO.getAltura());
        nuevoUsuario.setMail(socioDTO.getMail());
        nuevoUsuario.setPassword(socioDTO.getPassword()); // TODO ver de hashear la contraseña, no creo que haga falta
                                                          // pero bueno

        usuarios.add(nuevoUsuario); // agrego al usuario a la lista
        System.out.println("Usuario registrado: " + nuevoUsuario.getMail()); // Mensaje en consola
        System.out.println(usuarios);
        return ResponseEntity.ok("Usuario registrado exitosamente!");
    }

    // Método para autenticar usuario
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody SocioDTO socioDTO) {
        for (Socio usuario : usuarios) {
            if (usuario.getMail().equals(socioDTO.getMail())) {
                if (usuario.getPassword().equals(socioDTO.getPassword())) {
                    System.out.println("Inicio de sesión exitoso para: " + usuario.getMail()); // Mensaje en consola
                    return ResponseEntity.ok("Inicio de sesión exitoso");
                } else {
                    return ResponseEntity.status(401).body("Contraseña incorrecta");
                }
            }
        }
        return ResponseEntity.status(404).body("Correo electrónico no encontrado");
    }

    // @Autowired
    // private SocioService socioService;
    //
    // @PutMapping("/{id}/objetivo")
    // public ResponseEntity<SocioDTO> actualizarObjetivo(@PathVariable Long id,
    // @RequestBody Objetivo nuevoObjetivo) throws Exception {
    //
    // SocioDTO socioActualizado = socioService.setObjetivo(id, nuevoObjetivo);
    // return ResponseEntity.ok(socioActualizado);
    // }

}
