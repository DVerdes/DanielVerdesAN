/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.com.aulanosa.paneljuegos;

/**
 * Clase para guardar objetos con resultados de las partidas
 * @author DVerd
 */
public class Partida {
    
    private String itemJugador;
    
    private String itemCPU;
    
    private String resultado;
    
    private String fecha;

    public Partida() {
    }

    public Partida(String itemJugador, String itemCPU, String resultado, String fecha) {
        this.itemJugador = itemJugador;
        this.itemCPU = itemCPU;
        this.resultado = resultado;
        this.fecha = fecha;
    }

    public String getItemJugador() {
        return itemJugador;
    }

    public void setItemJugador(String itemJugador) {
        this.itemJugador = itemJugador;
    }

    public String getItemCPU() {
        return itemCPU;
    }

    public void setItemCPU(String itemCPU) {
        this.itemCPU = itemCPU;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
