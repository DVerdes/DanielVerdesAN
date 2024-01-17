package org.example.dto;

import java.io.Serializable;

public class DepartamentoDTO implements Serializable {

    private int id;
    private String nombre;
    private String ubicacion;
    private String email;
    private String telefono;
    private int numeroEmpleados;

    public DepartamentoDTO(int id, String nombre, String ubicacion, String email, String telefono, int numeroEmpleados) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.email = email;
        this.telefono = telefono;
        this.numeroEmpleados = numeroEmpleados;
    }

    public DepartamentoDTO(String nombre, String ubicacion, String email, String telefono, int numeroEmpleados) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.email = email;
        this.telefono = telefono;
        this.numeroEmpleados = numeroEmpleados;
    }

    public DepartamentoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(int numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }

    @Override
    public String toString() {
        return "DepartamentoDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", numeroEmpleados=" + numeroEmpleados +
                '}';
    }
}
