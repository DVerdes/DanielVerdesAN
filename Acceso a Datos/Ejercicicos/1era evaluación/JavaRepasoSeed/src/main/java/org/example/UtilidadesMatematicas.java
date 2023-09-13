package org.example;

public class UtilidadesMatematicas {

    static double pi = 3.14159265359;

    public UtilidadesMatematicas() {
        
    }


    public static double calcularAreaCirculo(double radio) {
        return pi * radio * radio;
    }

    public static double calcularAreaRectangulo(double ancho, double alto) {
        return ancho * alto;
    }

    public static double calcularAreaTriangulo(double base, double altura) {
        return (base * altura) / 2;
    }

}
