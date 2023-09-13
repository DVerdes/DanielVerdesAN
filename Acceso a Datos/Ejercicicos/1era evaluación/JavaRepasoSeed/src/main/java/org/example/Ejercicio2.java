package org.example;

/**
 * EJERCICIO 2
 */
public class Ejercicio2 {

    public static void main( String[] args )
    {
        // Introducir datos ejercicio
        int n = 4;

        System.out.println(contarNumerosQueCumplen(n));
    }

    public static int contarNumerosQueCumplen(int n) {
        int contAmigos = 0;
        for(int i = 1; i<=100; i ++){
            if(i<10){
                if(i==n && i!=1){
                    contAmigos++;
                }
            }else if(i>=10 && i<100){
                if(((i%10)*(i/10)==n)&& (i%10!=1) && (i/10!=1)){
                    contAmigos++;
                }
            }else{

            }
        }


        return contAmigos;
    }

}
