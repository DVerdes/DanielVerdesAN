package org.example;

import java.io.Serializable;

/**
 * Clase para crear instancias de Juego
 */
public class Juego implements Serializable {

    private int id;

    private String nombre;

    private int anho;

    private float recaudacion_ventas;

    public Juego() {
    }

    public Juego(int id, String nombre, int anho, float recaudacion_ventas) {
        this.id = id;
        this.nombre = nombre;
        this.anho = anho;
        this.recaudacion_ventas = recaudacion_ventas;
    }

    public Juego(String nombre, int anho, float recaudacion_ventas) {
        this.nombre = nombre;
        this.anho = anho;
        this.recaudacion_ventas = recaudacion_ventas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    public float getRecaudacion_ventas() {
        return recaudacion_ventas;
    }

    public void setRecaudacion_ventas(float recaudacion_ventas) {
        this.recaudacion_ventas = recaudacion_ventas;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", anho=" + anho +
                ", recaudacion_ventas=" + recaudacion_ventas +
                '}';
    }
}
