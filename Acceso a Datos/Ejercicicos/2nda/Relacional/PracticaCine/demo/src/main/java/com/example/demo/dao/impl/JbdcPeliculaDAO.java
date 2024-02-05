package com.example.demo.dao.impl;

import com.example.demo.dao.DBConnector;
import com.example.demo.dao.PeliculaDAO;
import com.example.demo.mapper.PeliculaMapper;
import com.example.demo.mapper.SalaMapper;
import com.example.demo.model.Pelicula;

import java.sql.*;
import java.util.List;

public class JbdcPeliculaDAO implements PeliculaDAO {

    private DBConnector connector =  new HikariDBConnector();

    @Override
    public Pelicula insertarPelicula(Pelicula pelicula) throws SQLException {
        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("INSERT INTO Peliculas (SalaID,Titulo,FechaInicio,FechaFin,Genero,ClasificacionEdad) VALUES (?,?,?,?,?,?);",
                    Statement.RETURN_GENERATED_KEYS);
            s.setInt(1,pelicula.getSalaID());
            s.setString(2,pelicula.getTitulo());
            s.setDate(3, pelicula.getFechaInicio());
            s.setDate(4, pelicula.getFechaFin());
            s.setString(5,pelicula.getGenero());
            s.setInt(6,pelicula.getClasificacionEdad());

            s.executeUpdate();
            System.out.println("Insertar Pelicula ok");

            //Obtener ID insertado
            ResultSet generatedKeys = s.getGeneratedKeys();
            if(generatedKeys.next()){
                pelicula.setPeliculaID(generatedKeys.getInt(1));
                return pelicula;
            }
        }catch (SQLException e){
            System.out.println("Insertar Pelicula KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
        return null;
    }

    @Override
    public List<Pelicula> listarPeliculasCine(int cineID) throws SQLException {
        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("SELECT * FROM Peliculas JOIN Salas ON Peliculas.SalaID = Salas.SalaID WHERE Salas.CineID = ?");
            s.setInt(1,cineID);

            return PeliculaMapper.resALista(s.executeQuery());

        }catch (SQLException e){
            System.out.println("Consulta KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
    }
}
