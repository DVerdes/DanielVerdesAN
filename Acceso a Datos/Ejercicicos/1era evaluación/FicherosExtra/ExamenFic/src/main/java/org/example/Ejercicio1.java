package org.example;

import java.io.*;
import java.util.ArrayList;

/**
 * Clase que contiene el Ejercicio 1 del exámen
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        // String con ruta del archivo
        String ruta = "src\\ficEjercicio1\\Ejercicio1.dat";


        // Creamos ArrayList de objetos Atleta
        ArrayList<Atleta> atletas = new ArrayList<Atleta>();

        // Añadimos dos atletas al Array atletas
        atletas.add(new Atleta(12, "Juan", "García García"));
        atletas.add(new Atleta(34, "Pedro", "Suárez Pérez"));

        // Control de excepciones
        try {
            // Se llama al método para escribir objetos del array en la ruta especificada
            escribirObjetos(atletas, ruta);

            // Se llama al método para leer objetos de la ruta especificada
            leerObjetos(ruta);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    /**
     * Método que escribe objetos en un fichero .dat
     *
     * @param atletas ArrayList de objetos Atleta
     * @param ruta    String con ruta donde se va a guardar el archivo
     */
    private static void escribirObjetos(ArrayList<Atleta> atletas, String ruta) {

        // Creamos fichero (File)
        File fic = new File(ruta);

        // FileOutputStream
        FileOutputStream fos = null;
        // ObjectOutputStream
        ObjectOutputStream oos = null;


        try {
            // Generando fos/oos
            fos = new FileOutputStream(fic);
            oos = new ObjectOutputStream(fos);

            // for each para escribir objetos Atleta
            for (Atleta atleta : atletas) {
                oos.writeObject(atleta);
            }


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                // Cerramos fos/oos
                if (fos != null) fos.close();
                if (oos != null) oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


    /**
     * Método para leer objetos de ficheros .dat y sacar sus atributos por pantalla
     *
     * @param ruta ruta del fichero a leer
     * @throws IOException
     */
    private static void leerObjetos(String ruta) throws IOException {

        // Creamos ArrayList atletas
        ArrayList<Atleta> atletas = new ArrayList<>();
        // File
        File fic = new File(ruta);
        // File InputStream
        FileInputStream fis = null;
        // ObjetctInputStream
        ObjectInputStream ois = null;
        Atleta ciudad = new Atleta();


        try {
            fis = new FileInputStream(fic);
            ois = new ObjectInputStream(fis);


            while (true) {
                try {
                    // leemos objetos y añadimos a ArrayList
                    atletas.add((Atleta) ois.readObject());

                } catch (Exception e) {
                    // sacamos por pantalla objetos
                    for (Atleta atleta : atletas) {
                        System.out.println(atleta.getDorsal() + "-" + atleta.getNombre() + "-" + atleta.getApellidos());
                    }
                    break;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                // cerramos recursos
                if (fis != null) fis.close();
                if (ois != null) ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

}
