package com.example.demo.controllers;

import com.example.demo.dtos.PeliculaDTO;
import com.example.demo.dtos.SesionDTO;
import com.example.demo.service.PeliculaService;
import com.example.demo.service.SesionService;
import com.example.demo.service.impl.PeliculaServiceImpl;
import com.example.demo.service.impl.SesionServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class PeliculaController {

    @GetMapping("/api/peliculas/{peliculaID}/sesiones")
    List<SesionDTO> devolverSesionesPelicula(@PathVariable int peliculaID) throws SQLException {
        SesionService ss = new SesionServiceImpl();
        return ss.listarSesionesdePelicula(peliculaID);
    }

    @PostMapping("/api/admin/peliculas")
    PeliculaDTO crearPelicula(@RequestBody PeliculaDTO pelicula) throws SQLException {

        PeliculaService ps = new PeliculaServiceImpl();
        return ps.insertarPelicula(pelicula);
    }
}
