package org.example;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

public class Mascota implements Serializable {

    private String nombre;
    private String tipo;
    private int edad;
    private String genero;

    private String cp;

    private String ciudad;

    public Mascota(String nombre, String tipo, int edad, String genero) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.edad = edad;
        this.genero = genero;
    }

    public Mascota() {
    }

    public Mascota(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }


    public String getNombre() {
        return nombre;
    }

    @XmlAttribute(name = "Nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    @XmlElement
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEdad() {
        return edad;
    }

    @XmlElement
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    @XmlElement
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCp() {
        return cp;
    }

    @XmlElement
    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCiudad() {
        return ciudad;
    }

    @XmlElement
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
