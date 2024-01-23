package com.example.demo.controllers;

import com.example.demo.dtos.PeliculaDTO;
import com.example.demo.dtos.SesionDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeliculaController {

    @GetMapping("/api/peliculas/{peliculaID}/sesiones")
    List<SesionDTO> devolverSesionesPelicula(@PathVariable int peliculaID) {
        return null;
    }

    @PostMapping("/api/admin/peliculas")
    PeliculaDTO crearPelicula(@RequestBody PeliculaDTO pelicula) {
        return null;
    }
}
