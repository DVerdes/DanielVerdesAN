package org.example;

import java.io.Serializable;

public class Ciudad implements Serializable {

    private String nombre;
    private String pais;
    private String region;
    private int elevacion;

    public Ciudad() {
    }

    public Ciudad(String nombre, String pais, String region, int elevacion) {
        this.nombre = nombre;
        this.pais = pais;
        this.region = region;
        this.elevacion = elevacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getElevacion() {
        return elevacion;
    }

    public void setElevacion(int elevacion) {
        this.elevacion = elevacion;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", region='" + region + '\'' +
                ", elevacion=" + elevacion +
                '}';
    }
}
