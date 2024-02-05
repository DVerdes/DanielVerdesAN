package com.example.demo.dao;

import com.example.demo.model.Cine;
import com.example.demo.model.Sala;

import java.sql.SQLException;
import java.util.List;

public interface CineDAO {

    List<Cine> listarCines() throws SQLException;

    List<Sala> listarSalasDeCine(int idCine) throws SQLException;

    Cine insertarCine (Cine cine) throws SQLException;

}
