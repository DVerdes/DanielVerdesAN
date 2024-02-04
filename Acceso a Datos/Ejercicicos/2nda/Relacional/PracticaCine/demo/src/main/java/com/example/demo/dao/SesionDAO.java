package com.example.demo.dao;

import com.example.demo.model.Sala;
import com.example.demo.model.Sesion;

import java.sql.SQLException;
import java.util.List;

public interface SesionDAO {

    Sesion insertarSesion (Sesion sesion) throws SQLException;

    List<Sesion> listarSesionesDePelicula(int idPelicula) throws SQLException;


}
