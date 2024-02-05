package com.example.demo.controllers;

import com.example.demo.dtos.*;
import com.example.demo.service.AccesoService;
import com.example.demo.service.UsuarioService;
import com.example.demo.service.impl.AccesoServiceImpl;
import com.example.demo.service.impl.UsuarioServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class UsuarioController {

    @PostMapping("/api/usuarios")
    UsuarioDTO crearUsuario(@RequestBody UsuarioDTO usuario) throws SQLException {
        UsuarioService us = new UsuarioServiceImpl();
        us.introducirUsuario(usuario);
        return usuario;
    }

    @PostMapping("/api/iniciar-sesion")
    boolean iniciarSesion(@RequestBody AccesoDTO sesion) throws SQLException {
        AccesoService as = new AccesoServiceImpl();

        return as.validarInicioSesion(sesion);
    }

    @PutMapping("/api/usuarios/{usuarioID}/cambiar-contrasena")
    void cambiarPassword(@RequestBody String nuevaClaveAcceso, @PathVariable int usuarioID) throws SQLException {
        UsuarioService us = new UsuarioServiceImpl();
        us.actualizarContrasenaUsuario(usuarioID, nuevaClaveAcceso);
    }

}
