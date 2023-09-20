package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        String ruta = "C:\\Users\\FP\\Documents\\Ficheros\\EJ3\\leer.txt";
        String ruta2 = "C:\\Users\\FP\\Documents\\Ficheros\\EJ3\\escribir.txt";
        String cadena = "";
        int num = 0;

        
        FileInputStream stream = new FileInputStream(ruta);



        FileOutputStream streamOu = new FileOutputStream(ruta2);

        while(num!=-1){

            num = stream.read();
            if(num!=-1){
                streamOu.write(num);

            }

        }

    }
}
