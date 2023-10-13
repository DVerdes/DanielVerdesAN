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
        String ruta = "src\\Ficheros\\leer.txt";
        String numeros = "";
        String hexa = "";
        String linea = "";
        String elegida = "Zombi";
        String info = "";
        int num = 0;



        FileInputStream stream = new FileInputStream(ruta);





        while (num!=-1){

            num = stream.read();
            if(num!=-1){
                numeros += num+"-";
                hexa += Integer.toHexString(num)+"-";
                linea += (char)num + "";
            }

        }



        System.out.println(numeros);
        System.out.println(hexa);
        System.out.println(linea);

        String[] criaturas = linea.split(";");
        System.out.println(criaturas[0]);
        System.out.println(criaturas[1]);

        for(int i = 0; i<criaturas.length; i++){
            if(criaturas[i].contains(elegida)){
                String [] criaturaInfo = criaturas[i].split(":");
                info = criaturaInfo[0]+":\nEstadísticas: "+criaturaInfo[1]+"\nPg: "+criaturaInfo[2]+", Iniciativa: "+criaturaInfo[3]+", CA: "+criaturaInfo[4]+"\nAtaques: "+criaturaInfo[5]+" "+criaturaInfo[6];

            }
        }

        System.out.println(info);

    }
}



