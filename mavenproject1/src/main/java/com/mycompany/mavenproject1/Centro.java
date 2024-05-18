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
public class Centro {
    
    private int ID_CENTRO;
    private String ID_GESTOR;
    private String DIR_CENTRO;
    private String NOMBRE_CENTRO;
    private Date CNT_CREATION_DATE;
    private Date CNT_DOWN_DATE;

    public Centro(int ID_CENTRO, String ID_GESTOR, String DIR_CENTRO, String NOMBRE_CENTRO, Date CNT_CREATION_DATE, Date CNT_DOWN_DATE) {
        this.ID_CENTRO = ID_CENTRO;
        this.ID_GESTOR = ID_GESTOR;
        this.DIR_CENTRO = DIR_CENTRO;
        this.NOMBRE_CENTRO = NOMBRE_CENTRO;
        this.CNT_CREATION_DATE = CNT_CREATION_DATE;
        this.CNT_DOWN_DATE = CNT_DOWN_DATE;
    }

    public Centro() {
    }

    public int getID_CENTRO() {
        return ID_CENTRO;
    }

    public void setID_CENTRO(int ID_CENTRO) {
        this.ID_CENTRO = ID_CENTRO;
    }

    public String getID_GESTOR() {
        return ID_GESTOR;
    }

    public void setID_GESTOR(String ID_GESTOR) {
        this.ID_GESTOR = ID_GESTOR;
    }

    public String getDIR_CENTRO() {
        return DIR_CENTRO;
    }

    public void setDIR_CENTRO(String DIR_CENTRO) {
        this.DIR_CENTRO = DIR_CENTRO;
    }

    public String getNOMBRE_CENTRO() {
        return NOMBRE_CENTRO;
    }

    public void setNOMBRE_CENTRO(String NOMBRE_CENTRO) {
        this.NOMBRE_CENTRO = NOMBRE_CENTRO;
    }

    public Date getCNT_CREATION_DATE() {
        return CNT_CREATION_DATE;
    }

    public void setCNT_CREATION_DATE(Date CNT_CREATION_DATE) {
        this.CNT_CREATION_DATE = CNT_CREATION_DATE;
    }

    public Date getCNT_DOWN_DATE() {
        return CNT_DOWN_DATE;
    }

    public void setCNT_DOWN_DATE(Date CNT_DOWN_DATE) {
        this.CNT_DOWN_DATE = CNT_DOWN_DATE;
    }

    @Override
    public String toString() {
        return "Centro{" + "ID_CENTRO=" + ID_CENTRO + ", ID_GESTOR=" + ID_GESTOR + ", DIR_CENTRO=" + DIR_CENTRO + ", NOMBRE_CENTRO=" + NOMBRE_CENTRO + ", CNT_CREATION_DATE=" + CNT_CREATION_DATE + ", CNT_DOWN_DATE=" + CNT_DOWN_DATE + '}';
    }
    
    
    
    
    
    
}
