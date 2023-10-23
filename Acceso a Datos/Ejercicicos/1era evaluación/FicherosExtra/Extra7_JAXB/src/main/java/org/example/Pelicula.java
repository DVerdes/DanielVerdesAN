package org.example;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.Serializable;
import java.util.ArrayList;

public class Pelicula implements Serializable {

    private Titulo titulo;

    private String categoria;

    private String idioma;

    private String director;

    private String estreno;


    private ArrayList<String> actores;

    private Localizacion datosLocalizacion;

    public Pelicula() {
    }

    public Pelicula(Titulo titulo, String categoria, String idioma, String director, String estreno, ArrayList<String> actores, Localizacion datosLocalizacion) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.idioma = idioma;
        this.director = director;
        this.estreno = estreno;
        this.actores = actores;
        this.datosLocalizacion = datosLocalizacion;
    }

    public Titulo getTitulo() {
        return titulo;
    }
    @XmlElement
    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    @XmlAttribute (name = "categoria")
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIdioma() {
        return idioma;
    }

    @XmlAttribute (name = "idioma")
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getDirector() {
        return director;
    }

    @XmlElement
    public void setDirector(String director) {
        this.director = director;
    }

    public String getEstreno() {
        return estreno;
    }


    @XmlElement
    public void setEstreno(String estreno) {
        this.estreno = estreno;
    }

    public ArrayList<String> getActores() {
        return actores;
    }

    @XmlElementWrapper(name = "reparto")
    @XmlElement(name = "actor")
    public void setActores(ArrayList<String> actores) {
        this.actores = actores;
    }

    public Localizacion getDatosLocalizacion() {
        return datosLocalizacion;
    }

    @XmlElement (name = "datosLocalizacion")
    public void setDatosLocalizacion(Localizacion datosLocalizacion) {
        this.datosLocalizacion = datosLocalizacion;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", categoria='" + categoria + '\'' +
                ", idioma='" + idioma + '\'' +
                ", director='" + director + '\'' +
                ", estreno='" + estreno + '\'' +
                ", actores=" + actores +
                ", datosLocalizacion=" + datosLocalizacion +
                '}';
    }
}
