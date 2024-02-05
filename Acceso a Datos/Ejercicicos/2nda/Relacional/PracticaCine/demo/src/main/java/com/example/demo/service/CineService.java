package com.example.demo.service;

import com.example.demo.dtos.CineDTO;
import com.example.demo.dtos.PeliculaDTO;
import com.example.demo.dtos.SalaDTO;

import java.sql.SQLException;
import java.util.List;

public interface CineService {

    public List<CineDTO> listarCines() throws SQLException;

    public List<SalaDTO> listarSalasDeCine(int idCine) throws SQLException;

    public CineDTO insertarCine (CineDTO cineDTO) throws SQLException;

}
