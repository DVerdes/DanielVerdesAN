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

        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.next();


        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "C://p2.jar");
        Process p = pb.start();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));


        bw.write(entrada + "\n");
        bw.flush();


        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String s = "";
        while((s = in.readLine()) != null){
            System.out.println(s);

        }



        int status = p.waitFor();
        System.out.println("Exited with status: " + status);



    }
}
