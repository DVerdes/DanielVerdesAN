package org.example;

import java.io.Serializable;
import java.lang.String;
import java.util.Set;

public class Cliente implements Serializable {

    private int clienteId;
    private String nombre;
    private String apellido;
    private String direccion;
    private String ciudad;
    private String pais;

    private String email;
    private String telefono;

    private Set <Pedido> pedidos;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String direccion, String ciudad, String pais, String email, String telefono, Set<Pedido> pedidos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.email = email;
        this.telefono = telefono;
        this.pedidos = pedidos;
    }

    public Cliente(int clienteId, String nombre, String apellido, String direccion, String ciudad, String pais, String email, String telefono, Set<Pedido> pedidos) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.email = email;
        this.telefono = telefono;
        this.pedidos = pedidos;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "clienteId=" + clienteId +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +

                '}';
    }
}
