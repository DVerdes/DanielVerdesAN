package org.example;

import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("C://Pruebas//Cp420.txt"),"Cp420");
        int lectura = 0;
        String cadena = "";

        while(lectura!=-1){
            lectura = isr.read();
            if(lectura!=-1){
                cadena += (char)lectura;

            }
        }

        System.out.println(cadena);
    }
}
