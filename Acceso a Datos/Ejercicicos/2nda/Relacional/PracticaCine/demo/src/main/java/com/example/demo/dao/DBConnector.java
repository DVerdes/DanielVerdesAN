package com.example.demo.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnector {
    public Connection obtenerConexion() throws SQLException;

}
