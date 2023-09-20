package org.example;

import sun.nio.cs.ISO_8859_2;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
    String ruta = "C:\\Users\\FP\\Documents\\Ficheros\\EJ5\\leer.txt";
        String ruta2 = "C:\\Users\\FP\\Documents\\Ficheros\\EJ5\\escribir.txt";

        int num = 0;

        FileInputStream is = new FileInputStream(ruta);
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);


        FileOutputStream os = new FileOutputStream(ruta2);
        OutputStreamWriter osw = new OutputStreamWriter(os , StandardCharsets.ISO_8859_1);

        while(num!=-1){
            num = isr.read();
            if(num!=-1){
                osw.write(num);
                System.out.println((char)num);
            }


        }

        isr.close();
        osw.close();


    }
}
