/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.sql.Date;

/**
 *
 * @author DVerd
 */
public class Vacuna {
    
    private int ID_VACUNA;
    private String NOMBRE_VACUNA;
    private Date FECHA_VACUNACION;

    public Vacuna() {
    }

    public Vacuna(int ID_VACUNA, String NOMBRE_VACUNA, Date FECHA_VACUNACION) {
        this.ID_VACUNA = ID_VACUNA;
        this.NOMBRE_VACUNA = NOMBRE_VACUNA;
        this.FECHA_VACUNACION = FECHA_VACUNACION;
    }

    public int getID_VACUNA() {
        return ID_VACUNA;
    }

    public void setID_VACUNA(int ID_VACUNA) {
        this.ID_VACUNA = ID_VACUNA;
    }

    public String getNOMBRE_VACUNA() {
        return NOMBRE_VACUNA;
    }

    public void setNOMBRE_VACUNA(String NOMBRE_VACUNA) {
        this.NOMBRE_VACUNA = NOMBRE_VACUNA;
    }

    public Date getFECHA_VACUNACION() {
        return FECHA_VACUNACION;
    }

    public void setFECHA_VACUNACION(Date FECHA_VACUNACION) {
        this.FECHA_VACUNACION = FECHA_VACUNACION;
    }

    @Override
    public String toString() {
        return "Vacuna{" + "ID_VACUNA=" + ID_VACUNA + ", NOMBRE_VACUNA=" + NOMBRE_VACUNA + ", FECHA_VACUNACION=" + FECHA_VACUNACION + '}';
    }
    
    
    
}
