package org.example;

import org.example.entidades.Criatura;
import org.example.entidades.Encuentro;
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
 * Clase con métodos para tratamiento de ficheros .xml mediante DOM
 */
public class XMLUtils {

    /**
     * Método que lee xml y devuelve una lista de encuentros con un valor de desafío especificado (1-3)
     *
     * @param ruta         ruta del xml
     * @param valorDesafio valor de desafío aportado por comando
     * @return lista de encuentros con valor de desafío concreto
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static ArrayList<Encuentro> devolverEncuentro(String ruta, String valorDesafio) throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Encuentro> coleccionEncuentros = new ArrayList<Encuentro>();
        DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
        DocumentBuilder creadorDocumento = fabrica.newDocumentBuilder();
        Document documento = creadorDocumento.parse(ruta);
        Element raiz = documento.getDocumentElement();
        NodeList listaEncuentros = raiz.getElementsByTagName("encuentro");

        // contador para contar el número de encuentros de un valor de desafío concreto
        int contador = 0;


        for (int i = 0; i < listaEncuentros.getLength(); i++) {
            Node encuentro = listaEncuentros.item(i);

            Element e = (Element) encuentro;
            String vd = e.getAttribute("vd");

            // se filtran los encuentros en función del atributo "vd"
            if (vd.equals(valorDesafio)) {

                // ArrayList de objetos Criatura
                coleccionEncuentros.add(new Encuentro(new ArrayList<Criatura>()));


                NodeList datosEncuentro = e.getElementsByTagName("criatura");
                ArrayList<Criatura> criaturas = new ArrayList<Criatura>();

                // lectura
                for (int j = 0; j < datosEncuentro.getLength(); j++) {
                    Node criatura = datosEncuentro.item(j);
                    NodeList datosCriatura = criatura.getChildNodes();
                    criaturas.add(new Criatura());

                    for (int k = 0; k < datosCriatura.getLength(); k++) {
                        Node datoCriatura = datosCriatura.item(k);

                        Node datoContenido = datoCriatura.getFirstChild();

                        if (datoContenido != null && datoContenido.getNodeType() == Node.TEXT_NODE) {
                            // GUARDANDO TEXTO DE LOS NODOS EN LOS ATRIBUTOS DE LOS OBJETOS DEL ARRAYLIST
                            if (datoCriatura.getNodeName().equals("nombre")) {
                                criaturas.get(j).setNombre(datoContenido.getNodeValue());
                            } else if (datoCriatura.getNodeName().equals("dc")) {
                                criaturas.get(j).setDc(datoContenido.getNodeValue());
                            } else if (datoCriatura.getNodeName().equals("pg")) {
                                criaturas.get(j).setPg(datoContenido.getNodeValue());
                            }
                        }
                    }
                }

                // se setean la coleccion de criaturas al encuentro de la iteración de la variable contador
                coleccionEncuentros.get(contador).setCriaturas(criaturas);
                contador++;


            }

        }


        return coleccionEncuentros;
    }

    /**
     * Devuelve los datos de las criaturas presentes en un objeto Encuentro
     *
     * @param encuentro Encuentro elegido para obtener info de las criaturas contenidas en él
     * @return cadena de texto con las criaturas contenidas
     */
    public static String imprimirEncuentro(Encuentro encuentro) {

        String criaturas = "";

        for (int i = 0; i < encuentro.getCriaturas().size(); i++) {
            criaturas += encuentro.getCriaturas().get(i).getNombre() + " - id: " + encuentro.getCriaturas().get(i).getPg() + " DC: " + encuentro.getCriaturas().get(i).getDc() + "\n";
        }

        return criaturas;
    }

    /**
     * Método para aleatorizar el encuentro de un determinado valor de desafío
     *
     * @param valorDesafio valor de desafío concreto
     * @return datos completos del encuentro en cadena de texto o mensaje de error
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static String sacarEncuentroAleatorio(int valorDesafio) throws ParserConfigurationException, IOException, SAXException {
        if (valorDesafio > 0 && valorDesafio < 4) {
            ArrayList<Encuentro> encuentros = XMLUtils.devolverEncuentro("src\\xml\\encuentros.xml", String.valueOf(valorDesafio));

            int random = (int) Math.floor(Math.random() * ((encuentros.size() - 1) - 0 + 1) + 0);
            String criaturas = XMLUtils.imprimirEncuentro(encuentros.get(random));
            return "Encuentro (vd: " + valorDesafio + "): \n" + criaturas;

        } else {
            return "Introduzca un valor de desafio correcto";

        }
    }

}
