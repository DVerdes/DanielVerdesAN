/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author DVerd
 */
public class Farmaco {
    
    private String NOMBRE_FARMACO;

    public Farmaco(String NOMBRE_FARMACO) {
        this.NOMBRE_FARMACO = NOMBRE_FARMACO;
    }

    public Farmaco() {
    }

    public String getNOMBRE_FARMACO() {
        return NOMBRE_FARMACO;
    }

    public void setNOMBRE_FARMACO(String NOMBRE_FARMACO) {
        this.NOMBRE_FARMACO = NOMBRE_FARMACO;
    }

    @Override
    public String toString() {
        return "Farmaco{" + "NOMBRE_FARMACO=" + NOMBRE_FARMACO + '}';
    }
    
    
}
