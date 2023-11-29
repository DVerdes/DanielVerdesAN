package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));

        Scanner scanner = new Scanner(System.in);
        int contador = 0;
        boolean esPalindromo = false;
        String cadena = "";





        while (true){
            try {
                System.out.println( "Introduzca una cadena de texto" );
                cadena = reader.readLine();
                if(cadena.length()==0){
                    System.out.println("La longitud es 0");
                    break;
                }
                if (esPalindromo = comprobarPalíndromo(cadena)) {
                    System.out.println("La cadena es palíndromo");
                } else {
                    System.out.println("La cadena no es palíndromo");
                }
                break;
            }catch (Exception e){
                System.out.println("Introduzca un valor correcto");
            }
        }

        System.out.println("Finalizando programa...");
        //int i = 1/0;

    }

    /**
     * Comprueba si la cadena es un palíndromo
     * @param cadena cadena de texto scanneada
     * @return TRUE/FALSE si es o no palíndromo
     */
    static boolean comprobarPalíndromo(String cadena){
        int contador = cadena.length()-1;
        for(int i = 0; i<cadena.length();i++){
            if(cadena.charAt(i)==cadena.charAt(contador)){
                contador--;
            }else{
                return false;
            }
        }
        return true;
    }
}
