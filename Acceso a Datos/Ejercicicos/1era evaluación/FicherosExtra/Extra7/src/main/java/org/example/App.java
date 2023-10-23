package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParserConfigurationException, IOException, SAXException, TransformerException {

        // meter todo en un try catch
        ArrayList <Pelicula> coleccionPeliculas = new ArrayList<Pelicula>();

        DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
        DocumentBuilder creadorDocumento = fabrica.newDocumentBuilder();
        Document documento = creadorDocumento.parse("C:\\Pruebas\\peliculas.xml");
        Element raiz = documento.getDocumentElement();
        NodeList listaPeliculas = raiz.getElementsByTagName("pelicula");

        for (int i = 0; i<listaPeliculas.getLength(); i++){
            Node pelicula = listaPeliculas.item(i);


            coleccionPeliculas.add(new Pelicula());

            NodeList datosPelicula = pelicula.getChildNodes();

            for(int j = 0; j<datosPelicula.getLength(); j++){
                Node dato = datosPelicula.item(j);

                if(dato.getNodeType()== Node.ELEMENT_NODE){



                    Node datoContenido = dato.getFirstChild();

                    if(datoContenido!=null && datoContenido.getNodeType()== Node.TEXT_NODE){
                        // GUARDANDO TEXTO DE LOS NODOS EN LOS ATRIBUTOS DE LOS OBJETOS DEL ARRAYLIST
                        if(dato.getNodeName().equals("titulo")){
                            coleccionPeliculas.get(i).setTitulo(dato.getTextContent());
                            Element e = (Element)dato;
                            String idioma = e.getAttribute("idioma");
                            coleccionPeliculas.get(i).setIdioma(idioma);
                        }else if(dato.getNodeName().equals("director")){
                            coleccionPeliculas.get(i).setDirector(dato.getTextContent());
                        }else if(dato.getNodeName().equals("estreno")){
                            coleccionPeliculas.get(i).setEstreno(dato.getTextContent());
                        }else if(dato.getNodeName().equals("reparto")){
                            // podia ser mejor usar:
                            // NodeList getElementsByTagName("reparto");
                            NodeList datosReparto = dato.getChildNodes();

                            ArrayList <String> actores = new ArrayList<String>();
                            for(int k = 0; k<datosReparto.getLength(); k++){
                                Node datoReparto = datosReparto.item(k);
                                if(datoReparto!=null && datoReparto.getNodeType()!= Node.TEXT_NODE){
                                    actores.add(datoReparto.getTextContent());
                                }

                            }
                            coleccionPeliculas.get(i).setActores(actores);
                        }
                    }
                }else{

                    // ATRIBUTO (PARA GUARDAR EN OBJETO MASCOTA...)

                    Element e = (Element)pelicula;
                    String categoria = e.getAttribute("categoria");

                    coleccionPeliculas.get(i).setCategoria(categoria);

                }

            }

            System.out.println(coleccionPeliculas.get(i).getTitulo()+"-"+coleccionPeliculas.get(i).getCategoria()+"-"+coleccionPeliculas.get(i).getDirector()+"-"+coleccionPeliculas.get(i).getIdioma()+"-"+coleccionPeliculas.get(i).getEstreno()+"-"+coleccionPeliculas.get(i).getActores().get(0)+"/"+coleccionPeliculas.get(i).getActores().get(1));

        }

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
        DOMSource domSource = new DOMSource(documento);
        StreamResult resultado = new StreamResult((new File("C:\\Pruebas\\copia7.xml")));
        transformer.transform(domSource, resultado);
    }
}
