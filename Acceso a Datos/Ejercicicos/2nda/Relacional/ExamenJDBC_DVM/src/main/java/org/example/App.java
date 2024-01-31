package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase main ExamenJDBC
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {

        // Insertar juegos
        Juego juego1990 = new Juego("Mario",1990,4000);
        Juego juego1890 = new Juego("Zelda",1890,6000);

        juego1990 = insertarJuego(juego1990);
        juego1890 = insertarJuego(juego1890);

        // Listar juegos por año
        List <Juego> juegos = listarPorAnho(1990);

        for(Juego juego: juegos) System.out.println(juego.toString());

        // Modificar juego
        juegos.get(0).setNombre("Tetris");
        modificar(juegos.get(0));

        // Volver a listar juegos por año
        juegos = listarPorAnho(1990);
        for(Juego juego: juegos) System.out.println(juego.toString());

        //eliminarTabla();

        // Crear lista con 9500 instancias
        List <Juego> listaLarga = new ArrayList<Juego>();

        for(int i = 0; i<9500; i++){
            listaLarga.add(new Juego("Pong",1985,9000));
        }

        // Insertar objetos lista en lotes y bajo transaccion
        insertarLote(listaLarga);

    }

    /**
     * Devuelve un objeto Connection desde el método obtenerConexion() de la clase Conexion
     * @return Connection
     * @throws SQLException
     */
    public static Connection conectarBD() throws SQLException {
        return Conexion.obtenerConexion();
    }

    /**
     * Inserta un juego en la BBDD
     * @param juego Juego a insertar
     * @return juego insertado junto a su id
     * @throws SQLException
     */
    public static Juego insertarJuego(Juego juego) throws SQLException{
        Connection c = conectarBD();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("INSERT INTO Juegos (Nombre,Anho,Recaudacion_ventas) VALUES (?,?,?);",
                    Statement.RETURN_GENERATED_KEYS);
            s.setString(1, juego.getNombre());
            s.setInt(2,juego.getAnho());
            s.setFloat(3,juego.getRecaudacion_ventas());
            s.executeUpdate();
            System.out.println("Insertar juego ok");

            //Obtener ID insertado
            ResultSet generatedKeys = s.getGeneratedKeys();
            if(generatedKeys.next()){
                juego.setId(generatedKeys.getInt(1));
                return juego;
            }
            return null;
        }catch (SQLException e){
            System.out.println("Insertar juego KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
    }


    /**
     * Devuelve listado de juegos en bbdd por año
     * @param anho año de búsqueda
     * @return listado de juegos
     * @throws SQLException
     */
    public static List<Juego> listarPorAnho(int anho) throws SQLException{
        List <Juego> juegos = new ArrayList<Juego>();
        Connection c = conectarBD();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("SELECT * FROM Juegos WHERE Anho = ?");
            s.setInt(1,anho);
            ResultSet res = s.executeQuery();
            while (res.next()){
                juegos.add(new Juego(res.getInt("IdJuego"),res.getString("Nombre"),res.getInt("Anho"),res.getFloat("Recaudacion_ventas")));
            }
            return juegos;
        }catch (SQLException e){
            System.out.println("Consulta KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
    }

    /**
     * Modifica un juego ya persistido en BBDD
     * @param juego Juego a modificar con atributos modificados
     * @throws SQLException
     */
    public static void modificar(Juego juego) throws SQLException{
        Connection c = conectarBD();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("UPDATE Juegos SET Nombre=?, Anho=?, Recaudacion_ventas=?  WHERE IdJuego = ?");
            s.setString(1,juego.getNombre());
            s.setInt(2,juego.getAnho());
            s.setFloat(3,juego.getRecaudacion_ventas());
            s.setInt(4,juego.getId());
            s.executeUpdate();
            System.out.println("Actualizar juego ok");
        }catch (SQLException e){
            System.out.println("Actualizar juego KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
    }

    /**
     * Elimina la tabla Juegos de la BBDD
     * @throws SQLException
     */
    public static void eliminarTabla() throws SQLException{
        Connection c = conectarBD();
        Statement s = null;
        try{
            s = c.createStatement();
            String sentenciaDDL = "DROP TABLE Juegos;";
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


    /**
     * Inserta en BBDD listado de juegos por lotes mediante una transacción
     * @param listaJuegos listado de juegos a persistir
     * @throws SQLException
     */
    public static void insertarLote(List <Juego> listaJuegos) throws SQLException{
        int contador = 0;
        Connection c = conectarBD();
        c.setAutoCommit(false);
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("INSERT INTO Juegos (Nombre,Anho,Recaudacion_ventas) VALUES (?,?,?);",
                    Statement.RETURN_GENERATED_KEYS);

            for(Juego juego : listaJuegos){
                    s.setString(1,juego.getNombre());
                    s.setInt(2,juego.getAnho());
                    s.setFloat(3,juego.getRecaudacion_ventas());
                    s.addBatch();
                    contador++;
                    if(contador%1000==0){
                        s.executeBatch();
                    }
            }
            s.executeBatch();

            c.commit();

            System.out.println("Insertados juegos ok");
        }catch (SQLException e){
            c.rollback();

            System.out.println("Insertar juegos KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
    }


}
