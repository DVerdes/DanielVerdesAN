package com.example.ReviewsProyecto.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.Set;



@Entity
@Table(name = "Items")
public class Item implements Serializable {

    private int idItem;
    private String tipo;
    private String nombre;
    private String genero;
    private String autor;
    private int duracion;
    private String rutaPortada;
    private int estreno;
    private String sinopsis;
    private Set<Review> reviewSet;

    public Item() {
    }

    public Item(int idItem, String tipo, String nombre, String genero, String autor, int duracion, String rutaPortada, int estreno, String sinopsis, Set<Review> reviewSet) {
        this.idItem = idItem;
        this.tipo = tipo;
        this.nombre = nombre;
        this.genero = genero;
        this.autor = autor;
        this.duracion = duracion;
        this.rutaPortada = rutaPortada;
        this.estreno = estreno;
        this.sinopsis = sinopsis;
        this.reviewSet = reviewSet;
    }


    @Id
    @Column(name = "ItemID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdItem() {
        return idItem;
    }


    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    @Column(name = "Tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Column(name = "Nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "Genero")
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Column(name = "Autor")
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Column(name = "Duracion")
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Column(name = "RutaPortada")
    public String getRutaPortada() {
        return rutaPortada;
    }

    public void setRutaPortada(String rutaPortada) {
        this.rutaPortada = rutaPortada;
    }

    @Column(name = "Estreno")
    public int getEstreno() {
        return estreno;
    }

    public void setEstreno(int estreno) {
        this.estreno = estreno;
    }

    @Column(name = "Sinopsis")
    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @OneToMany(mappedBy = "item")
    @Fetch(FetchMode.JOIN)
    public Set<Review> getReviewSet() {
        return reviewSet;
    }

    public void setReviewSet(Set<Review> reviewSet) {
        this.reviewSet = reviewSet;
    }

    @Override
    public String toString() {
        return "Item{" +
                "idItem=" + idItem +
                ", tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", autor='" + autor + '\'' +
                ", duracion=" + duracion +
                ", rutaPortada='" + rutaPortada + '\'' +
                ", estreno=" + estreno +
                ", sinopsis='" + sinopsis + '\'' +
                '}';
    }
}
