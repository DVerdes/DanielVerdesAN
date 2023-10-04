package org.example.entidades;

import com.google.gson.annotations.Expose;

public class Nombre {

    @Expose
    private String nombre;

    public Nombre(String nombre) {
        this.nombre = nombre;
    }

    public Nombre() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
