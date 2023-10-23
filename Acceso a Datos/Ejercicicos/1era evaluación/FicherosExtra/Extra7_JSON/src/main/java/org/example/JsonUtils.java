package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase con métodos para tratamiento de ficheros .json
 */
public class JsonUtils {

    /**
     * Método para escribir en fichero .JSON
     *
     * @param listaNombres ArrayList con listado de objetos
     * @return lista sobreeescrita
     * @throws FileNotFoundException
     */
    public static String escribirJSON(ArrayList<Pelicula> listaNombres) throws FileNotFoundException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String json = gson.toJson(listaNombres);
        return json;
    }// escribirJson

    /**
     * Método para leer fichero JSON
     *
     * @param ruta ruta del fichero
     * @return ArrayList con contenido del fichero en forma de objetos
     * @throws FileNotFoundException
     */
    public static ArrayList<Pelicula> leerJSON(String ruta) throws FileNotFoundException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        FileReader fr = new FileReader(ruta);
        Pelicula[] peliculas = gson.fromJson(fr, Pelicula[].class);
        return new ArrayList<Pelicula>(Arrays.asList(peliculas));
    }// leer JSON





}
