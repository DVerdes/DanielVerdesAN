package org.example;

public class Main {

    public static void main(String[] args) {

        Estudiante e1 = new Estudiante("Jorge", 23, "45HTRY", "Ingenieria");
        e1.mostrarInformacion();
        if (e1.esMayorDeEdad()) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }


    }


}
