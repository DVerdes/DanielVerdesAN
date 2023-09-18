package org.example;

public class MainEmpleado {

    public static void main(String[] args) {


        EmpleadoCompleto EmpleadoC1 = new EmpleadoCompleto("Jacinto", 34, 2300);
        EmpleadoPorHoras EmpleadoxH1 = new EmpleadoPorHoras("Pedro", 45, 160, 20);

        System.out.println(EmpleadoC1.calcularSalario());
        System.out.println(EmpleadoC1.obtenerDetalles());

        System.out.println(EmpleadoxH1.calcularSalario());
        System.out.println(EmpleadoxH1.obtenerDetalles());


    }

}
