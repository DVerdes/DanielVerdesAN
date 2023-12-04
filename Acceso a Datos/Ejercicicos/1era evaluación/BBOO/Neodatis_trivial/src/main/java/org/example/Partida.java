package org.example;

import java.util.ArrayList;

/**
 * Clase para generar objetos partida
 */
public class Partida {

    private ArrayList <Jugador> jugadores;

    public Partida() {
    }

    public Partida(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "jugadores=" + jugadores +
                '}';
    }
}
