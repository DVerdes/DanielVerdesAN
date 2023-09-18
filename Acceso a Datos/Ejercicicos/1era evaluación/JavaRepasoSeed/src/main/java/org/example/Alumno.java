package org.example;


import java.io.Serializable;

public class Alumno implements Serializable {

    private String nombre;
    private int edad;
    private String matricula;
    private String carrera;


    public Alumno(String nombre, int edad, String matricula, String carrera) {
        this.nombre = nombre;
        this.edad = edad;
        this.matricula = matricula;
        this.carrera = carrera;
    }

    public void Alumnno() {

    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCarrera() {
        return carrera;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void mostrarInformacion() {
        System.out.println(nombre);
        System.out.println(edad);
        System.out.println(matricula);
        System.out.println(carrera);
    }


}
