package org.example;

public class EmpleadoPorHoras implements Empleado {

    private String nombre;
    private int edad;
    private int horasTrabajadas;
    private double tarifaPorHora;

    public EmpleadoPorHoras(String nombre, int edad, int horasTrabajadas, double tarifaPorHora) {
        this.nombre = nombre;
        this.edad = edad;
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }

    @Override
    public double calcularSalario() {
        return horasTrabajadas * tarifaPorHora;
    }

    @Override
    public String obtenerDetalles() {
        String cadenaEdad = String.valueOf(edad);
        return nombre + " " + cadenaEdad;
    }
}
