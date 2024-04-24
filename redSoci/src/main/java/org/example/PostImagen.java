package org.example;

import java.util.Date;
import java.util.List;

public class PostImagen extends Post{

    private String titulo;
    private String dimensiones;

    public PostImagen(Date fechaPost, List<Comentario> comentarios, String titulo, String dimensiones) {
        super(fechaPost, comentarios);
        this.titulo = titulo;
        this.dimensiones = dimensiones;
    }

    public PostImagen() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    @Override
    public String toString() {
        return "PostImagen{" +
                "titulo='" + titulo + '\'' +
                ", dimensiones='" + dimensiones + '\'' +
                '}';
    }
}
