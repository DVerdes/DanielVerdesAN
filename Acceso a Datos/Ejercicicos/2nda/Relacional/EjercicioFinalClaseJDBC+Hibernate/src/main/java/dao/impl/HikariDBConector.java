package dao.impl;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import dao.DBConector;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariDBConector implements DBConector {

    private static HikariConfig config = new HikariConfig();

    private static HikariDataSource ds;


    static {
        config.setJdbcUrl("jdbc:sqlserver://localhost:1433");
        config.setUsername("sa");
        config.setPassword("ADMIN0");
        config.addDataSourceProperty("database","pruebas");
        config.addDataSourceProperty("encrypt","true");
        config.addDataSourceProperty("trustServerCertificate","true");
        config.addDataSourceProperty("loginTimeout","30");
        ds = new HikariDataSource(config);

    }

    public Connection obtenerConexion() throws SQLException {

        return ds.getConnection();
    }
}
