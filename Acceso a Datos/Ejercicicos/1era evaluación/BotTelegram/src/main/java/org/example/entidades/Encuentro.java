package org.example.entidades;

import java.util.ArrayList;

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
