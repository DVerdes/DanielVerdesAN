package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Establece conexión con pool de HikariCP
 */
public class Conexion {


    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl("jdbc:sqlserver://localhost:1445;");
        config.setUsername("sa");
        config.setPassword("ADMIN0");
        config.addDataSourceProperty("database","ExamenJDBC");
        config.addDataSourceProperty("encrypt","true");
        config.addDataSourceProperty("trustServerCertificate","true");
        config.addDataSourceProperty("loginTimeout","30");
        ds = new HikariDataSource(config);
    }

    /**
     * Método estático para estableces conexión
     * @return Connection a través de HikariCP
     * @throws SQLException
     */
    public static Connection obtenerConexion() throws SQLException {
        return ds.getConnection();
    }
}
