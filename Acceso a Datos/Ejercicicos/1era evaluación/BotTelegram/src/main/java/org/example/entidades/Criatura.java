package org.example.entidades;

import java.io.Serializable;

public class Criatura implements Serializable {
    private String nombre;
    private String dc;
    private String pg;

    public Criatura(String nombre, String dc, String pg) {
        this.nombre = nombre;
        this.dc = dc;
        this.pg = pg;
    }

    public Criatura() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public String getPg() {
        return pg;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }
}
