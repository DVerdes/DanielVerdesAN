package com.example.demo.dao;

import com.example.demo.model.Sala;

import java.sql.SQLException;

public interface SalaDAO {

    Sala insertarSala (Sala sala) throws SQLException;

}
