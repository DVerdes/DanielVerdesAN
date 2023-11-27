package org.example;

import java.util.ArrayList;

/**
 * Clase para generar objetos con preguntas trivial
 */
public class Pregunta {

    private int id;

    private String enunciado;

    private String tema;

    private ArrayList<Respuesta> respuestas;

    public Pregunta(int id, String enunciado, String tema, ArrayList<Respuesta> respuestas) {
        this.id = id;
        this.enunciado = enunciado;
        this.tema = tema;
        this.respuestas = respuestas;
    }

    public Pregunta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public ArrayList<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "id=" + id +
                ", enunciado='" + enunciado + '\'' +
                ", tema='" + tema + '\'' +
                ", respuestas=" + respuestas +
                '}';
    }
}
