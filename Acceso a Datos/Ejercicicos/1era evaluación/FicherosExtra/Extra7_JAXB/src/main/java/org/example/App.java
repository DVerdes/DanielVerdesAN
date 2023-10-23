package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JAXBException, IOException {

        ArrayList <Pelicula> pelis = realizarLecturaXML("C://Pruebas//peliculasJAXB.xml");

        for(Pelicula peli: pelis){
            System.out.println(peli.toString());
        }

        realizarGuardadoXML(pelis,"C://Pruebas//resultadoPeliculas.xml");

    }


    private static ArrayList<Pelicula> realizarLecturaXML (String ruta) throws JAXBException {
        File file = new File(ruta);
        ArrayList<Pelicula> coleccionPeliculas = new ArrayList<Pelicula>();
        if(file.exists()){
            JAXBContext jaxbContext = JAXBContext.newInstance(Peliculas.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Peliculas Peliculas = (Peliculas) jaxbUnmarshaller.unmarshal(file);
            coleccionPeliculas = (Peliculas != null ? Peliculas.getListaPeliculas() : new ArrayList<Pelicula>());
        }else{
            System.out.println("No se ha podido encontrar el fichero indicado");
        }
        return coleccionPeliculas;
    }


    private static void realizarGuardadoXML(ArrayList <Pelicula> peliculas, String ruta) throws IOException, JAXBException {
        File file = new File(ruta);

        if(!file.exists()){
            file.createNewFile();
        }
        JAXBContext jaxbContext = JAXBContext.newInstance(Peliculas.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Peliculas ms = new Peliculas();
        ms.setListaPeliculas(peliculas);
        jaxbMarshaller.marshal(ms, file);

    }
}
