package com.example.demo.controllers;

import com.example.demo.dtos.PeliculaDTO;
import com.example.demo.dtos.ReservaDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservasController {

    @PostMapping("/api/reservas")
    ReservaDTO regitrarReserva(@RequestBody ReservaDTO reserva) {
        return null;
    }

    @PutMapping("/api/reservas/{reservaID}/confirmar")
    List<PeliculaDTO> confirmarReserva(@PathVariable int reservaID) {
        return null;
    }

}
