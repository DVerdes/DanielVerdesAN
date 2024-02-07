/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicafinal;

/**
 *
 * @author FP
 */
public class Contacto {
    
    private String nombre;
     private String apellidos;
    private int edad ;
    private String url;

    public Contacto(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Contacto() {
    }

    public Contacto(String nombre, String apellidos, int edad, String url) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", url=" + url + '}';
    }

    
    
    
    
   
    
}
