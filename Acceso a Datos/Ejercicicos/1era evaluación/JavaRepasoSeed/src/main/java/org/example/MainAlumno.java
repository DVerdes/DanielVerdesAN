package org.example;

public class MainAlumno {


    public static void main(String[] args) {

        Alumno alumno1 = new Alumno("Juan", 16, "4567Y", "humanidades");

        alumno1.mostrarInformacion();

        if (alumno1.getEdad() >= 18) {
            System.out.println("El alumno es mayor de edad");
        } else {
            System.out.println("El alumno es menor de edad");
        }


    }


}
