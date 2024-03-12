package com.example.ReviewsProyecto.model;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * Clase Review con anotaciones Hibernate
 */
@Entity
@Table(name = "Reviews")
public class Review implements Serializable {
    private int reviewID;
    private int idItem;
    private String usuario;
    private int puntuacion;
    private String contenido;
    private Item item;

    public Review() {
    }

    public Review(int reviewID, int idItem, String usuario, int puntuacion, String contenido, Item item) {
        this.reviewID = reviewID;
        this.idItem = idItem;
        this.usuario = usuario;
        this.puntuacion = puntuacion;
        this.contenido = contenido;
        this.item = item;
    }

    @Id
    @Column(name = "ReviewID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    @Column(name = "ItemID")
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    @Column(name = "Usuario")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Column(name = "Puntuacion")
    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Column(name = "Contenido")
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @ManyToOne
    @JoinColumn(name = "ItemID", insertable = false, updatable = false)
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewID=" + reviewID +
                ", idItem=" + idItem +
                ", usuario='" + usuario + '\'' +
                ", puntuacion=" + puntuacion +
                ", contenido='" + contenido + '\'' +
                '}';
    }
}
