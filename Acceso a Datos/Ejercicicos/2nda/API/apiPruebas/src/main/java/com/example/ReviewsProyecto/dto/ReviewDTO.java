package com.example.ReviewsProyecto.dto;


public class ReviewDTO {

    private int reviewID;
    private int idItem;
    private String usuario;
    private int puntuacion;
    private String contenido;

    public ReviewDTO() {
    }

    public ReviewDTO(int reviewID, int idItem, String usuario, int puntuacion, String contenido) {
        this.reviewID = reviewID;
        this.idItem = idItem;
        this.usuario = usuario;
        this.puntuacion = puntuacion;
        this.contenido = contenido;
    }

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "reviewID=" + reviewID +
                ", idItem=" + idItem +
                ", usuario='" + usuario + '\'' +
                ", puntuacion=" + puntuacion +
                ", contenido='" + contenido + '\'' +
                '}';
    }
}
