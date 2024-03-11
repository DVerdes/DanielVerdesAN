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

/**
 * Endpoints peliculas
 */
@RestController
public class PeliculaController {

    /**
     * Devuelve sesiones de una película
     * @param peliculaID id de la película
     * @return lista de sesiones
     * @throws SQLException
     */
    @GetMapping("/api/peliculas/{peliculaID}/sesiones")
    List<SesionDTO> devolverSesionesPelicula(@PathVariable int peliculaID) throws SQLException {
        SesionService ss = new SesionServiceImpl();
        return ss.listarSesionesdePelicula(peliculaID);
    }

    /**
     * Inserta película
     * @param pelicula película a insertar
     * @return película insertada
     * @throws SQLException
     */
    @PostMapping("/api/admin/peliculas")
    PeliculaDTO crearPelicula(@RequestBody PeliculaDTO pelicula) throws SQLException {

        PeliculaService ps = new PeliculaServiceImpl();
        return ps.insertarPelicula(pelicula);
    }
}
