package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {



        String ruta = "C:\\Users\\FP\\Documents\\Ficheros\\EJ4\\notas.txt";
        String cadena = "";
        int num = 0;
        double numero = 0;


        // si se hace con buffered el num != null

        FileReader filereader = new FileReader(ruta);
      while(num != -1){
          num = filereader.read();
          if(num != -1){

              cadena += (char)num;
          }


      }
        String [] medias = cadena.split("[|]");


      for(int i = 0; i< medias.length; i++){
//
          numero += Double.parseDouble(medias[i]);
//
      }
//
        System.out.println(numero/medias.length);



    }
}
