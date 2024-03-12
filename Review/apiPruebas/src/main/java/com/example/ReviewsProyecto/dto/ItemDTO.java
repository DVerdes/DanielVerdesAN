package com.example.ReviewsProyecto.dto;


import com.example.ReviewsProyecto.model.Review;

import java.util.List;
import java.util.Set;

/**
 * Item DTO
 */
public class ItemDTO {
    private int idItem;
    private String tipo;
    private String nombre;
    private String genero;
    private String autor;
    private int duracion;
    private String rutaPortada;
    private int estreno;
    private String sinopsis;
    private Double puntuacionMedia;

    public ItemDTO() {
    }

    public ItemDTO(int idItem, String tipo, String nombre, String genero, String autor, int duracion, String rutaPortada, int estreno, String sinopsis,  Double puntuacionMedia) {

        this.idItem = idItem;
        this.tipo = tipo;
        this.nombre = nombre;
        this.genero = genero;
        this.autor = autor;
        this.duracion = duracion;
        this.rutaPortada = rutaPortada;
        this.estreno = estreno;
        this.sinopsis = sinopsis;
        this.puntuacionMedia = puntuacionMedia;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getRutaPortada() {
        return rutaPortada;
    }

    public void setRutaPortada(String rutaPortada) {
        this.rutaPortada = rutaPortada;
    }

    public int getEstreno() {
        return estreno;
    }

    public void setEstreno(int estreno) {
        this.estreno = estreno;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }



    public Double getPuntuacionMedia() {
        return puntuacionMedia;
    }

    public void setPuntuacionMedia(Double puntuacionMedia) {
        this.puntuacionMedia = puntuacionMedia;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "idItem=" + idItem +
                ", tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", autor='" + autor + '\'' +
                ", duracion=" + duracion +
                ", rutaPortada='" + rutaPortada + '\'' +
                ", estreno=" + estreno +
                ", sinopsis='" + sinopsis + '\'' +
                ", puntuacionMedia=" + puntuacionMedia +
                '}';
    }
}
