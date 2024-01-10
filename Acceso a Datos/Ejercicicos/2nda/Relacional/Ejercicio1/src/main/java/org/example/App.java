package org.example;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws SQLException {



    }

    public static Connection conectarBD(){
        String connecionUrl =
                "jdbc:sqlserver://localhost:1445;"
                        + "database=Pruebas;"
                        + "user=sa;"
                        + "password=ADMIN0;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
        try{
            Connection connection = DriverManager.getConnection(connecionUrl);
            System.out.println("Conexión OK");
            return connection;
        }catch (SQLException e){
            System.out.println("Conexión KO");
            throw new RuntimeException(e);
        }
    }

    public static void crearTablaAlm() throws SQLException{
        Connection c = conectarBD();
        Statement s = null;
        try{
            s = c.createStatement();
            String sentenciaDDL = "CREATE TABLE Almacenes ("
                    + "idAlmacen INT PRIMARY KEY IDENTITY(1,1),"
                    + "nombre varchar(20) NOT NULL,"
                    + "dorsal int NOT NULL)";
            s.executeUpdate(sentenciaDDL);
            System.out.println("Crear tabla ok");
        }catch (SQLException e){
            System.out.println("Crear tabla KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();
            if (c!=null) c.close();
        }
    }

    public static void insertarJugardor(String nombre, int dorsal) throws SQLException{
        Connection c = conectarBD();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("INSERT INTO Jugadores (nombre,dorsal) VALUES (?,?)");
            s.setString(1,nombre);
            s.setInt(2,dorsal);
            s.executeUpdate();
            System.out.println("Insertar jugador ok");
        }catch (SQLException e){
            System.out.println("Insertar jugador KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
    }

    public static void buscarJugadores(String nombre) throws SQLException{
        Connection c = conectarBD();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("SELECT * FROM Jugadores WHERE nombre = ?");
            s.setString(1,nombre);
            ResultSet res = s.executeQuery();
            while (res.next()){
                String impresion = "ID="
                        +res.getInt("id")
                        + ", Nombre="
                        +res.getString("nombre");
                System.out.println(impresion);
            }
        }catch (SQLException e){
            System.out.println("Consulta KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
    }





}
