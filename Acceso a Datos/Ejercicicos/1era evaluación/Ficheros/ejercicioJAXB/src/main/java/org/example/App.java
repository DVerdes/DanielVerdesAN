package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * JAXB
 *
 */
public class App 
{
    public static void main( String[] args ) throws JAXBException, IOException {

        String ruta = "src\\xml\\mascotas.xml";
        ArrayList <Mascota> listaMascotas = realizarLecturaXML(ruta);

        for(Mascota m : listaMascotas){
            System.out.println(m.getNombre());
            System.out.println("Edad: "+m.getEdad());
            System.out.println("Tipo: "+m.getTipo());
            System.out.println("Género: "+m.getGenero());
            System.out.println("Ciudad: "+m.getCiudad());
            System.out.println();
        }

        listaMascotas.add(new Mascota("Pepe","Perro",12,"Macho"));

        realizarGuardadoXML(listaMascotas, "src\\xml\\copia.xml");

    }

    private static ArrayList<Mascota> realizarLecturaXML (String ruta) throws JAXBException{
        File file = new File(ruta);
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        if(file.exists()){
            JAXBContext jaxbContext = JAXBContext.newInstance(Mascotas.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Mascotas Mascotas = (Mascotas) jaxbUnmarshaller.unmarshal(file);
            mascotas = (Mascotas != null ? Mascotas.getListaMascotas() : new ArrayList<Mascota>());
        }else{
            System.out.println("No se ha podido encontrar el fichero indicado");
        }
        return mascotas;
    }


    private static void realizarGuardadoXML(ArrayList <Mascota> mascotas, String ruta) throws IOException, JAXBException {
        File file = new File(ruta);

        if(!file.exists()){
            file.createNewFile();
        }
        JAXBContext jaxbContext = JAXBContext.newInstance(Mascotas.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Mascotas ms = new Mascotas();
        ms.setListaMascotas(mascotas);
        jaxbMarshaller.marshal(ms, file);

    }
}
