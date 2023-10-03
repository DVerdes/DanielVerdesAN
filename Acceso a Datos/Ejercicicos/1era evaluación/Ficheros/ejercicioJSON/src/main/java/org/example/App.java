package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * JSON
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        ArrayList <MascotaGSON> mascotas = leerJSON("src\\json\\mascotas.json");

        for(MascotaGSON m: mascotas){
            System.out.println(m.getNombre());
            System.out.println("Tipo: "+m.getTipo());
            System.out.println("Edad: "+m.getEdad());
            System.out.println("Género: "+m.getGenero());
            System.out.println();
        }

        File fichero1 = new File("src\\json", "fichero1.json");
        fichero1.createNewFile();

        FileWriter fw = new FileWriter(fichero1);
        fw.write(escribirJSON(mascotas));
        fw.close();


    }



    public static ArrayList <MascotaGSON> leerJSON(String ruta) throws FileNotFoundException{
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        FileReader fr = new FileReader(ruta);
        MascotaGSON[] mascotas = gson.fromJson(fr, MascotaGSON[].class);
        return new ArrayList<MascotaGSON>(Arrays.asList(mascotas));
    }// leer JSON

    public static String escribirJSON(ArrayList<MascotaGSON> listaMascotas) throws FileNotFoundException{
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String json = gson.toJson(listaMascotas);
        return json;
    }// escribirJson



}
