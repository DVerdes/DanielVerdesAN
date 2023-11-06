package org.example;

import java.util.Arrays;

public class Escena {


    private int id;
    private String texto;

    private int modifPg;

    private String darObjeto;

    private String quitarObjeto;

    private Elección[] elecciones;

    public Escena() {
    }

    public Escena(int id, String texto, int modifPg, String darObjeto, String quitarObjeto, Elección[] elecciones) {
        this.id = id;
        this.texto = texto;
        this.modifPg = modifPg;
        this.darObjeto = darObjeto;
        this.quitarObjeto = quitarObjeto;
        this.elecciones = elecciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getModifPg() {
        return modifPg;
    }

    public void setModifPg(int modifPg) {
        this.modifPg = modifPg;
    }

    public String getDarObjeto() {
        return darObjeto;
    }

    public void setDarObjeto(String darObjeto) {
        this.darObjeto = darObjeto;
    }

    public String getQuitarObjeto() {
        return quitarObjeto;
    }

    public void setQuitarObjeto(String quitarObjeto) {
        this.quitarObjeto = quitarObjeto;
    }

    public Elección[] getElecciones() {
        return elecciones;
    }

    public void setElecciones(Elección[] elecciones) {
        this.elecciones = elecciones;
    }

    @Override
    public String toString() {
        return "Escena{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                ", modifPg=" + modifPg +
                ", darObjeto='" + darObjeto + '\'' +
                ", quitarObjeto='" + quitarObjeto + '\'' +
                ", elecciones=" + Arrays.toString(elecciones) +
                '}';
    }
}
