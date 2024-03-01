package org.example;

import java.io.*;
import java.security.*;
import javax.crypto.*;

/**
 * Clase para generar archivo de clave
 */
public class GeneraClave {

    public static void main(String[] args) {
        try {
            // KeyGenerator con algoritmo AES
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            // Tamaño de clave
            kg.init(128);
            // Generamos clave secreta
            SecretKey clave = kg.generateKey();
            // La escribimos en un fichero
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("clave.ken"));
            out.writeObject(clave);
            out.close();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//main
}



