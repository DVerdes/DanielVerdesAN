package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        String ruta = "C:\\Users\\FP\\Documents\\Ficheros\\EJ2\\leer.txt";
        String numeros = "";
        String hexa = "";
        String linea = "";
        int num = 0;

        FileInputStream stream = new FileInputStream(ruta);



        while (num!=-1){

            num = stream.read();
            if(num!=-1){
                numeros += num+"-";
                hexa += Integer.toHexString(num)+"-";
                linea += (char)num + "-";
            }

        }

        System.out.println(numeros);
        System.out.println(hexa);
        System.out.println(linea);

    }
}



