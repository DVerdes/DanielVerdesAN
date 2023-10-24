package org.example;

import java.io.Serializable;

/**
 * Clase para creación de objetos Atleta (Ejercicio 1)
 */
public class Atleta implements Serializable {
    private int dorsal;

    private String nombre;

    private String apellidos;

    public Atleta() {
    }

    public Atleta(int dorsal, String nombre, String apellidos) {
        this.dorsal = dorsal;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
