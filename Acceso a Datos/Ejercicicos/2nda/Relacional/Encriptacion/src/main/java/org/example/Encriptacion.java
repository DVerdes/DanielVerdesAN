package org.example;
import java.io.*;
import java.security.*;
import javax.crypto.*;

/**
 * Clase para encriptación del archivo
 */
public class Encriptacion {

    public static void main( String[] args )
    {
        try {
            // Recuperamos clave secreta del fichero clave.ken
            ObjectInputStream oin = new ObjectInputStream( new FileInputStream("clave.ken"));
            Key clavesecreta = (Key) oin.readObject();
            oin.close();

            // Instanciamos un objeto Cipher en modo ENCRYPT
            Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, clavesecreta);

            // Fichero que vamos a encriptar
            FileInputStream filein = new FileInputStream("FICHERO.pdf");

            // Objeto CipherOutputStream que encriptará el fichero
            CipherOutputStream out = new CipherOutputStream(  new FileOutputStream("FicheroPDF.Cifrado"), c);

            // Obtenemos el tamaño de bloque del objeto Cipher creado
            int tambloque = c.getBlockSize();
            byte[] bytes = new byte[tambloque];

            // Leemos el fichero pdf en bloques de bytes y se va escribiendo al CipherOutputStream
            int i = filein.read(bytes);
            while (i != -1) {
                out.write(bytes, 0, i);
                i = filein.read(bytes);
            }
            // Cerramos recursos
            out.flush();
            out.close ();
            filein.close () ;
            System.out.println("Se ha cifrado el fichero con éxito");
        } catch (Exception e) {e .printStackTrace ();}
    }
}
