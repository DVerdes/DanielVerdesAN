package org.example;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        File file = new File("C://Pruebas");
        File copia = new File("C://Pruebas//Copia");

        File [] listaFiles = file.listFiles();

        copia.mkdir();

        DateFormat df = new SimpleDateFormat("yyyyMMdd");

        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);






        for(File f: listaFiles){
            if(!f.isDirectory()){
                String [] spliteo = f.getName().split("\\.");
                System.out.println(spliteo[0]);
                String ruta = "C://Pruebas//Copia//"+spliteo[0]+"_"+reportDate+"."+spliteo[1];
                File fichero = new File(ruta);
                fichero.createNewFile();
            }

        }



    }
}
