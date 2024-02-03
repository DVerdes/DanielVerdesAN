package com.example.demo.model;

public class Cine {

    private int cineId;
    private String nombreCine;
    private String direccion;

    public Cine() {
    }

    public Cine(String nombreCine, String direccion) {
        this.nombreCine = nombreCine;
        this.direccion = direccion;
    }

    public Cine(int cineId, String nombreCine, String direccion) {
        this.cineId = cineId;
        this.nombreCine = nombreCine;
        this.direccion = direccion;
    }

    public int getCineId() {
        return cineId;
    }

    public void setCineId(int cineId) {
        this.cineId = cineId;
    }

    public String getNombreCine() {
        return nombreCine;
    }

    public void setNombreCine(String nombreCine) {
        this.nombreCine = nombreCine;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "CineDTO{" +
                "cineId=" + cineId +
                ", nombreCine='" + nombreCine + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
