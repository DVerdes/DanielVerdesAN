package org.example;

/**
 * Clase para generar objetos Respuesta
 */
public class Respuesta {


    private String letra;
    private String contenido;

    private boolean esCorrecta;


    public Respuesta(String letra, String contenido, boolean esCorrecta) {
        this.letra = letra;
        this.contenido = contenido;
        this.esCorrecta = esCorrecta;
    }

    public Respuesta() {
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public boolean isEsCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }



    @Override
    public String toString() {
        return "Respuesta{" +
                "letra='" + letra + '\'' +
                ", contenido='" + contenido + '\'' +
                ", esCorrecta=" + esCorrecta +
                '}';
    }
}
