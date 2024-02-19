/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicafinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DVerd
 */

public class JdbcDao {

    // Replace below database url, username and password with your actual database credentials
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3307/dam2?useSSL=false";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = null;
    private static final String INSERT_QUERY = "INSERT INTO jugadores (nombre, apellidos, equipo, posicion, edad, imgURL) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String DELETE_QUERY = "DELETE FROM jugadores WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE jugadores SET nombre = ?, apellidos=?, equipo =?, posicion= ?, edad=?, imgURL=? WHERE idJugador = ?";
    private static final String SELECT_QUERY = "SELECT * FROM jugadores";



    public static int insertRecord(Jugador jugador) throws SQLException {

        // Step 1: Establishing a Connection and 
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
            .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY,Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, jugador.getNombre());
            preparedStatement.setString(2, jugador.getApellido());
            preparedStatement.setString(3, jugador.getEquipo());
            preparedStatement.setString(4, jugador.getPosicion());
            preparedStatement.setInt(5, jugador.getEdad());
            preparedStatement.setString(6, jugador.getImgURL());

            preparedStatement.executeUpdate();

            ResultSet gk = preparedStatement.getGeneratedKeys();
            if(gk.next()) return gk.getInt(1);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
        return 0;
    }
    
    public static void updateRecord(Jugador jugador) throws SQLException {

        // Step 1: Establishing a Connection and 
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
            .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setString(1, jugador.getNombre());
            preparedStatement.setString(2, jugador.getApellido());
            preparedStatement.setString(3, jugador.getEquipo());
            preparedStatement.setString(4, jugador.getPosicion());
            preparedStatement.setInt(5, jugador.getEdad());
            preparedStatement.setString(6, jugador.getImgURL());
            preparedStatement.setInt(7, jugador.getIdJugador());


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }
    
    
     public void deleteRecord(int id) throws SQLException {

        // Step 1: Establishing a Connection and 
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
            .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)) {
            preparedStatement.setInt(1, id);


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }
    
    
    
    
    public static List<Jugador> selectRecords() throws SQLException {
        List<Jugador> jugadores = new ArrayList<Jugador>();

        // Step 1: Establishing a Connection and 
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
            .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
              ResultSet res = preparedStatement.executeQuery();
            while (res.next()){
                Jugador j = new Jugador(res.getString("nombre"),res.getString("apellidos"),res.getString("equipo"),res.getString("posicion"),
                        res.getInt("edad"),res.getString("imgURL"));
                jugadores.add(j);
            }

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
        return jugadores;
    }

    
    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
