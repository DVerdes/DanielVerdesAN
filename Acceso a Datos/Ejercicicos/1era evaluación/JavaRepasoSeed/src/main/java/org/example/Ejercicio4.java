package org.example;

/**
 * EJERCICIO 4
 */
public class Ejercicio4 {

    public static void main(String[] args) {
        // Introducir datos ejercicio
        int cargaMinima = 50;
        int cargaPorGolpe = 1;

        System.out.println(calcularGolpes(cargaMinima, cargaPorGolpe));
    }

    public static int calcularGolpes(int cargaMinima, int cargaPorGolpe) {
        

        return cargaMinima / cargaPorGolpe;
    }

}
