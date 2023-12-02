package org.example;

import java.io.*;

/**
 * PSP 3.2
 * Ejecutar otro programa desde actual
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException {

        //BufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));

        //ProcessBuilder (.jar programa comprobar palíndromos como argumento)
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "C://comprobacion_pal.jar");
        //Creamos y ejecutamos proceso
        Process p = pb.start();

        //getOutputStream -----> BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));

        System.out.println("Introduzca la cadena a comprobar");
        //Escribimos en outputStream
        bw.write(reader.readLine()+"\n");
        bw.flush();

        //getInputStream -----> BufferedReader
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        //Léemos linea a linea segundo programa
        String s = "";
        while((s = in.readLine()) != null){
            System.out.println(s);
        }

        //Finalización
        int status = p.waitFor();
        System.out.println("Exited with status: " + status);
    }
}
