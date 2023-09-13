package org.example;

/**
 * EJERCICIO 3
 */
public class Ejercicio3 {

    public static void main( String[] args )
    {
        // Introducir datos ejercicio
        int numElfos = 5;
        int numEnanos = 5;
        int plazasPorHabitacion = 4;

        System.out.println(calcularHabitaciones(numElfos,numEnanos,plazasPorHabitacion));
    }

    public static int calcularHabitaciones(int numElfos, int numEnanos, int plazasPorHabitacion) {
        int habElfos = numElfos/plazasPorHabitacion;
        if(numElfos%plazasPorHabitacion!=0){
            habElfos++;
        }

        int habEnanos = numEnanos/plazasPorHabitacion;
        if(numEnanos%plazasPorHabitacion!=0){
            habEnanos++;
        }

        return habElfos+habEnanos;
    }


}
