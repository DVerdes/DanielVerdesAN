package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sun.xml.internal.ws.wsdl.writer.document.Part;
import org.bson.Document;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Scanner scanner = new Scanner(System.in);

        int contadorEscenas = 0;
        int proximaEscena = 1;
        int eleccionJugador = 0;
        String comprobarEleccion = "";
        boolean continuarEscena = true;
        Escena escenaConsultada = new Escena();

        MongoClient cliente = MongoClients.create("mongodb://localhost:27017/pruebas");

        try{
            MongoDatabase conexion = cliente.getDatabase("Aventura");
            MongoCollection<Document> colMongo = conexion.getCollection("Escenas");
            MongoCollection<Document> colPartida = conexion.getCollection("Partidas");

            int idPartida = PartidaCRUD.listarPartidas(colPartida).size()+1;

            System.out.println("¡Hola!, bienvenido a la aventura interactiva.");
            System.out.println("Por favor, escriba su nombre");

            Partida partida = new Partida(idPartida,scanner.nextLine(),3,0, new ArrayList<String>());
            PartidaCRUD.insertarPartida(colPartida,partida);


            do{

                System.out.println();
                //temp
                System.out.println( partida.toString());



                escenaConsultada = EscenaCRUD.consultarEscena(colMongo,proximaEscena);

                //actualizar pg
                partida.setPuntosDeGolpe(partida.getPuntosDeGolpe()+escenaConsultada.getModifPg());
                PartidaCRUD.actualizarPartida(colPartida,partida);

                ArrayList <String> inventario = PartidaCRUD.consultarPartida(colPartida,idPartida).getInventario();

                //añadir objeto
                if(!escenaConsultada.getDarObjeto().equals("no")){
                    inventario.add(escenaConsultada.getDarObjeto());
                    partida.setInventario(inventario);
                    PartidaCRUD.actualizarPartida(colPartida, partida);
                }

                //comprobar si jugador sigue vivo
                if(partida.getPuntosDeGolpe()<=0){
                    proximaEscena = -1;
                }else{
                    System.out.println(escenaConsultada.getTexto());

                    do {

                        System.out.println("¿Que deseas hacer?");

                        ArrayList<Elección> eleccionesFiltradas = new ArrayList<Elección>();

                        //filtrado de elecciones según objetos en inventario
                        for (Elección elección : escenaConsultada.getElecciones()) {
                            if (inventario.contains(elección.getObjetoNecesario()) || elección.getObjetoNecesario().equals("")) {
                                eleccionesFiltradas.add(elección);
                            }
                        }
                        //ver inventario
                        eleccionesFiltradas.add(new Elección(eleccionesFiltradas.size() + 1, "Panel de personaje", proximaEscena, ""));
                        //elecciones por pantalla
                        int indice = 1;
                        for (Elección elección : eleccionesFiltradas) {
                            System.out.println(indice + " - " + elección.getTextoElección());
                            indice++;
                        }

                        eleccionJugador = scanner.nextInt();
                        for (Elección elección : eleccionesFiltradas) {
                            if (elección.getNumElección() == eleccionJugador) {
                                proximaEscena = elección.getIdRuta();
                                comprobarEleccion = elección.getTextoElección();
                                break;
                            }
                        }
                        //ver inventario
                        if (comprobarEleccion.equals("Panel de personaje")) {
                            System.out.println(partida.getNombreJugador() + ":");
                            System.out.println("Tienes " + partida.getPuntosDeGolpe() + " puntos de golpe.");
                            System.out.println("Objetos: ");
                            for (String objeto : inventario) {
                                System.out.println("- " + objeto);
                            }
                            Thread.sleep(3000);
                            continuarEscena = false;
                        } else {
                            contadorEscenas++;
                            continuarEscena = true;
                        }

                    }while(!continuarEscena);
                    Thread.sleep(1000);

                }





            }while(escenaConsultada.getId()!=-1);








        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {

            if(cliente!=null){
                cliente.close();
            }
        }





    }
}
