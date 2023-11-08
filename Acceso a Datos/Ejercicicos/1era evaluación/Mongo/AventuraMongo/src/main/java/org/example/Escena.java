package org.example;

import java.util.Arrays;

/**
 *  * Clase para crear y operar con objetos Escena
 */
public class Escena {

    //identificador de Escena
    private int id;

    //descripción de Escena
    private String texto;

    //cambio que produce sobre los Pg del personaje
    private int modifPg;

    //objetos que otorga al jugador
    private String darObjeto;

    //conjunto de objetos Elección asociados
    private Elección[] elecciones;

    public Escena() {
    }

    public Escena(int id, String texto, int modifPg, String darObjeto, Elección[] elecciones) {
        this.id = id;
        this.texto = texto;
        this.modifPg = modifPg;
        this.darObjeto = darObjeto;
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
                ", elecciones=" + Arrays.toString(elecciones) +
                '}';
    }
}
