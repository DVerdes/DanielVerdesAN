package org.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

@XmlRootElement(name = "cine")
public class Peliculas implements Serializable {

    private ArrayList <Pelicula> peliculas;

    public Peliculas() {
    }

    public Peliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public ArrayList<Pelicula> getListaPeliculas() {
        return peliculas;
    }

    @XmlElement (name = "pelicula")
    public void setListaPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
}
