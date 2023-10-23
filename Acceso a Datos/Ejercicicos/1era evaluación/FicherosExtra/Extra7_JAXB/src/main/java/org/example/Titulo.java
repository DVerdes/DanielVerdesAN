package org.example;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;
import java.io.Serializable;

public class Titulo implements Serializable {
    private String titulo;

    private String idioma;

    public Titulo() {
    }

    public Titulo(String titulo, String idioma) {
        this.titulo = titulo;
        this.idioma = idioma;
    }

    public String getTitulo() {
        return titulo;
    }


    @XmlValue
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getIdioma() {
        return idioma;
    }

    @XmlAttribute (name = "idioma")
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Titulo{" +
                "titulo='" + titulo + '\'' +
                ", idioma='" + idioma + '\'' +
                '}';
    }
}
