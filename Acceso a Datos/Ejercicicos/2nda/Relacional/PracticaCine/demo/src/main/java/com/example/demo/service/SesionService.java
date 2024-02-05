package com.example.demo.service;

import com.example.demo.dtos.PeliculaDTO;
import com.example.demo.dtos.SalaDTO;
import com.example.demo.dtos.SesionDTO;
import com.example.demo.model.Sesion;

import java.sql.SQLException;
import java.util.List;

public interface
SesionService {

    public SesionDTO insertarSesion (SesionDTO sesionDTO) throws SQLException;

    public List<SesionDTO> listarSesionesdePelicula(int idPelicula) throws SQLException;


}
