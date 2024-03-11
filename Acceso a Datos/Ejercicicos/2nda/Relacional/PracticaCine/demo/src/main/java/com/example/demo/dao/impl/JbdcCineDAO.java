package com.example.demo.dao.impl;

import com.example.demo.dao.CineDAO;
import com.example.demo.dao.DBConnector;
import com.example.demo.mapper.CineMapper;
import com.example.demo.mapper.SalaMapper;
import com.example.demo.model.Cine;
import com.example.demo.model.Sala;

import java.sql.*;
import java.util.List;

/**
 * Jdbc Cine
 */
public class JbdcCineDAO implements CineDAO {

    private DBConnector connector =  new HikariDBConnector();

    /**
     * Lista cines
     * @return listado de todos los cines
     * @throws SQLException
     */
    @Override
    public List<Cine> listarCines() throws SQLException {

        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("SELECT * FROM Cines");

            return CineMapper.resALista(s.executeQuery());

        }catch (SQLException e){
            System.out.println("Consulta KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
    }

    /**
     * Lista salas de un cine
     * @param idCine id del cine a listar salas
     * @return listado de salas
     * @throws SQLException
     */
    @Override
    public List<Sala> listarSalasDeCine(int idCine) throws SQLException {
        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("SELECT * FROM Salas WHERE CineID = ?");
            s.setInt(1,idCine);

            return SalaMapper.resALista(s.executeQuery());

        }catch (SQLException e){
            System.out.println("Consulta KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
    }

    /**
     * Inserta cine
     * @param cine a insertar
     * @return cine insertado
     * @throws SQLException
     */
    @Override
    public Cine insertarCine(Cine cine) throws SQLException {
        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("INSERT INTO Cines (NombreCine, Direccion) VALUES (?,?);",
                    Statement.RETURN_GENERATED_KEYS);
            s.setString(1,cine.getNombreCine());
            s.setString(2,cine.getDireccion());

            s.executeUpdate();
            System.out.println("Insertar Cine ok");

            //Obtener ID insertado
            ResultSet generatedKeys = s.getGeneratedKeys();
            if(generatedKeys.next()){
                cine.setCineId(generatedKeys.getInt(1));
                return cine;
            }
        }catch (SQLException e){
            System.out.println("Insertar cine KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
        return null;
    }
}
