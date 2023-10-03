package org.example;

import com.google.gson.annotations.Expose;

public class MascotaGSON {

    @Expose(serialize = false, deserialize = true)
    private String nombre;

    @Expose
    private String tipo;

    @Expose
    private int edad;

    @Expose
    private String genero;

    public MascotaGSON() {
    }

    public MascotaGSON(String nombre, String tipo, int edad, String genero) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.edad = edad;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
