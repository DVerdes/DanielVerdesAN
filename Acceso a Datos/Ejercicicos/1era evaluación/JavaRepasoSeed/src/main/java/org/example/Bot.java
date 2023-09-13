package org.example;

public class Bot {

    // atributos
    protected String nombre;

    public Bot(String nombre) {
        this.nombre = nombre;
    }

    public String saludar() {
        String s = "Hola, me llamo " + nombre;
        return s;
    }

    public String despedir() {
        return "Adiós";
    }
}
