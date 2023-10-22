package org.example;

public class Deportista {
    private String nombre;
    private int edad;
    private double salario;
    private double ingresosPublicidad;

    public Deportista(String nombre, int edad, double salario, double ingresosPublicidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.ingresosPublicidad = ingresosPublicidad;
    }

    public Deportista() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getIngresosPublicidad() {
        return ingresosPublicidad;
    }

    public void setIngresosPublicidad(double ingresosPublicidad) {
        this.ingresosPublicidad = ingresosPublicidad;
    }
}
