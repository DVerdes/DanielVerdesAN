package dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConector {

    public   Connection obtenerConexion() throws SQLException;
}
