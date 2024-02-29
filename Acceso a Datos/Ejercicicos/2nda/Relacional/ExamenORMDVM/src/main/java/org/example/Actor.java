package org.example;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Clase Actor con anotaciones Hibernate
 */
@Entity
@Table (name = "Actores")
public class Actor implements Serializable {
    private int id;
    private int idPelicula;
    private String nombre;
    private String apellidos;
    private Pelicula pelicula;

    public Actor() {
    }

    public Actor(int idPelicula, String nombre, String apellidos) {
        this.idPelicula = idPelicula;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "IdPelicula")
    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    @Column(name = "Nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "Apellidos")
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @ManyToOne
    @JoinColumn(name = "IdPelicula", insertable = false, updatable = false)
    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", idPelicula=" + idPelicula +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}
