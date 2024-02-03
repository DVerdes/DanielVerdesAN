package com.example.demo.controllers;

import com.example.demo.dtos.*;
import com.example.demo.service.CineService;
import com.example.demo.service.PeliculaService;
import com.example.demo.service.impl.CineServiceImpl;
import com.example.demo.service.impl.PeliculaServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class CineController {

    @GetMapping("/api/cines")
    List<CineDTO> devolverCines() throws SQLException {
        CineService cs = new CineServiceImpl();

        return cs.listarCines();
    }

    @GetMapping("/api/cines/{cineID}/peliculas")
    List<PeliculaDTO> devolverPeliculasCine(@PathVariable int cineID) throws SQLException {
        PeliculaService ps = new PeliculaServiceImpl();
        return ps.listarPeliculasDeCine(cineID);
    }

    @GetMapping("/api/cines/{cineID}/salas")
    List<SalaDTO> devolverSalasCine(@PathVariable int cineID) throws SQLException {
        CineService cs = new CineServiceImpl();

        return cs.listarSalasDeCine(cineID);
    }

    @PostMapping("/api/admin/cines")
    CineDTO crearCine(@RequestBody CineDTO cine) throws SQLException {
        CineService cs = new CineServiceImpl();

        return cs.insertarCine(cine);
    }
}
