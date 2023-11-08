package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Scanner;

import static org.example.AppUtils.*;
import static org.example.JuegoUtils.*;

/**
 * Clase que contiene la clase Main ejecutable
 */
public class App {
    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {

        //Mensaje de bienvenida
        System.out.println("¡Hola!, bienvenido a la aventura interactiva.");

        //Declaración de scanner
        Scanner scanner;

        //Declaración de variables
        boolean finalizarJuego = false;
        boolean continuarEscena;

        int proximaEscena;
        int eleccionJugador;

        String comprobarEleccion;

        //Declaración de objeto escena
        Escena escenaConsultada;

        //MongoClient
        MongoClient cliente = MongoClients.create("mongodb://localhost:27017/pruebas");

        try {

            //Bucle de menú principal
            do {

                //Inicio scanner
                scanner = new Scanner(System.in);

                //Conexión a BBDD
                MongoDatabase conexion = cliente.getDatabase("Aventura");

                //Colección mongo de Escenas
                MongoCollection<Document> colMongo = conexion.getCollection("Escenas");

                //Colección mongo de Partidas
                MongoCollection<Document> colPartida = conexion.getCollection("Partidas");

                //Reinicio de variables
                //Se incia siempre en escena 1
                proximaEscena = 1;
                eleccionJugador = 0;
                comprobarEleccion = "";
                continuarEscena = true;
                finalizarJuego = false;
                //Reinicio de escena
                escenaConsultada = new Escena();

                //Bucle Menú
                if (bucleMenu(colPartida)) {
                    //Comienzo Partida

                    //Pedir Nombre
                    System.out.println("Por favor, escriba su nombre");
                    /*
                       Crear objeto Partida:
                            id: se el tamaño del listado de partidas y se suma +1 (para obtener id única).
                            nombre: a través método pedirNombre().
                            puntosDeGolpe: se inician en 3.
                            escenasTotales: se inician en 0.
                            inventario: se inicia vacío.
                     */
                    Partida partida = new Partida(PartidaCRUD.listarPartidas(colPartida).size()+1, pedirNombre(15), 3, 0, 0, new ArrayList<String>());

                    do {
                        /*
                            Bucle de escenas:
                                Finaliza con:
                                    -Escena de muerte (-1)
                                    -Escena de victoria (-2)
                         */
                        System.out.println();

                        //Cargar Escena seleccionada
                        escenaConsultada = EscenaCRUD.consultarEscena(colMongo, proximaEscena);

                        //Actualizar puntosDeGolpe
                        partida.setPuntosDeGolpe(partida.getPuntosDeGolpe() + escenaConsultada.getModifPg());

                        //Actualizar inventario
                        JuegoUtils.actualizarInventario(partida, escenaConsultada);

                        //Imprimir texto de Escena
                        System.out.println(escenaConsultada.getTexto());

                        //Comprobar si  el jugador continúa vivo (puntosDeGolpe>0)
                        if (partida.getPuntosDeGolpe() <= 0 && escenaConsultada.getId() != -1) {
                            //Si puntosDeGolpe <=0, se deriva a escena de Muerte
                            proximaEscena = -1;
                        } else {

                            do {
                                //Bucle de misma escena (para posibilitar consulta de inventario)

                                System.out.println("¿Que deseas hacer?");

                                //Filtrado de elecciones según objetos en inventario
                                ArrayList<Elección> eleccionesFiltradas = gestionarElecciones(partida, escenaConsultada);

                                //Elección tomada por jugador
                                eleccionJugador = mostrarElecciones(eleccionesFiltradas);

                                //Ruta de próxima escena según elección
                                proximaEscena = eleccionesFiltradas.get(eleccionJugador - 1).getIdRuta();

                                //Texto de elección para comprobaciones
                                comprobarEleccion = eleccionesFiltradas.get(eleccionJugador - 1).getTextoElección();

                                if (comprobarEleccion.equals("Panel de personaje")) {
                                    //Ver Panel de Personaje
                                    mostrarPanelPersonaje(partida);
                                    continuarEscena = false;
                                } else {
                                    //Continuar
                                    partida.setEscenasTotales(partida.getEscenasTotales() + 1);
                                    continuarEscena = true;
                                }

                            } while (!continuarEscena);
                            Thread.sleep(500);

                        }

                    } while (escenaConsultada.getId() != -1 && escenaConsultada.getId() != -2);

                    //Gestionar puntuación
                    if (escenaConsultada.getId() == -2) {
                        JuegoUtils.guardarPuntuacion(partida, colPartida);
                    }

                    //Romper bucle de juego
                    if (comprobarEleccion.equals("Salir")) {
                        finalizarJuego = true;
                    }

                //Salir del menú
                } else {
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
