package org.example;

public class Elección {

    private int numElección;

    private String textoElección;

    private int idRuta;

    private String objetoNecesario;



    public Elección() {
    }

    public Elección(int numElección, String textoElección, int idRuta, String objetoNecesario) {
        this.numElección = numElección;
        this.textoElección = textoElección;
        this.idRuta = idRuta;
        this.objetoNecesario = objetoNecesario;
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

    public String getObjetoNecesario() {
        return objetoNecesario;
    }

    public void setObjetoNecesario(String objetoNecesario) {
        this.objetoNecesario = objetoNecesario;
    }

    @Override
    public String toString() {
        return "Elección{" +
                "numElección=" + numElección +
                ", textoElección='" + textoElección + '\'' +
                ", idRuta=" + idRuta +
                ", objetoNecesario='" + objetoNecesario + '\'' +
                '}';
    }
}
