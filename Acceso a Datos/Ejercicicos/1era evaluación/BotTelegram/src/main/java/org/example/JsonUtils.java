package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.entidades.Nombre;

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
     * @param listaNombres ArrayList con listado de objetos Nombre
     * @return lista sobreeescrita
     * @throws FileNotFoundException
     */
    public static String escribirJSON(ArrayList<Nombre> listaNombres) throws FileNotFoundException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String json = gson.toJson(listaNombres);
        return json;
    }// escribirJson

    /**
     * Método para leer fichero JSON
     *
     * @param ruta ruta del fichero
     * @return ArrayList con contenido del fichero en forma de objetos Nombre
     * @throws FileNotFoundException
     */
    public static ArrayList<Nombre> leerJSON(String ruta) throws FileNotFoundException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        FileReader fr = new FileReader(ruta);
        Nombre[] nombres = gson.fromJson(fr, Nombre[].class);
        return new ArrayList<Nombre>(Arrays.asList(nombres));
    }// leer JSON


    /**
     * Método para añadir nombre al fichero JSON
     *
     * @param nombreSugerido nombre facilitado mediante comando
     * @return confirmación de nombre añadido
     * @throws IOException
     */
    public static String anadirNombre(String nombreSugerido) throws IOException {
        ArrayList<Nombre> listaNombres = JsonUtils.leerJSON("src\\json\\names.json");
        listaNombres.add(new Nombre(nombreSugerido));


        File fichero1 = new File("src\\json\\names.json");
        fichero1.createNewFile();

        FileWriter fw = new FileWriter(fichero1);
        fw.write(JsonUtils.escribirJSON(listaNombres));
        fw.close();

        return nombreSugerido + " añadido con éxito.";

    }

}
