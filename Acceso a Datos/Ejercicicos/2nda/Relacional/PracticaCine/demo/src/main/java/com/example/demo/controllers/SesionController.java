package com.example.demo.controllers;

import com.example.demo.dtos.*;
import com.example.demo.service.SesionService;
import com.example.demo.service.impl.SesionServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class SesionController {

    @GetMapping("/api/sesiones/{sesionID}/reservas")
    List<ReservaDTO> devolverListaSesiones(@PathVariable int sesionID) {
        return null;
    }

    @PostMapping("/api/admin/sesiones")
    SesionDTO crearSesion(@RequestBody SesionDTO sesion) throws SQLException {
        SesionService ss = new SesionServiceImpl();
        return ss.insertarSesion(sesion);
    }
}
