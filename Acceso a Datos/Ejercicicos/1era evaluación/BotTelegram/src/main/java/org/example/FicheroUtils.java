package org.example;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Clase con métodos para trabajar con ficheros de texto
 */
public class FicheroUtils {

    /**
     * Método que busca en el .txt la criatura especificada y devuelve sus estadísticas
     *
     * @param criaturaBuscada id de la criatura de la que se desean sacar las estadísticas
     * @return String con estadísticas completas de la criatura
     * @throws IOException
     */
    public static String leerDatosCriatura(String criaturaBuscada) throws IOException {

        // String para guardar estadísticas
        String cadenaInfo = "";

        // int para dirigir lectura
        int numLectura = 0;

        //FileInputStream con ruta del txt
        FileInputStream stream = new FileInputStream("src\\txt\\criaturasInfo.txt");

        //Guarda en String contenido .txt
        while (numLectura != -1) {
            numLectura = stream.read();
            if (numLectura != -1) {
                cadenaInfo += (char) numLectura + "";
            }
        }

        //Se splitea el contenido del txt en diferentes String, cada uno contiene info de una criatura
        String[] criaturas = cadenaInfo.split(";");

        //Bucle for para recurrer el array de criaturas y, mediante el método contains, devolver la criatura requerida
        for (int i = 0; i < criaturas.length; i++) {
            if (criaturas[i].contains(criaturaBuscada)) {
                String[] criaturaInfo = criaturas[i].split(":");
                return criaturaInfo[0] + ":\nEstadísticas: " + criaturaInfo[1] + "\nPg: " + criaturaInfo[2] + ", Iniciativa: " + criaturaInfo[3] + ", CA: " + criaturaInfo[4] + "\nAtaques: " + criaturaInfo[5] + " " + criaturaInfo[6];

            }
        }
        //return en caso de id no encontrada
        return "No se ha encontrado la criatura especificada.";
    }

}
