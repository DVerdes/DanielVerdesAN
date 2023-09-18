package org.example;

public class EmpleadoCompleto implements Empleado {

    private String nombre;
    private int edad;
    private double salario;

    public EmpleadoCompleto(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    @Override
    public double calcularSalario() {
        return salario;
    }

    @Override
    public String obtenerDetalles() {
        String cadenaEdad = String.valueOf(edad);
        return nombre + " " + cadenaEdad;
    }
}
