package com.example.demo.dao;

import com.example.demo.dtos.PeliculaDTO;
import com.example.demo.model.Pelicula;
import com.example.demo.model.Sala;

import java.sql.SQLException;
import java.util.List;

public interface PeliculaDAO {

    Pelicula insertarPelicula (Pelicula pelicula) throws SQLException;

    List<Pelicula> listarPeliculasCine(int cineID) throws SQLException;

}
