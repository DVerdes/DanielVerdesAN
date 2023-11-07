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

import static org.example.AppUtils.*;


public class App {
    public static void main(String[] args) {

        System.out.println("¡Hola!, bienvenido a la aventura interactiva.");

        Scanner scanner;

        boolean finalizarJuego = false;
        int proximaEscena;
        int eleccionJugador;
        String comprobarEleccion;
        boolean continuarEscena;
        Escena escenaConsultada;


        MongoClient cliente = MongoClients.create("mongodb://localhost:27017/pruebas");

        try {

            do {


                    scanner = new Scanner(System.in);

                    MongoDatabase conexion = cliente.getDatabase("Aventura");
                    MongoCollection<Document> colMongo = conexion.getCollection("Escenas");


                    MongoCollection<Document> colPartida = conexion.getCollection("Partidas");
                    proximaEscena = 1;
                    eleccionJugador = 0;
                    comprobarEleccion = "";
                    continuarEscena = true;
                    finalizarJuego = false;
                    escenaConsultada = new Escena();

                if (bucleMenu(colPartida)) {
                    int idPartida = PartidaCRUD.listarPartidas(colPartida).size() + 1;
                    System.out.println("Por favor, escriba su nombre");

                    Partida partida = new Partida(idPartida, pedirNombre(), 3, 0, 0, new ArrayList<String>());


                    do {

                        System.out.println();


                        escenaConsultada = EscenaCRUD.consultarEscena(colMongo, proximaEscena);

                        //actualizar pg
                        partida.setPuntosDeGolpe(partida.getPuntosDeGolpe() + escenaConsultada.getModifPg());
                        //PartidaCRUD.actualizarPartida(colPartida, partida);

                        //ArrayList<String> inventario = PartidaCRUD.consultarPartida(colPartida, idPartida).getInventario();
                        ArrayList<String> inventario = partida.getInventario();

                        //añadir objeto
                        if (!escenaConsultada.getDarObjeto().equals("no")) {
                            inventario.add(escenaConsultada.getDarObjeto());
                            partida.setInventario(inventario);
                            //PartidaCRUD.actualizarPartida(colPartida, partida);
                        }

                        System.out.println(escenaConsultada.getTexto());


                        //comprobar si jugador sigue vivo
                        if (partida.getPuntosDeGolpe() <= 0 && escenaConsultada.getId() != -1) {
                            proximaEscena = -1;
                        } else {

                            do {

                                System.out.println("¿Que deseas hacer?");

                                ArrayList<Elección> eleccionesFiltradas = new ArrayList<Elección>();

                                //filtrado de elecciones según objetos en inventario
                                for (Elección elección : escenaConsultada.getElecciones()) {
                                    if (partida.getInventario().contains(elección.getObjetoNecesario()) || elección.getObjetoNecesario().equals("")) {
                                        eleccionesFiltradas.add(elección);
                                    }
                                }
                                //ver inventario
                                if (escenaConsultada.getId() != -1 && escenaConsultada.getId() != -2) {
                                    eleccionesFiltradas.add(new Elección(eleccionesFiltradas.size() + 1, "Panel de personaje", proximaEscena, ""));
                                }
                                //elecciones por pantalla
                                int indice = 1;
                                for (Elección elección : eleccionesFiltradas) {
                                    System.out.println(indice + " - " + elección.getTextoElección());
                                    indice++;
                                }

                                eleccionJugador = AppUtils.pedirNumero(indice);

                                proximaEscena = eleccionesFiltradas.get(eleccionJugador - 1).getIdRuta();
                                comprobarEleccion = eleccionesFiltradas.get(eleccionJugador - 1).getTextoElección();

                                //ver inventario
                                if (comprobarEleccion.equals("Panel de personaje")) {
                                    mostrarInventario(partida);
                                    continuarEscena = false;
                                } else {
                                    partida.setEscenasTotales(partida.getEscenasTotales()+1);
                                    continuarEscena = true;
                                }

                            } while (!continuarEscena);
                            Thread.sleep(500);

                        }


                    } while (escenaConsultada.getId() != -1 && escenaConsultada.getId() != -2);

                    //puntuación
                    if (escenaConsultada.getId() == -2) {
                        partida.setPuntuacion((100 - partida.getEscenasTotales()) + (partida.getPuntosDeGolpe() * 3));
                        System.out.println("Su puntuación ha sido de " + partida.getPuntuacion());
                        PartidaCRUD.insertarPartida(colPartida, partida);
                    }


                    if (comprobarEleccion.equals("Salir")) {
                        finalizarJuego = true;
                    }


                }else{
                    finalizarJuego = true;
                }
            } while (!finalizarJuego);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {


            if (cliente != null) {
                cliente.close();
            }
        }


    }


}
