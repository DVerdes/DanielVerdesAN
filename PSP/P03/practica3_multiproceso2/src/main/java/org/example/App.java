package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * PSP 3.1
 * Comprobar palíndromo
 */
public class App
{
    public static void main( String[] args ) throws IOException {
        //BufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        //Cadena de texto
        String cadena = "";

        while (true){
            try {
                //Introducir cadena
                cadena = reader.readLine().toLowerCase();
                //Cadena vacía
                if(cadena.length()==0){
                    System.out.println("La cadena está vacía (longitud es 0)");
                    break;
                }
                //Comprobar si es palíndromo
                if (comprobarPalíndromo(cadena)) {
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
        int numero = 1/0;
    }

    /**
     * Comprueba si la cadena es un palíndromo
     * @param cadena cadena de texto scanneada
     * @return TRUE/FALSE si es o no palíndromo
     */
    static boolean comprobarPalíndromo(String cadena){
        cadena = cadena.replace(" ","");
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
