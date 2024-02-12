/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicafinal;

/**
 *
 * @author DVerd
 */
public class Jugador {
    
    private String nombre;
    private String apellido;
    private String equipo;
    private String posicion;
    private int edad;
    private String imgURL;

    public Jugador() {
    }

    public Jugador(String nombre, String apellido, String equipo, String posicion, int edad, String imgURL) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.equipo = equipo;
        this.posicion = posicion;
        this.edad = edad;
        this.imgURL = imgURL;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", apellido=" + apellido + ", equipo=" + equipo + ", posicion=" + posicion + ", edad=" + edad + ", imgURL=" + imgURL + '}';
    }

   
    
    
    
    
}
