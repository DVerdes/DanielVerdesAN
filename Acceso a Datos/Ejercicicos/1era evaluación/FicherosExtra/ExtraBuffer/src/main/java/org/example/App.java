package org.example;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        BufferedReader br = null;
        FileReader fr = null;
        String ruta = "C://Pruebas//notas.txt";
        String linea = "";
        String cadena = "";

        try {
            fr = new FileReader(ruta);
            br = new BufferedReader(fr);

            //StringBuilder todasNotas = new StringBuilder();
            linea += br.readLine();


            while (linea!=null){
                //todasNotas.append(linea);
                cadena += linea;
                 linea = br.readLine();

            }

            System.out.println(cadena);

            String [] notas = cadena.split("[|]");

            float notaTotal = 0;

            for(String nota: notas){
                float notaD = Float.parseFloat(nota);
                notaTotal+=notaD;
            }

            System.out.println("Nota media: "+notaTotal/notas.length);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(fr!=null) fr.close();
                if(br!=null) br.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
