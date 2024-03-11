package com.example.demo.dao.impl;

import com.example.demo.dao.DBConnector;
import com.example.demo.dao.SesionDAO;
import com.example.demo.mapper.SalaMapper;
import com.example.demo.mapper.SesionMapper;
import com.example.demo.model.Sesion;

import java.sql.*;
import java.util.List;

/**
 * Jdbc Sesión
 */
public class JbdcSesionDAO implements SesionDAO {


    private DBConnector connector =  new HikariDBConnector();

    /**
     * Crea nueva sesión
     * @param sesion a crear
     * @return sesión insertada
     * @throws SQLException
     */
    @Override
    public Sesion insertarSesion(Sesion sesion) throws SQLException {
        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("INSERT INTO Sesiones (PeliculaID,HoraInicio,HoraFin) VALUES (?,?,?);",
                    Statement.RETURN_GENERATED_KEYS);
            s.setInt(1,sesion.getPeliculaID());
            s.setTimestamp(2,sesion.getHoraInicio());
            s.setTimestamp(3,sesion.getHoraFin());

            s.executeUpdate();
            System.out.println("Insertar Sesion ok");

            //Obtener ID insertado
            ResultSet generatedKeys = s.getGeneratedKeys();
            if(generatedKeys.next()){
                sesion.setSesionID(generatedKeys.getInt(1));
                return sesion;
            }
        }catch (SQLException e){
            System.out.println("Insertar sesion KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
        return null;
    }

    /**
     * Lista sesiones de una película
     * @param idPelicula a listar
     * @return listado
     * @throws SQLException
     */
    @Override
    public List<Sesion> listarSesionesDePelicula(int idPelicula) throws SQLException {
        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("SELECT * FROM Sesiones WHERE PeliculaID = ?");
            s.setInt(1,idPelicula);

            return SesionMapper.resALista(s.executeQuery());

        }catch (SQLException e){
            System.out.println("Consulta KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
    }

}
