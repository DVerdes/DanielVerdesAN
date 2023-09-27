package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParserConfigurationException, IOException, SAXException {

//try{


        ArrayList <Mascota> coleccionMascotas = new ArrayList<Mascota>();

            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();

            DocumentBuilder creadorDocumento = fabrica.newDocumentBuilder();

            Document documento = creadorDocumento.parse("src\\xml\\mascotas.xml");

            Element raiz = documento.getDocumentElement();

            NodeList listaMascotas = raiz.getElementsByTagName("mascota");


            for (int i = 0; i<listaMascotas.getLength(); i++){
                Node mascota = listaMascotas.item(i);

                System.out.println("MASCOTA "+i);
                System.out.println("===========");

                coleccionMascotas.add(new Mascota());

                NodeList datosMascota = mascota.getChildNodes();

                for(int j = 0; j<datosMascota.getLength(); j++){
                    Node dato = datosMascota.item(j);

                    if(dato.getNodeType()== Node.ELEMENT_NODE){
                        System.out.println(dato.getNodeName()+": ");



                        Node datoContenido = dato.getFirstChild();

                        if(datoContenido!=null && datoContenido.getNodeType()== Node.TEXT_NODE){
                            System.out.println(datoContenido.getNodeValue());
                            // GUARDANDO TEXTO DE LOS NODOS EN LOS ATRIBUTOS DE LOS OBJETOS DEL ARRAYLIST
                            if(dato.getNodeName().equals("tipo")){
                                coleccionMascotas.get(i).setTipo(dato.getTextContent());
                            }else if(dato.getNodeName().equals("edad")){
                                coleccionMascotas.get(i).setEdad(Integer.parseInt(dato.getTextContent()));
                            }else if(dato.getNodeName().equals("genero")){
                                coleccionMascotas.get(i).setGenero(dato.getTextContent());
                            }
                        }
                    }else{

                        // ATRIBUTO (PARA GUARDAR EN OBJETO MASCOTA...)

                        Element e = (Element)mascota;
                        String name = e.getAttribute("Nombre");

                        coleccionMascotas.get(i).setNombre(name);

                    }

                }

                System.out.println();

            }

            coleccionMascotas.add(new Mascota("Leo","gato"));

            for(int k = 0; k<coleccionMascotas.size(); k++){
                if(coleccionMascotas.get(k).getNombre().equals("Churchill")){
                    coleccionMascotas.get(k).setGenero("Macho");
                }
                System.out.println(coleccionMascotas.get(k).getNombre());
                System.out.println("Tipo: "+coleccionMascotas.get(k).getTipo());
                System.out.println("Edad: "+coleccionMascotas.get(k).getEdad());
                System.out.println("Género: "+coleccionMascotas.get(k).getGenero());
                System.out.println();
            }









      //  }catch (Exception e){
        //    System.out.println("error");
       // }

    }
}
