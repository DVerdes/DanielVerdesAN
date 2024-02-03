package com.example.demo.model;

import java.sql.Date;

public class Pelicula {

    private int peliculaID;

    private int salaID;

    private String titulo;

    private Date fechaInicio;

    private Date fechaFin;

    private String genero;

    private int clasificacionEdad;

    public Pelicula() {
    }

    public Pelicula(int peliculaID, int salaID, String titulo, Date fechaInicio, Date fechaFin, String genero, int clasificacionEdad) {
        this.peliculaID = peliculaID;
        this.salaID = salaID;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.genero = genero;
        this.clasificacionEdad = clasificacionEdad;
    }

    public Pelicula(int salaID, String titulo, Date fechaInicio, Date fechaFin, String genero, int clasificacionEdad) {
        this.salaID = salaID;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.genero = genero;
        this.clasificacionEdad = clasificacionEdad;
    }

    public int getPeliculaID() {
        return peliculaID;
    }

    public void setPeliculaID(int peliculaID) {
        this.peliculaID = peliculaID;
    }

    public int getSalaID() {
        return salaID;
    }

    public void setSalaID(int salaID) {
        this.salaID = salaID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getClasificacionEdad() {
        return clasificacionEdad;
    }

    public void setClasificacionEdad(int clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "peliculaID=" + peliculaID +
                ", salaID=" + salaID +
                ", titulo='" + titulo + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", genero='" + genero + '\'' +
                ", clasificacionEdad=" + clasificacionEdad +
                '}';
    }
}
