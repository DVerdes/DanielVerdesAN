package org.example;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws SQLException {

        eliminarTabla();
        crearTabla();
        agregarCampo();
        //
        //
        //
        insertarEquipo("Lakers",200000000);
        insertarEquipo("76ers",100000000);
        insertarEquipo("OKC",100000000);
        insertarEquipo("Orlando",100000000);



        actualizarEquipo(1,"Grizzlies",232323);
        borrarEquipo("76ers");
        mostrarEquipos();
        buscarEquipos("Grizzlies");
        mostrarEquiposLetra("O");
        // acordarse de crear el PA en la BBDD previamente
        llamarProcedimiento("r");

        gestionTransacciones();
        mostrarEquipos();


    }

    public static Connection conectarBD() throws SQLException {
        /*
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
        */
         return Conexion.obtenerConexion();
    }

    public static void crearTabla() throws SQLException{
        Connection c = conectarBD();
        Statement s = null;
        try{
            s = c.createStatement();
            String sentenciaDDL = "CREATE TABLE Equipos ("
                    + "Id INT PRIMARY KEY IDENTITY(1,1),"
                    + "Nombre varchar(10) NOT NULL)";
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

    public static void agregarCampo() throws SQLException{
        Connection c = conectarBD();
        Statement s = null;
        try{
            s = c.createStatement();
            String sentenciaDDL = "ALTER TABLE Equipos ADD Presupuesto INT";
            s.executeUpdate(sentenciaDDL);
            System.out.println("Agregar campo ok");
        }catch (SQLException e){
            System.out.println("Agregar campo KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();
            if (c!=null) c.close();
        }
    }

    public static void eliminarTabla() throws SQLException{
        Connection c = conectarBD();
        Statement s = null;
        try{
            s = c.createStatement();
            String sentenciaDDL = "DROP TABLE Equipos;";
            s.executeUpdate(sentenciaDDL);
            System.out.println("Eliminar tabla ok");
        }catch (SQLException e){
            System.out.println("Eliminar tabla KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();
            if (c!=null) c.close();
        }
    }

    public static void insertarEquipo(String nombre, int presupuesto) throws SQLException{
        Connection c = conectarBD();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("INSERT INTO Equipos (nombre,presupuesto) VALUES (?,?);",
                Statement.RETURN_GENERATED_KEYS);
            s.setString(1,nombre);
            s.setInt(2,presupuesto);
            s.executeUpdate();
            System.out.println("Insertar equipo ok");

            //Obtener ID insertado
            ResultSet generatedKeys = s.getGeneratedKeys();
            if(generatedKeys.next()){
                int idGenerado = generatedKeys.getInt(1);
                System.out.println("Id insertado = "+idGenerado);
            }
        }catch (SQLException e){
            System.out.println("Insertar equipo KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
    }


    public static void actualizarEquipo(int id, String nombre, int presupuesto) throws SQLException{
        Connection c = conectarBD();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("UPDATE Equipos SET nombre=?,presupuesto=?  WHERE Id = ?");
            s.setString(1,nombre);
            s.setInt(2,presupuesto);
            s.setInt(3,id);
            s.executeUpdate();
            System.out.println("Actualizar equipo ok");
        }catch (SQLException e){
            System.out.println("Actualizar equipo KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
    }

    public static void borrarEquipo(String nombre) throws SQLException{
        Connection c = conectarBD();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("DELETE FROM Equipos WHERE nombre = ?");
            s.setString(1,nombre);

            s.executeUpdate();
            System.out.println("Borrar equipo ok");
        }catch (SQLException e){
            System.out.println("Borrar equipo KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
    }

    public static void buscarEquipos(String nombre) throws SQLException{
        Connection c = conectarBD();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("SELECT * FROM Equipos WHERE nombre = ?");
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

    public static void mostrarEquipos() throws SQLException{
        Connection c = conectarBD();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("SELECT * FROM Equipos");
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

    public static void mostrarEquiposLetra(String letra) throws SQLException{
        Connection c = conectarBD();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("SELECT * FROM Equipos WHERE Nombre like ?");
            s.setString(1,"%"+letra+"%");

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

    public static void llamarProcedimiento(String letra) throws SQLException{

        Connection c = conectarBD();
        CallableStatement s = null;

        try{
            s = c.prepareCall("{call obtenerEquipoLetras(?)}");
            s.setString(1,"%"+letra+"%");
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

    public static void gestionTransacciones() throws SQLException{
        Connection c = conectarBD();
        c.setAutoCommit(false);
        PreparedStatement s = null;

        try {
            s = c.prepareStatement("INSERT INTO Equipos "
                + "(nombre,presupuesto) VALUES (?,?) ");
            s.setString(1,"Pacers");
            s.setInt(2,40000);
            s.executeUpdate();
            System.out.println("Insertado equipo 1 OK");

            s.setString(1,"Clippers");
            s.setInt(2,450000);
            s.executeUpdate();
            System.out.println("Insertado equipo 2 OK");

            c.commit();
        }catch (Exception e){
            c.rollback();
            System.out.println("Insertado jugador KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();
            c.close();
        }
    }

}
