package org.example;

import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        File file = new File("C://Pruebas//leyenda.txt");
        FileReader fr = new FileReader(file);
        int num = 0;
        String cadena = "";

        while (num!=-1){
            num = fr.read();
            if(num!=-1){
                cadena += (char)num;
            }
        }

        System.out.println(cadena);

        String cadenaReplace = cadena.replace("c","C");

        File file2 = new File("C://Pruebas//leyendaNueva.txt");
        FileWriter fw = new FileWriter(file2);
        fw.write(cadenaReplace);
        fw.close();
        file2.createNewFile();
    }
}
