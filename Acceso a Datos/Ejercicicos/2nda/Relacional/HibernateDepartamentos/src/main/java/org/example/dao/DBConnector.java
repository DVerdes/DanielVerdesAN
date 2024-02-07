package org.example.dao;

import org.example.dao.impl.HikariDBConnector;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnector {

    public Connection obtenerConexion() throws SQLException;


}


