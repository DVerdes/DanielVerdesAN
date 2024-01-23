package com.example.demo.controllers;

import com.example.demo.dtos.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CineController {

    @GetMapping("/api/cines")
    List<CineDTO> devolverCines() {
        return null;
    }

    @GetMapping("/api/cines/{cineID}/peliculas")
    List<PeliculaDTO> devolverPeliculasCine(@PathVariable int cineID) {
        return null;
    }

    @GetMapping("/api/cines/{cineID}/salas")
    List<PeliculaDTO> devolverSalasCine(@PathVariable int cineID) {
        return null;
    }

    @PostMapping("/api/admin/cines")
    CineDTO crearCine(@RequestBody CineDTO cine) {
        return null;
    }
}
