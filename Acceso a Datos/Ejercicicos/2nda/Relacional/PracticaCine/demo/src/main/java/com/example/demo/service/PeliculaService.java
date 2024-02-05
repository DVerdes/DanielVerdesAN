package com.example.demo.service;

import com.example.demo.dtos.PeliculaDTO;
import com.example.demo.dtos.SalaDTO;

import java.sql.SQLException;
import java.util.List;

public interface PeliculaService {

    public PeliculaDTO insertarPelicula (PeliculaDTO peliculaDTO) throws SQLException;

    public List<PeliculaDTO> listarPeliculasDeCine(int idCine) throws SQLException;


}
