package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Partida {


    private int id;

    private String nombreJugador;

    private int puntosDeGolpe;

    private int escenasTotales;

    private ArrayList<String> inventario;

    public Partida() {
    }

    public Partida(int id, String nombreJugador, int puntosDeGolpe, int escenasTotales, ArrayList<String> inventario) {
        this.id = id;
        this.nombreJugador = nombreJugador;
        this.puntosDeGolpe = puntosDeGolpe;
        this.escenasTotales = escenasTotales;
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
                ", inventario=" + inventario +
                '}';
    }
}
