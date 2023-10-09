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
import java.util.Collection;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String valorDesafio = "2";

        ArrayList<Encuentro> coleccionEncuentros = new ArrayList<Encuentro>();

        DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();

        DocumentBuilder creadorDocumento = fabrica.newDocumentBuilder();

        Document documento = creadorDocumento.parse("src\\xml\\encuentros.xml");

        Element raiz = documento.getDocumentElement();

        NodeList listaEncuentros = raiz.getElementsByTagName("encuentro");

        for (int i = 0; i < listaEncuentros.getLength(); i++) {
            Node encuentro = listaEncuentros.item(i);

            coleccionEncuentros.add(new Encuentro(new ArrayList<Criatura>()));

            Element e = (Element)encuentro;
            String vd = e.getAttribute("vd");

            if(vd.equals(valorDesafio)){
                System.out.println("ENCUENTRO " + i);
                NodeList datosEncuentro = e.getElementsByTagName("criatura");
                ArrayList <Criatura> criaturas = new ArrayList<Criatura>();

                for (int j = 0; j < datosEncuentro.getLength(); j++) {
                    Node criatura = datosEncuentro.item(j);
                    System.out.println("Criatura "+j);
                    NodeList datosCriatura = criatura.getChildNodes();
                    criaturas.add(new Criatura());

                    for(int k = 0; k<datosCriatura.getLength();k++){
                        Node datoCriatura = datosCriatura.item(k);

                        Node datoContenido = datoCriatura.getFirstChild();

                        if(datoContenido!=null && datoContenido.getNodeType()== Node.TEXT_NODE){
                            System.out.println(datoContenido.getNodeValue());
                            // GUARDANDO TEXTO DE LOS NODOS EN LOS ATRIBUTOS DE LOS OBJETOS DEL ARRAYLIST
                            if(datoCriatura.getNodeName().equals("nombre")){
                                System.out.println("Nombre");
                                criaturas.get(j).setNombre(datoContenido.getNodeValue());
                            }else if(datoCriatura.getNodeName().equals("dc")){
                                criaturas.get(j).setDc(datoContenido.getNodeValue());
                            }else if(datoCriatura.getNodeName().equals("pg")){
                                criaturas.get(j).setPg(datoContenido.getNodeValue());
                            }
                        }
                    }
            }

            coleccionEncuentros.get(i).setCriaturas(criaturas);











            }


        }

        for(int l = 0; l<coleccionEncuentros.size(); l++){
            System.out.println("Encuentro "+l);
            for(int p = 0; p<coleccionEncuentros.get(l).getCriaturas().size(); p++){
                System.out.println("Criatura "+p);
                System.out.println("Nombre: "+coleccionEncuentros.get(l).getCriaturas().get(p).getNombre());
                System.out.println("Dc: "+coleccionEncuentros.get(l).getCriaturas().get(p).getDc());
                System.out.println("Pg: "+coleccionEncuentros.get(l).getCriaturas().get(p).getPg());


            }
        }

    }

}
