package org.example.dto;

import java.io.Serializable;
import java.util.Date;

public class EmpleadoDTO implements Serializable {

    private int id;
    private String nombre;
    private String apellido;
    private double salario;
    private java.sql.Date fechaContratacion;
    private String direccion;
    private String telefono;
    private String email;
    private int idDepartamento;
    private String nombreDepartamento;

    public EmpleadoDTO() {
    }

    public EmpleadoDTO( String nombre, String apellido, double salario, java.sql.Date fechaContratacion, String direccion, String telefono, String email, int idDepartamento, String nombreDepartamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
    }

    public EmpleadoDTO( int id, String nombre, String apellido, double salario, java.sql.Date fechaContratacion, String direccion, String telefono, String email, int idDepartamento, String nombreDepartamento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public java.sql.Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(java.sql.Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    @Override
    public String toString() {
        return "EmpleadoDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", salario=" + salario +
                ", fechaContratacion=" + fechaContratacion +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", idDepartamento=" + idDepartamento +
                ", nombreDepartamento='" + nombreDepartamento + '\'' +
                '}';
    }
}
