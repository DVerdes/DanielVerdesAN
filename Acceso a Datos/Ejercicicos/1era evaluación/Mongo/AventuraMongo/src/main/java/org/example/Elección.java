package org.example;

public class Elección {

    private int numElección;

    private String textoElección;

    private int idRuta;

    private boolean requiereCuchillo;

    private boolean requiereLampara;

    private boolean requiereLanza;

    private boolean requiereMapa;

    private int modifPg;

    public Elección() {
    }

    public Elección(int numElección, String textoElección, int idRuta, boolean requiereCuchillo, boolean requiereLampara, boolean requiereLanza, boolean requiereMapa, int modifPg) {
        this.numElección = numElección;
        this.textoElección = textoElección;
        this.idRuta = idRuta;
        this.requiereCuchillo = requiereCuchillo;
        this.requiereLampara = requiereLampara;
        this.requiereLanza = requiereLanza;
        this.requiereMapa = requiereMapa;
        this.modifPg = modifPg;
    }

    public int getNumElección() {
        return numElección;
    }

    public void setNumElección(int numElección) {
        this.numElección = numElección;
    }

    public String getTextoElección() {
        return textoElección;
    }

    public void setTextoElección(String textoElección) {
        this.textoElección = textoElección;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public boolean isRequiereCuchillo() {
        return requiereCuchillo;
    }

    public void setRequiereCuchillo(boolean requiereCuchillo) {
        this.requiereCuchillo = requiereCuchillo;
    }

    public boolean isRequiereLampara() {
        return requiereLampara;
    }

    public void setRequiereLampara(boolean requiereLampara) {
        this.requiereLampara = requiereLampara;
    }

    public boolean isRequiereLanza() {
        return requiereLanza;
    }

    public void setRequiereLanza(boolean requiereLanza) {
        this.requiereLanza = requiereLanza;
    }

    public boolean isRequiereMapa() {
        return requiereMapa;
    }

    public void setRequiereMapa(boolean requiereMapa) {
        this.requiereMapa = requiereMapa;
    }

    public int getModifPg() {
        return modifPg;
    }

    public void setModifPg(int modifPg) {
        this.modifPg = modifPg;
    }

    @Override
    public String toString() {
        return "Elección{" +
                "numElección=" + numElección +
                ", textoElección='" + textoElección + '\'' +
                ", idRuta=" + idRuta +
                ", requiereCuchillo=" + requiereCuchillo +
                ", requiereLampara=" + requiereLampara +
                ", requiereLanza=" + requiereLanza +
                ", requiereMapa=" + requiereMapa +
                ", modifPg=" + modifPg +
                '}';
    }
}
