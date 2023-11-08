package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase para crear y operar con objetos Partida
 */
public class Partida {


    //identificador Partida
    private int id;

    //nombre del jugador
    private String nombreJugador;

    //puntos de golpe actuales
    private int puntosDeGolpe;

    //escenas recorridas
    private int escenasTotales;

    //puntuación final
    private int puntuacion;

    //objetos obtenidos
    private ArrayList<String> inventario;

    public Partida() {
    }

    public Partida(int id, String nombreJugador, int puntosDeGolpe, int escenasTotales, int puntuacion, ArrayList<String> inventario) {
        this.id = id;
        this.nombreJugador = nombreJugador;
        this.puntosDeGolpe = puntosDeGolpe;
        this.escenasTotales = escenasTotales;
        this.puntuacion = puntuacion;
        this.inventario = inventario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getPuntosDeGolpe() {
        return puntosDeGolpe;
    }

    public void setPuntosDeGolpe(int puntosDeGolpe) {
        this.puntosDeGolpe = puntosDeGolpe;
    }

    public int getEscenasTotales() {
        return escenasTotales;
    }

    public void setEscenasTotales(int escenasTotales) {
        this.escenasTotales = escenasTotales;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public ArrayList<String> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<String> inventario) {
        this.inventario = inventario;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "id=" + id +
                ", nombreJugador='" + nombreJugador + '\'' +
                ", puntosDeGolpe=" + puntosDeGolpe +
                ", escenasTotales=" + escenasTotales +
                ", puntuacion=" + puntuacion +
                ", inventario=" + inventario +
                '}';
    }
}
