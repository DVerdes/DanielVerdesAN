package org.example;

import java.util.Date;
import java.util.List;

public class PostVideo extends Post{
    private String titulo;
    private String calidad;
    private int duracion;

    public PostVideo(Date fechaPost, List<Comentario> comentarios, String titulo, String calidad, int duracion) {
        super(fechaPost, comentarios);
        this.titulo = titulo;
        this.calidad = calidad;
        this.duracion = duracion;
    }

    public PostVideo() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "PostVideo{" +
                "titulo='" + titulo + '\'' +
                ", calidad='" + calidad + '\'' +
                ", duracion=" + duracion +
                '}';
    }
}
