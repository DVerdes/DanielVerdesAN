package org.example;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class ParseadorPeliculasSax extends DefaultHandler {
    private ArrayList<Pelicula> listado;
    private Pelicula pelicula;
    private String valorElemento;

    private ArrayList <String> reparto;

    enum tiposNodo{
        CINE,

        PELICULA,

        CATEGORIA,

        TITULO,
        IDIOMA,
        DIRECTOR,
        ESTRENO,
        REPARTO,
        ACTOR

    }

    public ParseadorPeliculasSax(){
        super();
    }

    public void startDocument() throws SAXException {
        listado = new ArrayList<Pelicula>();
    }


    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        if(localName!=null){
            switch(tiposNodo.valueOf(localName.toUpperCase())){
                case PELICULA:
                    pelicula = new Pelicula();
                    String nombre = attributes.getValue("categoria");
                    if(nombre!=null){
                        pelicula.setCategoria(nombre);
                    }
                    break;
                case TITULO:
                    String nombre2 = attributes.getValue("idioma");
                    if(nombre2!=null){
                        pelicula.setIdioma(nombre2);
                    }
                    break;

                case REPARTO:
                    this.reparto = new ArrayList<String>();
                    break;


            }
        }
    }



    public void endElement(String uri, String localName, String qName) throws SAXException{
        if(localName!=null){
            switch (tiposNodo.valueOf(localName.toUpperCase())){

                case PELICULA:
                    listado.add(pelicula);
                    break;
                case TITULO:
                    pelicula.setTitulo(valorElemento);
                    break;
                case DIRECTOR:
                    pelicula.setDirector(valorElemento);
                    break;
                case ESTRENO:
                    pelicula.setEstreno(valorElemento);
                    break;
                case ACTOR:
                    this.reparto.add(valorElemento);
                    break;
                case REPARTO:
                    pelicula.setActores(this.reparto);
            }
        }
    }

    public void characters(char[] ch, int start, int lenght){
        valorElemento = new String(ch,start,lenght);
    }

    public ArrayList<Pelicula> obtenerResultado(){
        return listado;
    }


}
