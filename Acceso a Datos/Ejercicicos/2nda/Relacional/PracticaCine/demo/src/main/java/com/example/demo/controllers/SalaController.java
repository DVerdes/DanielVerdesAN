package com.example.demo.controllers;

import com.example.demo.dtos.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalaController {

    @PostMapping("/api/admin/salas")
    SalaDTO crearSala(@RequestBody SalaDTO sala) {
        return null;
    }
}
