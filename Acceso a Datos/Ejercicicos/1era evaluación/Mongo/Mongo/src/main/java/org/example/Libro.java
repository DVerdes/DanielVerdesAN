package org.example;

public class Libro {

    private String titulo;

    private String autor;

    private int edicion;

    public Libro() {
    }

    public Libro(String titulo, String autor, int edicion) {
        this.titulo = titulo;
        this.autor = autor;
        this.edicion = edicion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", edicion=" + edicion +
                '}';
    }
}
