package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


/**
 * Clase que contiene el Ejercicio3 del examen
 */
public class Ejercicio3 {

    public static void main(String[] args) {

        // Ruta del fichero .json
        String ruta = "src\\ficEjercicio3\\Ejercicio3.json";

        try {
            // Invocamos método para leer .JSON
            leerJson(ruta);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * Método que lee fichero JSON e imprime datos de objetos Goleador contenidos en él
     *
     * @param ruta ruta del fichero JSON a leer
     * @throws FileNotFoundException
     */
    private static void leerJson(String ruta) throws FileNotFoundException {
        // Gson Builder
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        // Creamos fichero con ruta pasada por parámetro
        File fichero = new File(ruta);
        // Comprobamos si el fichero existe
        if (fichero.exists()) {
            // FileReader
            FileReader fr = new FileReader(fichero);
            // Guardamos contenido JSON en array
            Goleador[] goleadores = gson.fromJson(fr, Goleador[].class);
            // For each para imprimir datos array con método .toString()
            for (Goleador goleador : goleadores) {
                System.out.println(goleador.toString());
            }
        } else {
            System.out.println("No se ha encontrado el fichero especificado");
        }


    }


}
