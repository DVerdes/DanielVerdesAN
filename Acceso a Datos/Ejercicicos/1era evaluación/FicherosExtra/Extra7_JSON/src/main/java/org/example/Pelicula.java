package org.example;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class Pelicula {

    @Expose
    private String titulo;
    @Expose
    private String categoria;
    @Expose
    private String idioma;
    @Expose
    private String director;
    @Expose
    private String estreno;
    @Expose
    private String reparto;

    public Pelicula() {
    }

    public Pelicula(String titulo, String categoria, String idioma, String director, String estreno, String reparto) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.idioma = idioma;
        this.director = director;
        this.estreno = estreno;
        this.reparto = reparto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getEstreno() {
        return estreno;
    }

    public void setEstreno(String estreno) {
        this.estreno = estreno;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }
}
