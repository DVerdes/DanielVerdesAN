package org.example;

import java.io.Serializable;

public class Ciudad implements Serializable {

    private int elevacion;
    private String nombre;
    private String pais;
    private String region;

    public Ciudad(int elevacion, String nombre, String pais, String region) {
        this.nombre = nombre;
        this.pais = pais;
        this.region = region;
        this.elevacion = elevacion;
    }

    public Ciudad() {
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

    public String toString(){
        String cadena = this.nombre+"-"+this.pais+"-"+this.region+"-"+this.elevacion;
        return cadena;
    }
}
