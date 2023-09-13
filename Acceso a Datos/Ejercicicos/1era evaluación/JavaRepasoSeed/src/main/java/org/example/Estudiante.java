package org.example;

public class Estudiante {

    // atributos

    public String Nombre;
    public int Edad;
    public String Matricula;
    public String Carrera;

    // constructor

    public Estudiante(String Nombre, int Edad, String Matricula, String Carrera) {
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Matricula = Matricula;
        this.Carrera = Carrera;
    }

    // getters


    public void mostrarInformacion() {
        System.out.println(Nombre);
        System.out.println(Edad);
        System.out.println(Matricula);
        System.out.println(Carrera);
    }

    public boolean esMayorDeEdad() {
        if (Edad >= 18) {
            return true;
        } else {
            return false;
        }
    }


}


