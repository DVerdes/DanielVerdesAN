/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author DVerd
 */
public class Habitacion {
    
    private int ID_HABITACION;
    private int ID_CENTRO;
    private String NOM_HABITACION;

    public Habitacion() {
    }

    public Habitacion(int ID_HABITACION, int ID_CENTRO, String NOM_HABITACION) {
        this.ID_HABITACION = ID_HABITACION;
        this.ID_CENTRO = ID_CENTRO;
        this.NOM_HABITACION = NOM_HABITACION;
    }

    public int getID_HABITACION() {
        return ID_HABITACION;
    }

    public void setID_HABITACION(int ID_HABITACION) {
        this.ID_HABITACION = ID_HABITACION;
    }

    public int getID_CENTRO() {
        return ID_CENTRO;
    }

    public void setID_CENTRO(int ID_CENTRO) {
        this.ID_CENTRO = ID_CENTRO;
    }

    public String getNOM_HABITACION() {
        return NOM_HABITACION;
    }

    public void setNOM_HABITACION(String NOM_HABITACION) {
        this.NOM_HABITACION = NOM_HABITACION;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "ID_HABITACION=" + ID_HABITACION + ", ID_CENTRO=" + ID_CENTRO + ", NOM_HABITACION=" + NOM_HABITACION + '}';
    }
    
    
    
}
