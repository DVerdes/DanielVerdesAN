package org.example;

import java.net.*;  public class App {

    public static void main(String [ ] args) {
        InetAddress dir = null;
        try {
            //URL www.google.es
            System.out.println("======================================");
            System.out.println("SALIDA PARA UNA URL:");
            dir = InetAddress.getByName("www.yahoo.es");
            pruebaMetodos(dir);
            // Array de tipo InetAddress con todas las direcciones IP
            // asignadas a google.es
            System.out.println("\tDIRECCIONES IP PARA: " +
                    dir.getHostName());
            InetAddress[] direcciones =
                    InetAddress.getAllByName (dir.getHostName () ) ;
            for (int i = 0; i < direcciones.length; i++) {
                System.out.println("\t\t"+direcciones[i] .toString ());

            }


            System.out.println("=======================================");
            }catch (UnknownHostException el) {  el.printStackTrace();}

            }// main

private static void pruebaMetodos(InetAddress dir){
        System.out.println("\tMetodo getByName(): " + dir);
        InetAddress dir2;
        try {
            dir2 = InetAddress.getLocalHost();
            System.out.println("\tMetodo getLocalHost(): " + dir2);
        } catch (UnknownHostException e) {e .printStackTrace();}
        // USAMOS METODOS DE LA CLASE
    System.out.println("\t getHostName(): "+dir.getHostName());
        System.out.println("\t getHostAddress(): "+
                dir.getHostAddress());
        System.out.println("\t toStringO: " + dir.toString());
        System.out.println("\t getCanonicalHostName(): " +
                dir.getCanonicalHostName());   }//pruebaMetodos
     } //fin
