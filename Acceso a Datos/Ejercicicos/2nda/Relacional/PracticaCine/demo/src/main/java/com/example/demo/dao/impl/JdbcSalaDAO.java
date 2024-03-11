package com.example.demo.dao.impl;

import com.example.demo.dao.DBConnector;
import com.example.demo.dao.SalaDAO;
import com.example.demo.model.Sala;

import java.sql.*;

/**
 * JDBC Sala
 */
public class JdbcSalaDAO implements SalaDAO {

    private DBConnector connector =  new HikariDBConnector();

    /**
     * Inserta sala
     * @param sala a insertar
     * @return sala insertada
     * @throws SQLException
     */
    @Override
    public Sala insertarSala(Sala sala) throws SQLException {

        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("INSERT INTO Salas (CineID,NombreSala,Capacidad,Filas,ButacasPorFila) VALUES (?,?,?,?,?);",
                    Statement.RETURN_GENERATED_KEYS);
            s.setInt(1,sala.getCineId());
            s.setString(2,sala.getNombreSala());
            s.setInt(3, sala.getCapacidad());
            s.setInt(4,sala.getFilas());
            s.setInt(5,sala.getButacasPorFila());

            s.executeUpdate();
            System.out.println("Insertar SALA ok");

            //Obtener ID insertado
            ResultSet generatedKeys = s.getGeneratedKeys();
            if(generatedKeys.next()){
                sala.setSalaId(generatedKeys.getInt(1));
                return sala;
            }
        }catch (SQLException e){
            System.out.println("Insertar equipo KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
        return null;
    }
}
