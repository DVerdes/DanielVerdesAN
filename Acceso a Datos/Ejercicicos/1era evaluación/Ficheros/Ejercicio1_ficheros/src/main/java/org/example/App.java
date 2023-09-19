package org.example;

import java.io.File;
import java.io.IOException;

/**
 * Main de ejercicio 1 de ficheros
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        String ruta = "C:\\Users\\FP\\Documents\\Ficheros\\EJ1";

        File directorio1 = new File("C:\\Users\\FP\\Documents\\Ficheros\\EJ1\\Directorio1");
        directorio1.mkdir();

        File directorio2 = new File("C:\\Users\\FP\\Documents\\Ficheros\\EJ1\\Directorio2");
        directorio2.mkdir();

        ruta += "\\Directorio1";

        System.out.println(ruta);

        File fichero1 = new File(ruta, "fichero1.txt");
        fichero1.createNewFile();

        File fichero2 = new File(ruta, "fichero2.txt");
        fichero2.createNewFile();

        ruta = "C:\\Users\\FP\\Documents\\Ficheros\\EJ1\\Directorio2";

        File fichero4 = new File(ruta, "fichero1.txt");
        fichero4.createNewFile();

        ruta = "C:\\Users\\FP\\Documents\\Ficheros\\EJ1";

        File fichero3 = new File(ruta, "fichero3.txt");
        fichero3.createNewFile();
    }
}
