/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author DVerd
 */
public class Contacto {
    private int ID_CONTACTO;
    private String NOMBRE_CONTACTO;
    private String APELL_CONTACTO;
    private String TELF_CONTACTO;
    private String EMAIL_CONTACTO;

    public Contacto(int ID_CONTACTO, String NOMBRE_CONTACTO, String APELL_CONTACTO, String TELF_CONTACTO, String EMAIL_CONTACTO) {
        this.ID_CONTACTO = ID_CONTACTO;
        this.NOMBRE_CONTACTO = NOMBRE_CONTACTO;
        this.APELL_CONTACTO = APELL_CONTACTO;
        this.TELF_CONTACTO = TELF_CONTACTO;
        this.EMAIL_CONTACTO = EMAIL_CONTACTO;
    }

    public Contacto() {
    }

    public Contacto(String NOMBRE_CONTACTO, String APELL_CONTACTO, String TELF_CONTACTO, String EMAIL_CONTACTO) {
        this.NOMBRE_CONTACTO = NOMBRE_CONTACTO;
        this.APELL_CONTACTO = APELL_CONTACTO;
        this.TELF_CONTACTO = TELF_CONTACTO;
        this.EMAIL_CONTACTO = EMAIL_CONTACTO;
    }
    
    

    public int getID_CONTACTO() {
        return ID_CONTACTO;
    }

    public void setID_CONTACTO(int ID_CONTACTO) {
        this.ID_CONTACTO = ID_CONTACTO;
    }

    public String getNOMBRE_CONTACTO() {
        return NOMBRE_CONTACTO;
    }

    public void setNOMBRE_CONTACTO(String NOMBRE_CONTACTO) {
        this.NOMBRE_CONTACTO = NOMBRE_CONTACTO;
    }

    public String getAPELL_CONTACTO() {
        return APELL_CONTACTO;
    }

    public void setAPELL_CONTACTO(String APELL_CONTACTO) {
        this.APELL_CONTACTO = APELL_CONTACTO;
    }

    public String getTELF_CONTACTO() {
        return TELF_CONTACTO;
    }

    public void setTELF_CONTACTO(String TELF_CONTACTO) {
        this.TELF_CONTACTO = TELF_CONTACTO;
    }

    public String getEMAIL_CONTACTO() {
        return EMAIL_CONTACTO;
    }

    public void setEMAIL_CONTACTO(String EMAIL_CONTACTO) {
        this.EMAIL_CONTACTO = EMAIL_CONTACTO;
    }

    @Override
    public String toString() {
        return "Contacto{" + "ID_CONTACTO=" + ID_CONTACTO + ", NOMBRE_CONTACTO=" + NOMBRE_CONTACTO + ", APELL_CONTACTO=" + APELL_CONTACTO + ", TELF_CONTACTO=" + TELF_CONTACTO + ", EMAIL_CONTACTO=" + EMAIL_CONTACTO + '}';
    }
    
    
}
