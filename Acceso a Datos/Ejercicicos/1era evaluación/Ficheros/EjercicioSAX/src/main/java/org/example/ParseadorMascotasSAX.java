package org.example;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class ParseadorMascotasSAX extends DefaultHandler {
    private ArrayList <Mascota> listado;
    private Mascota mascota;
    private String valorElemento;


    enum tiposNodo{
        MASCOTAS,
        MASCOTA,

        NOMBRE,
        TIPO,
        EDAD,
        GENERO
    }

    public ParseadorMascotasSAX(){
        super();
    }

    public void startDocument() throws SAXException {
        listado = new ArrayList<Mascota>();
    }


    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        if(localName!=null){
            switch(tiposNodo.valueOf(localName.toUpperCase())){
                case MASCOTA:
                    mascota = new Mascota();
                    String nombre = attributes.getValue("Nombre");
                    if(nombre!=null){
                        mascota.setNombre(nombre);
                    }
                    break;
            }
        }
    }



    public void endElement(String uri, String localName, String qName) throws SAXException{
        if(localName!=null){
            switch (tiposNodo.valueOf(localName.toUpperCase())){

                case MASCOTA:
                    listado.add(mascota);
                    break;
                case TIPO:
                    mascota.setTipo(valorElemento);
                    break;
                case EDAD:
                    mascota.setEdad(Integer.parseInt(valorElemento));
                    break;
                case GENERO:
                    mascota.setGenero(valorElemento);
                    break;
            }
        }
    }

public void characters(char[] ch, int start, int lenght){
        valorElemento = new String(ch,start,lenght);
}

public ArrayList<Mascota> obtenerResultado(){
        return listado;
}

}
