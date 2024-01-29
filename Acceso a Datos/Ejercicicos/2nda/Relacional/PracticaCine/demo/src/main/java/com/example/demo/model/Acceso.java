package com.example.demo.model;

import java.io.Serializable;

public class Acceso implements Serializable {

    private String nombreUsuario;

    private String claveAcceso;

    public Acceso(String nombreUsuario, String claveAcceso) {
        this.nombreUsuario = nombreUsuario;
        this.claveAcceso = claveAcceso;
    }

    public Acceso() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    @Override
    public String toString() {
        return "AccesoDTO{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", claveAcceso='" + claveAcceso + '\'' +
                '}';
    }
}
