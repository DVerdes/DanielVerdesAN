/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author DVerd
 */
public class Pauta {
    
    private String nombreFarmaco;
    private String viaAdministracion;
    private String dosis;
    private String posologia;

    public Pauta() {
    }

    public Pauta(String nombreFarmaco, String viaAdministracion, String dosis, String posologia) {
        this.nombreFarmaco = nombreFarmaco;
        this.viaAdministracion = viaAdministracion;
        this.dosis = dosis;
        this.posologia = posologia;
    }

    public String getNombreFarmaco() {
        return nombreFarmaco;
    }

    public void setNombreFarmaco(String nombreFarmaco) {
        this.nombreFarmaco = nombreFarmaco;
    }

    public String getViaAdministracion() {
        return viaAdministracion;
    }

    public void setViaAdministracion(String viaAdministracion) {
        this.viaAdministracion = viaAdministracion;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    @Override
    public String toString() {
        return nombreFarmaco+" "+ dosis;
    }
    
    
    
}
