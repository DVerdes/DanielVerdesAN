package org.example;

import java.io.*;
import java.security.*;
import javax.crypto.*;

/**
 * Clase para desencriptación del archivo
 */
public class Desencriptacion {
    public static void main(String[] args) {
        try {

            // Recuperamos clave secreta del fichero clave.ken
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream("clave.ken"));
            Key clavesecreta = (Key) oin.readObject();
            oin.close();

            // Definimos el objeto Cipher, para desencriptar
            Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
            c.init(Cipher.DECRYPT_MODE, clavesecreta);

            // Creamos un objeto CipherlnputStream que va a descrifrar su contenido (el fichero .pdf cifrado)
            CipherInputStream in = new CipherInputStream(new FileInputStream("FicheroPDF.Cifrado"), c);

            // Obtenemos el tamaño de bloque del objeto Cipher creado
            int tambloque = c.getBlockSize();
            byte[] bytes = new byte[tambloque];

            // Fichero descifrado que se va a crear
            FileOutputStream fileout = new FileOutputStream("FICHEROdescifrado.pdf");

            // Vamos leyendo los bloques de bytes del fichero cifrado y se va escribieno al FileOutputStream ya desencriptados
            int i = in.read(bytes);
            while (i != -1) {
                fileout.write(bytes, 0, i);
                i = in.read(bytes);
            }
            // Cerramos recursos
            fileout.close();
            in.close();
            System.out.println("Se ha descifrado el fichero con éxito");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
