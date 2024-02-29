package org.example;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Clase Pelicula con anotaciones Hibernate
 */
@Entity
@Table (name = "Peliculas")
public class Pelicula implements Serializable {

    private int id;
    private String titulo;
    private int estreno;
    private String genero;
    private Set<Actor> actores;

    public Pelicula() {
    }

    public Pelicula(String titulo, int estreno, String genero) {
        this.titulo = titulo;
        this.estreno = estreno;
        this.genero = genero;
    }

    public Pelicula(int id, String titulo, int estreno, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.estreno = estreno;
        this.genero = genero;
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

    @Column(name = "Titulo")
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Column(name = "Estreno")
    public int getEstreno() {
        return estreno;
    }

    public void setEstreno(int estreno) {
        this.estreno = estreno;
    }

    @Column(name = "Genero")
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @OneToMany(mappedBy = "pelicula")
    public Set<Actor> getActores() {
        return actores;
    }

    public void setActores(Set<Actor> actores) {
        this.actores = actores;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", estreno=" + estreno +
                ", genero='" + genero + '\'' +
                '}';
    }
}
