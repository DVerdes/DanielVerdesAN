package org.example;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException {
        ArrayList <Pelicula> peliculas = JsonUtils.leerJSON("C:\\Pruebas\\peliculas.json");
        for(Pelicula pelicula: peliculas){
            System.out.println(pelicula.getTitulo()+"-"+pelicula.getCategoria()+"-"+pelicula.getReparto());
        }
    }
}
