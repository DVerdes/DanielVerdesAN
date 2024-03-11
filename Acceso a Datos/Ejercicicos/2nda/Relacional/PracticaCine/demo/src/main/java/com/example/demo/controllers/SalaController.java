package com.example.demo.controllers;

import com.example.demo.dtos.*;
import com.example.demo.service.SalaService;
import com.example.demo.service.impl.SalaServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Endpoints salas
 */
@RestController
public class SalaController {

    /**
     * Inserta una sala
     * @param sala a insertar
     * @return sala insertada
     * @throws SQLException
     */
    @PostMapping("/api/admin/salas")
    SalaDTO crearSala(@RequestBody SalaDTO sala) throws SQLException {
        SalaService ss = new SalaServiceImpl();
        return ss.insertarSala(sala);
    }
}
