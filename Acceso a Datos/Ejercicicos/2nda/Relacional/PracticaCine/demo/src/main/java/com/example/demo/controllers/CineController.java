package com.example.demo.controllers;

import com.example.demo.dtos.*;
import com.example.demo.service.CineService;
import com.example.demo.service.PeliculaService;
import com.example.demo.service.impl.CineServiceImpl;
import com.example.demo.service.impl.PeliculaServiceImpl;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLException;
import java.util.List;

/**
 * Controllers Cine
 */
@RestController
public class CineController {

    /**
     * Endpoint listar cines
     * @return lista de cines
     * @throws SQLException
     */
    @GetMapping("/api/cines")
    List<CineDTO> devolverCines() throws SQLException {
        CineService cs = new CineServiceImpl();

        return cs.listarCines();
    }

    /**
     * Endpoint, devuelve películas de un cine
     * @param cineID id del cine
     * @return listado de peliculas de ese cine
     * @throws SQLException
     */
    @GetMapping("/api/cines/{cineID}/peliculas")
    List<PeliculaDTO> devolverPeliculasCine(@PathVariable int cineID) throws SQLException {
        PeliculaService ps = new PeliculaServiceImpl();
        return ps.listarPeliculasDeCine(cineID);
    }

    /**
     * Endpoint, devuelve salas de un cine
     * @param cineID id de cine
     * @return listado de salas
     * @throws SQLException
     */
    @GetMapping("/api/cines/{cineID}/salas")
    List<SalaDTO> devolverSalasCine(@PathVariable int cineID) throws SQLException {
        CineService cs = new CineServiceImpl();

        return cs.listarSalasDeCine(cineID);
    }

    /**
     * Endpoint, inserta cine
     * @param cine cine a insertar
     * @return cine insertado
     * @throws SQLException
     */
    @PostMapping("/api/admin/cines")
    CineDTO crearCine(@RequestBody CineDTO cine) throws SQLException {
        CineService cs = new CineServiceImpl();

        return cs.insertarCine(cine);
    }
}
