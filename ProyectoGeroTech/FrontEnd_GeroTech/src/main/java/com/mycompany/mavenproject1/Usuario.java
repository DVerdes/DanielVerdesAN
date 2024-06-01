/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

/**
 *
 * @author DVerd
 */
public class Usuario {
    
    private int ID_USUARIO;
    private String FOTO_USUARIO;
    private String NOMBRE_USUARIO;
    private String APELLIDOS_USUARIO;
    private Date FECHA_NACIMIENTO;
    private int EDAD;
    private String GENERO_USUARIO;
    private String DEPENDENCIA_USUARIO;
    private Date ALTA_USUARIO;
    private Date BAJA_USUARIO;

    public Usuario(int ID_USUARIO, String FOTO_USUARIO, String NOMBRE_USUARIO, String APELLIDOS_USUARIO, Date FECHA_NACIMIENTO, String GENERO_USUARIO, String DEPENDENCIA_USUARIO, Date ALTA_USUARIO, Date BAJA_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
        this.FOTO_USUARIO = FOTO_USUARIO;
        this.NOMBRE_USUARIO = NOMBRE_USUARIO;
        this.APELLIDOS_USUARIO = APELLIDOS_USUARIO;
        this.FECHA_NACIMIENTO = FECHA_NACIMIENTO;
        this.EDAD = UserUtils.calculateAge(FECHA_NACIMIENTO);
        this.GENERO_USUARIO = GENERO_USUARIO;
        this.DEPENDENCIA_USUARIO = DEPENDENCIA_USUARIO;
        this.ALTA_USUARIO = ALTA_USUARIO;
        this.BAJA_USUARIO = BAJA_USUARIO;
    }

    public Usuario() {
    }

    public int getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(int ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }

    public String getFOTO_USUARIO() {
        return FOTO_USUARIO;
    }

    public void setFOTO_USUARIO(String FOTO_USUARIO) {
        this.FOTO_USUARIO = FOTO_USUARIO;
    }

    public String getNOMBRE_USUARIO() {
        return NOMBRE_USUARIO;
    }

    public void setNOMBRE_USUARIO(String NOMBRE_USUARIO) {
        this.NOMBRE_USUARIO = NOMBRE_USUARIO;
    }

    public String getAPELLIDOS_USUARIO() {
        return APELLIDOS_USUARIO;
    }

    public void setAPELLIDOS_USUARIO(String APELLIDOS_USUARIO) {
        this.APELLIDOS_USUARIO = APELLIDOS_USUARIO;
    }

    public Date getFECHA_NACIMIENTO() {
        return FECHA_NACIMIENTO;
    }

    public void setFECHA_NACIMIENTO(Date FECHA_NACIMIENTO) {
        this.FECHA_NACIMIENTO = FECHA_NACIMIENTO;
        this.EDAD = UserUtils.calculateAge(FECHA_NACIMIENTO);

    }

    public int getEDAD() {
        return EDAD;
    }

    public void setEDAD(int EDAD) {
        this.EDAD = EDAD;
    }

    public String getGENERO_USUARIO() {
        return GENERO_USUARIO;
    }

    public void setGENERO_USUARIO(String GENERO_USUARIO) {
        this.GENERO_USUARIO = GENERO_USUARIO;
    }

    public String getDEPENDENCIA_USUARIO() {
        return DEPENDENCIA_USUARIO;
    }

    public void setDEPENDENCIA_USUARIO(String DEPENDENCIA_USUARIO) {
        this.DEPENDENCIA_USUARIO = DEPENDENCIA_USUARIO;
    }

    public Date getALTA_USUARIO() {
        return ALTA_USUARIO;
    }

    public void setALTA_USUARIO(Date ALTA_USUARIO) {
        this.ALTA_USUARIO = ALTA_USUARIO;
    }

    public Date getBAJA_USUARIO() {
        return BAJA_USUARIO;
    }

    public void setBAJA_USUARIO(Date BAJA_USUARIO) {
        this.BAJA_USUARIO = BAJA_USUARIO;
    }

    @Override
    public String toString() {
        return "Usuario{" + "ID_USUARIO=" + ID_USUARIO + ", FOTO_USUARIO=" + FOTO_USUARIO + ", NOMBRE_USUARIO=" + NOMBRE_USUARIO + ", APELLIDOS_USUARIO=" + APELLIDOS_USUARIO + ", FECHA_NACIMIENTO=" + FECHA_NACIMIENTO + ", EDAD=" + EDAD + ", GENERO_USUARIO=" + GENERO_USUARIO + ", DEPENDENCIA_USUARIO=" + DEPENDENCIA_USUARIO + ", ALTA_USUARIO=" + ALTA_USUARIO + ", BAJA_USUARIO=" + BAJA_USUARIO + '}';
    }
    
    
    
    
    
    
    
}
