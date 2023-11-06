package org.example;

import java.util.Arrays;

public class Escena {


    private int id;
    private String texto;
    private Elección[] elecciones;

    public Escena() {
    }

    public Escena(int id, String texto, Elección[] elecciones) {
        this.id = id;
        this.texto = texto;
        this.elecciones = elecciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Elección[] getElecciones() {
        return elecciones;
    }

    public void setElecciones(Elección[] elecciones) {
        this.elecciones = elecciones;
    }

    @Override
    public String toString() {
        return "Escena{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                ", elecciones=" + Arrays.toString(elecciones) +
                '}';
    }
}
