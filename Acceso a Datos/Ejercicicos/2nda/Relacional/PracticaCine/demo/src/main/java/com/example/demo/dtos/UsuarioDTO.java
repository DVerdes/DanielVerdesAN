package com.example.demo.dtos;

import java.io.Serial;
import java.io.Serializable;

public class UsuarioDTO implements Serializable {

    private int id;
    private String nombreUsuario;

    private String email;

    private String claveAcceso;

    private String rol;

    public UsuarioDTO(String nombreUsuario, String email, String claveAcceso) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.claveAcceso = claveAcceso;
    }

    public UsuarioDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", email='" + email + '\'' +
                ", claveAcceso='" + claveAcceso + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
