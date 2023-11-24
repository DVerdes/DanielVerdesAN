package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        int contador = 0;
        boolean esPalindromo = false;
        String cadena = "";

        while (true){
            try {
                System.out.println( "Introduzca una cadena de texto" );
                cadena = scanner.nextLine().toUpperCase();
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
