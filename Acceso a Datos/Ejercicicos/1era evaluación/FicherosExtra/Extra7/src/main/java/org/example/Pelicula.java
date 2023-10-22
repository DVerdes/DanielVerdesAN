package org.example;

import java.util.ArrayList;

public class Pelicula {
    private String titulo;
    private String categoria;

    private String idioma;

    private String director;

    private String estreno;

    private ArrayList<String> actores;

    public Pelicula() {
    }

    public Pelicula(String titulo, String categoria, String idioma, String director, String estreno, ArrayList<String> actores) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.idioma = idioma;
        this.director = director;
        this.estreno = estreno;
        this.actores = actores;
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

    public ArrayList<String> getActores() {
        return actores;
    }

    public void setActores(ArrayList<String> actores) {
        this.actores = actores;
    }
}
