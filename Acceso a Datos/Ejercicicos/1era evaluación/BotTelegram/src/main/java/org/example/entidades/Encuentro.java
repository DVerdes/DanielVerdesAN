package org.example.entidades;

import java.util.ArrayList;

/**
 * Clase Encuentro para crear objetos Encuentro que están formados por una lista de objetos Criatura
 */
public class Encuentro {

    private ArrayList<Criatura> criaturas;

    public Encuentro(ArrayList<Criatura> criaturas) {
        this.criaturas = criaturas;
    }

    public Encuentro() {
    }

    public ArrayList<Criatura> getCriaturas() {
        return criaturas;
    }

    public void setCriaturas(ArrayList<Criatura> criaturas) {
        this.criaturas = criaturas;
    }
}
