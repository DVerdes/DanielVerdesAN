package com.example.demo.controllers;

import com.example.demo.dtos.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @PostMapping("/api/usuarios")
    UsuarioDTO crearUsuario(UsuarioDTO usuario) {
        return null;
    }

    @PostMapping("/api/iniciar-sesion")
    UsuarioDTO iniciarSesion(@RequestBody AccesoDTO sesion) {
        return null;
    }

    @PutMapping("/api/usuarios/{usuarioID}/cambiar-contrasena")
    void cambiarPassword(@RequestBody String nuevaClaveAcceso, @PathVariable int usuarioID) {

    }

}
