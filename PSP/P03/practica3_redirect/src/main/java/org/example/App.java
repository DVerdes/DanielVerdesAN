package org.example;

import java.io.*;

/**
 * PSP 3.3
 * Redireccionamiento
 */
public class App
{
    public static void main( String[] args ) throws IOException, InterruptedException {

        //File
        //Archivo de texto con input
        File fInput = new File("C://input.txt");
        //Archivo de texto para almacenar error
        File fError = new File("C://error.txt");

        //ProcessBuilder con .jar del comprobador de palíndromos como argumento
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "C://comprobacion_pal_error.jar");
        //redireccionamiento de entrada
        pb.redirectInput(fInput);
        //redireccionamiento de error
        pb.redirectError(fError);
        //creación y ejecución de proceso
        Process p = pb.start();

        //InputStream ----> BufferedReader
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String s = "";
        while((s = in.readLine()) != null){
            System.out.println(s);
        }

        //Finalización
        int status = p.waitFor();
        System.out.println("Exited with status: " + status);

    }
}
