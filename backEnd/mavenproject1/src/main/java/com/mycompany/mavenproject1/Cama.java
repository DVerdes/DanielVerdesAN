/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author DVerd
 */
public class Cama {
    
    private int ID_CAMA;
    private int ID_HABITACION;
    private String NOMBRE_CAMA;

    public Cama() {
    }

    public Cama(int ID_CAMA, int ID_HABITACION, String NOMBRE_CAMA) {
        this.ID_CAMA = ID_CAMA;
        this.ID_HABITACION = ID_HABITACION;
        this.NOMBRE_CAMA = NOMBRE_CAMA;
    }

    public int getID_CAMA() {
        return ID_CAMA;
    }

    public void setID_CAMA(int ID_CAMA) {
        this.ID_CAMA = ID_CAMA;
    }

    public int getID_HABITACION() {
        return ID_HABITACION;
    }

    public void setID_HABITACION(int ID_HABITACION) {
        this.ID_HABITACION = ID_HABITACION;
    }

    public String getNOMBRE_CAMA() {
        return NOMBRE_CAMA;
    }

    public void setNOMBRE_CAMA(String NOMBRE_CAMA) {
        this.NOMBRE_CAMA = NOMBRE_CAMA;
    }

    @Override
    public String toString() {
        return NOMBRE_CAMA;
    }
    
    
    
}
