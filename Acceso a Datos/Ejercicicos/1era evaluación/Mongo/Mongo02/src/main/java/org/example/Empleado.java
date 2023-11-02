package org.example;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Empleado {

    private String nombre;

    private int edad;

    private boolean contratoFijo;

    private LocalDateTime alta;

    private double sueldo;

    private Telefono [] telefonos;

    public Empleado() {
    }

    public Empleado(String nombre, int edad, boolean contratoFijo, double sueldo, Telefono[] telefonos) {
        this.nombre = nombre;
        this.edad = edad;
        this.contratoFijo = contratoFijo;
        this.alta = LocalDateTime.now();
        this.sueldo = sueldo;
        this.telefonos = telefonos;
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

    public boolean isContratoFijo() {
        return contratoFijo;
    }

    public void setContratoFijo(boolean contratoFijo) {
        this.contratoFijo = contratoFijo;
    }

    public LocalDateTime getAlta() {
        return alta;
    }

    public void setAlta(LocalDateTime alta) {
        this.alta = alta;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Telefono[] getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Telefono[] telefonos) {
        this.telefonos = telefonos;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", contratoFijo=" + contratoFijo +
                ", alta=" + alta +
                ", sueldo=" + sueldo +
                ", telefonos=" + Arrays.toString(telefonos) +
                '}';
    }
}
