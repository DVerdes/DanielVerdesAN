package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;

/**
 * Clase que contiene el Ejercicio 2 del examen
 */
public class Ejercicio2 {
    public static void main(String[] args) {

        // ruta fichero .xml
        String ruta = "src\\ficEjercicio2\\Ejercicio2.xml";

        // método para leer XML
        leerXML(ruta);


    }

    /**
     * Método para leer fichero XML usando DOM
     *
     * @param ruta ruta del archivo a leer
     */
    private static void leerXML(String ruta) {

        try {
            // ArrayList para guardar objetos Rio
            ArrayList<Rio> coleccionRios = new ArrayList<Rio>();

            // DocumentBuilderFactory
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            // Document Builder
            DocumentBuilder creadorDocumento = fabrica.newDocumentBuilder();
            // Document
            Document documento = creadorDocumento.parse(ruta);
            // Elemento Raíz
            Element raiz = documento.getDocumentElement();
            // NodeList que cuelga de raíz (objetos Rio...)
            NodeList listaRios = raiz.getElementsByTagName("rio");

            // bucle para leer los elementos rio del xml
            for (int i = 0; i < listaRios.getLength(); i++) {
                // nodo rio
                Node rio = listaRios.item(i);

                // añadimos objeto con el constructor vacío
                coleccionRios.add(new Rio());

                // elemento para filtrar atributos
                Element e1 = (Element) rio;
                // atributo nombre
                coleccionRios.get(i).setNombre(e1.getAttribute("Nombre"));
                // atributo longitud (comprobamos que exista para que no existan problemas al parsear)
                if (e1.hasAttribute("Longitud")) {
                    coleccionRios.get(i).setLongitud(Integer.parseInt(e1.getAttribute("Longitud")));
                }
                // atributo vertiente
                coleccionRios.get(i).setVertiente(e1.getAttribute("Vertiente"));

                // programación para acceder al nivel de etiqueta cuenca
                NodeList datosRio = rio.getChildNodes();

                for (int j = 0; j < datosRio.getLength(); j++) {
                    Node dato = datosRio.item(j);

                    if (dato.getNodeType() == Node.ELEMENT_NODE) {


                        Node datoContenido = dato.getFirstChild();

                        if (datoContenido != null && datoContenido.getNodeType() == Node.TEXT_NODE) {
                            // cuenca
                            if (dato.getNodeName().equals("cuenca")) {
                                coleccionRios.get(i).setCuenca(dato.getTextContent());
                            }
                        }
                    } else {


                    }

                }
                // sacamos contenido ArrayList por pantalla
                System.out.println(coleccionRios.get(i).toString());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
