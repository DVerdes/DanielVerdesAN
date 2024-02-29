package org.example;

import java.sql.SQLException;

/**
 * EJERCICIO 2 DEL EXAMEN DE ORM
 */
public class Ejercicio2 {
    public static void main( String[] args ) throws SQLException {
        // Insertamos un actor en la película 1, "Hijo"
        ActorDAO.insertarActor(new Actor(1,"Juan","Pérez"));

        // Leemos el actor insertado
        Actor actor = ActorDAO.obtenerActor(1);
        // Imprimimos método ToString() del actor
        System.out.println(actor.toString());
        // Sacamos la película del actor y llamamos a su método ToString()
        System.out.println(actor.getPelicula().toString());
    }
}
