package org.example;

import java.io.*;
import java.util.Scanner;

/**
 *
 *
 */
public class App
{
    public static void main( String[] args ) throws IOException, InterruptedException {


        File fInput = new File("C://otro.txt");
        File fError = new File("C://error.txt");


        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "C://error.jar");
        pb.redirectInput(fInput);
        pb.redirectError(fError);
        Process p = pb.start();




        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String s = "";
        while((s = in.readLine()) != null){
            System.out.println(s);

        }



        int status = p.waitFor();
        System.out.println("Exited with status: " + status);



    }
}
