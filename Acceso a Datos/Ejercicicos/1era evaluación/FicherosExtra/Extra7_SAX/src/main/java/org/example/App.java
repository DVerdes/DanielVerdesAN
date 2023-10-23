package org.example;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SAXException, IOException {
        String ruta = "C:\\Pruebas\\peliculas.xml";

        XMLReader lector = XMLReaderFactory.createXMLReader();
        ParseadorPeliculasSax parser = new ParseadorPeliculasSax();
        lector.setContentHandler(parser);
        InputSource fichero = new InputSource(ruta);
        lector.parse(fichero);
        ArrayList<Pelicula> lista = parser.obtenerResultado();

        for(Pelicula pelicula: lista){
            System.out.println(pelicula.getTitulo());
            System.out.println(pelicula.getCategoria());
            System.out.println(pelicula.getIdioma());
            System.out.println(pelicula.getEstreno());
            System.out.println(pelicula.getDirector());
            System.out.println("Reparto:");
            for(String actor: pelicula.getActores()){
                System.out.println(actor);
            }
        }

    }
}
