package com.example.demo.dao.impl;

import com.example.demo.dao.DBConnector;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariDBConnector implements DBConnector {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
    //1447
    static {
        config.setJdbcUrl("jdbc:sqlserver://localhost:1433;");
        config.setUsername("sa");
        config.setPassword("ADMIN0");
        config.addDataSourceProperty("database","Pruebas");
        config.addDataSourceProperty("encrypt","true");
        config.addDataSourceProperty("trustServerCertificate","true");
        config.addDataSourceProperty("loginTimeout","30");
        ds = new HikariDataSource(config);
    }

    public Connection obtenerConexion() throws SQLException {
        return ds.getConnection();
    }

}
