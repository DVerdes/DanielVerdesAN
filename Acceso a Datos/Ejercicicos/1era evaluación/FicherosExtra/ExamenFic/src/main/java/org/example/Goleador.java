package org.example;


import com.google.gson.annotations.Expose;

/**
 * Clase para crear objetos Goleador empleados en el Ejercicio 3
 */
public class Goleador {


    @Expose
    private String jugador;

    @Expose
    private int goles;

    @Expose
    private int partidos;

    public Goleador() {
    }

    public Goleador(String jugador, int goles, int partidos) {
        this.jugador = jugador;
        this.goles = goles;
        this.partidos = partidos;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getPartidos() {
        return partidos;
    }

    public void setPartidos(int partidos) {
        this.partidos = partidos;
    }

    @Override
    public String toString() {
        return "Goleador{" +
                "jugador='" + jugador + '\'' +
                ", goles=" + goles +
                ", partidos=" + partidos +
                '}';
    }
}
