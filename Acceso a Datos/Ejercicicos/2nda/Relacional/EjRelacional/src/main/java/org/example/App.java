package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

    public static void crearTabla() throws SQLException{

        Connection c = conectarBD();
        Statement s = null;

        try{
            s = c.createStatement();
            String sentenciaDDL = "CREATE TABLE Jugadores ("
                    + "id int IDENTITY(1,1) PRIMARY KEY,"
                    + "nombre varchar(20) NOT NULL,"
                    + "dorsal int NOT NULL)";
            s.executeUpdate(sentenciaDDL);
            System.out.println("Crear tabla ok");
        }catch (SQLException e){
            System.out.println("Crear tabla KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
    }
}
