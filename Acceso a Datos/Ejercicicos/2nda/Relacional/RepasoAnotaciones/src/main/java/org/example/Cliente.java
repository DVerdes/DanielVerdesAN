package org.example;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Clientes")
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


    @Id
    @Column(name = "ClienteID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    @Column(name = "Nombre")

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "Apellido")

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Column(name = "Direccion")

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "Ciudad")

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Column(name = "Pais")

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Column(name = "Email")

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "Telefono")

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ClienteID")
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
