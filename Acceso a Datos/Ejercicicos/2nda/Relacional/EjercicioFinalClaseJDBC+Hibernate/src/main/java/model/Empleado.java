package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Empleado {

    private int id ;
    private String nombre;
    private String apellido;
    private String pinAcceso;
    private BigDecimal salario;
    private java.sql.Date fechaContratacion;
    private String direccion;
    private String telefono;
    private String email;
    private int idDepartamento;
    private String nombreDepartamento;

    public Empleado() {
    }


    public Empleado(int id, String nombre, String apellido, String pinAcceso, BigDecimal salario, Date fechaContratacion, String direccion, String telefono, String email, int idDepartamento, String nombreDepartamento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pinAcceso = pinAcceso;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
    }

    public Empleado(String nombre, String apellido, String pinAcceso, BigDecimal salario, Date fechaContratacion, String direccion, String telefono, String email, int idDepartamento, String nombreDepartamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pinAcceso = pinAcceso;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
    }

    public Empleado(int id, String nombre, String apellido, String pinAcceso, BigDecimal salario, Date fechaContratacion, String direccion, String telefono, String email, int idDepartamento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pinAcceso = pinAcceso;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.idDepartamento = idDepartamento;
    }

    public Empleado(int id, String nombre, String apellido, BigDecimal salario, Date fechaContratacion, String direccion, String telefono, String email, int idDepartamento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.idDepartamento = idDepartamento;

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

    public String getPinAcceso() {
        return pinAcceso;
    }

    public void setPinAcceso(String pinAcceso) {
        this.pinAcceso = pinAcceso;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
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
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", pinAcceso='" + pinAcceso + '\'' +
                ", salario=" + salario +
                ", fechaContratacion=" + fechaContratacion +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", idDepartamento=" + idDepartamento +
                ", nombreDepartamento='" + nombreDepartamento + '\'' +
                "}";
    }
}
