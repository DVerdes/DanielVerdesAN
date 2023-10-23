package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, ClassNotFoundException {

        ArrayList <Ciudad> ciudades = new ArrayList<Ciudad>();
        /*
        ciudades.add(new Ciudad(12, "Madrid", "Espana","Centro"));
        ciudades.add(new Ciudad(0,"Barcelona", "Espana","Este"));
        ciudades.add(new Ciudad(2,"Santiago", "Chile","Centro"));


        CiudadMapping.escribirFichero("C://Pruebas//ciudadesNuevas.dat",ciudades);
        */
        ciudades = CiudadMapping.leerCiudad("C://Pruebas//ciudades.dat");




        for(Ciudad ciudad: ciudades){
            System.out.println(ciudad.toString());
        }


    }
}
