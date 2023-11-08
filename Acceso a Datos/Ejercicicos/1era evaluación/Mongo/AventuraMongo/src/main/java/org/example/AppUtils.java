package org.example;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.*;

/**
 * Clase con métodos de utilidad general
 */
public class AppUtils {

    /**
     * Pide un número al jugador,
     *  realiza manejo de excepciones
     * @param limite superior del número
     * @return número introducido por jugador
     */
    public static int pedirNumero(int limite) {
        int numero = 0;
        boolean comprobacion = false;
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                do {
                    numero = scanner.nextInt();
                    if (numero >= limite || numero <= 0) {
                        System.out.println("Por favor, introduzca un número correcto");
                    }
                } while (numero >= limite || numero <= 0);
                comprobacion = true;
            } catch (Exception e) {
                System.out.println("Por favor, introduzca un valor correcto");
                comprobacion = false;
            }
        } while (!comprobacion);
        return numero;
    }


    /**
     * Muestra opciones de menú y solicita selección
     * @return item del menú seleccionado
     */
    public static int mostrarMenu() {
        System.out.println("MENÚ");
        System.out.println(" Seleccione una opción:");
        System.out.println(" 1 - Jugar");
        System.out.println(" 2 - Reglas");
        System.out.println(" 3 - Puntuaciones");
        System.out.println(" 4 - Salir");
        return pedirNumero(5);
    }

    /**
     * Introduce menú principal
     * @param colPartida colección mongo de partidas (necesaria para mostrar puntuaciones)
     * @return true para jugar, false para salir
     * @throws InterruptedException
     */
    public static boolean bucleMenu(MongoCollection<Document> colPartida) throws InterruptedException {
        int numero = 0;
        do {
            numero = mostrarMenu();
            if (numero == 1) {
                return true;
            } else if (numero == 2) {
                mostrarReglas();
            } else if (numero == 3) {
                mostrarPuntuaciones(colPartida,5);
            } else {
                return false;
            }
        } while (numero == 2 || numero == 3);
        return false;
    }

    /**
     * Muestra puntuaciones jugadores en orden descendente
     * @param colPartida colección mongo con partidas
     * @param puntuacionesMostradas número de puntuaciones que se quieren mostrar
     */
    private static void mostrarPuntuaciones(MongoCollection<Document> colPartida, int puntuacionesMostradas) {
        int indice = 1;
        //Leer partidas de colección de BBDD
        List<Partida> partidas = PartidaCRUD.listarPartidas(colPartida);
        //Ordenar listado por puntuación (descendente)
        Collections.sort(partidas, new Comparator<Partida>() {
            public int compare(Partida o1, Partida o2) {
                if (o1.getPuntuacion() == o2.getPuntuacion())
                    return 0;
                return o1.getPuntuacion() > o2.getPuntuacion() ? -1 : 1;
            }
        });
        //Imprimir por pantalla listado puntuaciones
        System.out.println();
        System.out.println("PUNTUACIONES: ");
        System.out.println("____________________________");
        for (Partida partida : partidas
        ) {
            System.out.println(" - " + indice + ": " + partida.getNombreJugador() + ", " + partida.getPuntuacion() + " puntos.");
            indice++;
            if (indice > puntuacionesMostradas) {
                break;
            }
        }
        System.out.println("____________________________");
        System.out.println();
    }

    /**
     * Muestra las reglas
     * @throws InterruptedException
     */
    private static void mostrarReglas() throws InterruptedException {
        System.out.println("Este programa recoge una aventura conversacional:");
        System.out.println("- El jugador debe elegir que decisión toma en cada escena.");
        System.out.println("- El jugador empieza la partida con tres puntos de golpe, los cuales puede perder o ganar.");
        System.out.println("- Si los puntos de golpe del jugador llegan a 0, este perderá la partida.");
        System.out.println("- Durante el desarrollo de la aventura, el jugador puede conseguir objetos que le ayudarán.");
        System.out.println("- Al finalizar la partida, se le asignará una puntuación al jugador en función de\nlas escenas recorridas y las vidas restantes.");
        System.out.println();
        Thread.sleep(2000);
    }

    /**
     * Pide nombre al jugador
     * @param longitudMaxima longitud máxima del nombre
     * @return nombre comprobado
     */
    public static String pedirNombre(int longitudMaxima) {
        Scanner scanner = new Scanner(System.in);
        String nombre = "";

        do {
            nombre = scanner.nextLine();
            if (nombre.equals("")) {
                System.out.println("Por favor, escriba un nombre");
            } else if (nombre.length() > longitudMaxima) {
                System.out.println("Por favor, escriba un nombre más corto");
            }

        } while (nombre.equals("") || nombre.length() > longitudMaxima);

        return nombre;
    }




}
