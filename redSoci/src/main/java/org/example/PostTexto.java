package org.example;

import java.util.Date;
import java.util.List;

public class PostTexto extends Post{

    private String contenido;
    private String titulo;

    public PostTexto(Date fechaPost, List<Comentario> comentarios, String contenido, String titulo) {
        super(fechaPost, comentarios);
        this.contenido = contenido;
        this.titulo = titulo;
    }

    public PostTexto() {
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "PostTexto{" +
                "contenido='" + contenido + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
