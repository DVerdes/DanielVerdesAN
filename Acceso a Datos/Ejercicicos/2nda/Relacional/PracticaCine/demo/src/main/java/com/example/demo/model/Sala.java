package com.example.demo.model;

import java.io.Serializable;

public class Sala implements Serializable {

    private int salaId;

    private int cineId;

    private String nombreSala;

    private int capacidad;

    private int filas;

    private int butacasPorFila;

    public Sala() {
    }

    public Sala(int salaId, int cineId, String nombreSala, int capacidad, int filas, int butacasPorFila) {
        this.salaId = salaId;
        this.cineId = cineId;
        this.nombreSala = nombreSala;
        this.capacidad = capacidad;
        this.filas = filas;
        this.butacasPorFila = butacasPorFila;
    }

    public Sala(int cineId, String nombreSala, int capacidad, int filas, int butacasPorFila) {
        this.cineId = cineId;
        this.nombreSala = nombreSala;
        this.capacidad = capacidad;
        this.filas = filas;
        this.butacasPorFila = butacasPorFila;
    }

    public int getSalaId() {
        return salaId;
    }

    public void setSalaId(int salaId) {
        this.salaId = salaId;
    }

    public int getCineId() {
        return cineId;
    }

    public void setCineId(int cineId) {
        this.cineId = cineId;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getButacasPorFila() {
        return butacasPorFila;
    }

    public void setButacasPorFila(int butacasPorFila) {
        this.butacasPorFila = butacasPorFila;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "salaId=" + salaId +
                ", cineId=" + cineId +
                ", nombreSala='" + nombreSala + '\'' +
                ", capacidad=" + capacidad +
                ", filas=" + filas +
                ", butacasPorFila=" + butacasPorFila +
                '}';
    }
}
