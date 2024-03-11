package com.example.demo.dao.impl;

import com.example.demo.dao.DBConnector;
import com.example.demo.dao.UsuarioDAO;
import com.example.demo.model.Acceso;
import com.example.demo.model.Usuario;

import java.sql.*;

/**
 * JDBC Usuario
 */
public class JdbcUsuarioDAO implements UsuarioDAO {

    private DBConnector connector =  new HikariDBConnector();

    /**
     * Inserta usuarios
     * @param usuario a insertar
     * @return usuario insertado
     * @throws SQLException
     */
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

    /**
     * Actualiza contraseña
     * @param idUsuario id usuario
     * @param nuevaContrasena nueva pass
     * @throws SQLException
     */
    @Override
    public void actualizarContrasena(int idUsuario, String nuevaContrasena) throws SQLException {
        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("UPDATE Usuarios SET ClaveAcceso=? WHERE UsuarioID = ?");
            s.setString(1,nuevaContrasena);
            s.setInt(2,idUsuario);
            s.executeUpdate();
            System.out.println("Actualizar contraseña ok");
        }catch (SQLException e){
            System.out.println("Actualizar contraseña KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
    }

}
