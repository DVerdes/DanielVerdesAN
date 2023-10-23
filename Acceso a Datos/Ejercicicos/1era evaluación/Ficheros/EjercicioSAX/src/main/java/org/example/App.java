package org.example;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.stream.events.Attribute;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SAXException, IOException {
        String ruta = "src\\xml\\copia.xml";

        XMLReader lector = XMLReaderFactory.createXMLReader();
        ParseadorMascotasSAX parser = new ParseadorMascotasSAX();
        lector.setContentHandler(parser);
        InputSource fichero = new InputSource(ruta);
        lector.parse(fichero);
        ArrayList<Mascota> lista = parser.obtenerResultado();

        //print
        for (Mascota m : lista) {
            System.out.println(m.getNombre());
            System.out.println("Tipo: " + m.getTipo());
            System.out.println("Género: " + m.getGenero());
            System.out.println("Edad: " + m.getEdad());
            System.out.println();
        }


    }


}
