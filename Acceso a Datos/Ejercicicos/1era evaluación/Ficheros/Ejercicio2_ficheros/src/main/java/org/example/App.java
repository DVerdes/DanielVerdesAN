package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        FileInputStream stream = null;

        try {


            String ruta = "src\\Ficheros\\leer.txt";
            String numeros = "";
            String hexa = "";
            String linea = "";
            int num = 0;


            stream = new FileInputStream(ruta);


            while (num != -1) {

                num = stream.read();
                if (num != -1) {
                    numeros += num + "-";
                    hexa += Integer.toHexString(num) + "-";
                    linea += (char) num + "";
                }

            }


            System.out.println(numeros);
            System.out.println(hexa);
            System.out.println(linea);



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(stream!=null) stream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}



