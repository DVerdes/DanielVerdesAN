package com.example.demo.dao.impl;

import com.example.demo.dao.AccesoDAO;
import com.example.demo.dao.DBConnector;
import com.example.demo.model.Acceso;
import com.example.demo.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBC Acceso
 */
public class JbdcAccesoDAO implements AccesoDAO {
    private DBConnector connector =  new HikariDBConnector();


    /**
     * Comprueba inicio sesión
     * @param acceso datos acceso
     * @return booleano de si sesión es valida
     * @throws SQLException
     */
    @Override
    public boolean comprobarInicioSesion(Acceso acceso) throws SQLException {

        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("SELECT * FROM Usuarios WHERE NombreUsuario = ? AND ClaveAcceso = ?");
            s.setString(1, acceso.getNombreUsuario());
            s.setString(2, acceso.getClaveAcceso());

            ResultSet res = s.executeQuery();
            return res.next();




        }catch (SQLException e){
            System.out.println("Consulta KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }





    }
}
