package org.example;

import java.sql.SQLException;

/**
 * EJERCICIO 1 DEL EXÁMEN DE ORM
 */
public class Ejercicio1 {
    public static void main( String[] args ) throws SQLException {
        //CREATE
        PeliculaDAO.crearPelicula(new Pelicula("Hijo",1890,"Terror"));
        PeliculaDAO.crearPelicula(new Pelicula("El señor de los anillos",2001,"Fantasía"));
        PeliculaDAO.crearPelicula(new Pelicula("Troya",2004,"Histórica"));
        PeliculaDAO.crearPelicula(new Pelicula("Pelicula antigua",1880,"Suspense"));


        //READ
        System.out.println(PeliculaDAO.obtenerPelicula(1).toString());

        //UPDATE
        PeliculaDAO.actualizarPelicula(new Pelicula(3,"El reino de los cielos",2005,"Histórica"));

        //DELETE
        PeliculaDAO.eliminarPelicula(2);

        //Listar peliculas con "H"
        for(Pelicula p : PeliculaDAO.listarPorLetra("T")) System.out.println(p.toString());

        //Listar anteriores a 1900
        for(Pelicula p : PeliculaDAO.consultarPeliculasAnteriores("1900")) System.out.println(p.toString());

    }

}
