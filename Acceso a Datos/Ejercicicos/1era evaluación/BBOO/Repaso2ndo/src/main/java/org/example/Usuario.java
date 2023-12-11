package org.example;

import java.io.Serializable;

public class Usuario implements Serializable {

    private int codigo;

    private String nombre;

    private int edad;

    private String email;

    private boolean activo;

    public Usuario() {
    }

    public Usuario(int codigo, String nombre, int edad, String email, boolean activo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.activo = activo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", email='" + email + '\'' +
                ", activo=" + activo +
                '}';
    }
}
