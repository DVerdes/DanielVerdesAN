package com.example.demo.controllers;

import com.example.demo.dtos.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SesionController {

    @GetMapping("/api/sesiones/{sesionID}/reservas")
    List<ReservaDTO> devolverListaSesiones(@PathVariable int sesionID) {
        return null;
    }

    @PostMapping("/api/admin/sesiones")
    SesionDTO crearSesion(@RequestBody SesionDTO sesion) {
        return null;
    }
}
