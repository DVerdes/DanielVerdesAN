package com.example.demo.dao.impl;

import com.example.demo.dao.DBConnector;
import com.example.demo.dao.UsuarioDAO;
import com.example.demo.model.Acceso;
import com.example.demo.model.Usuario;

import java.sql.*;

public class JdbcUsuarioDAO implements UsuarioDAO {

    private DBConnector connector =  new HikariDBConnector();

    @Override
    public int insertarUsuario(Usuario usuario) throws SQLException {
        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("INSERT INTO Usuarios (NombreUsuario,Email,ClaveAcceso,Rol) VALUES (?,?,?,?);",
                    Statement.RETURN_GENERATED_KEYS);
            s.setString(1,usuario.getNombreUsuario());
            s.setString(2,usuario.getEmail());
            s.setString(3, usuario.getClaveAcceso());
            s.setString(4,"Usuario");
            s.executeUpdate();
            System.out.println("Insertar usuario ok");

            //Obtener ID insertado
            ResultSet generatedKeys = s.getGeneratedKeys();
            if(generatedKeys.next()){
                return generatedKeys.getInt(1);
            }
        }catch (SQLException e){
            System.out.println("Insertar usuario KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
        return 0;
    }

}
