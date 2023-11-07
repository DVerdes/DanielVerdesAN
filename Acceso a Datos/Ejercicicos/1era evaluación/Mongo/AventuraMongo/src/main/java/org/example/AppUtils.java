package org.example;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AppUtils {

    public static int pedirNumero(int limite){
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
        }while (!comprobacion);
        return numero;

    }


    public static int mostrarMenu(){
        System.out.println("MENÚ");
        System.out.println(" Seleccione una opción:");
        System.out.println(" 1 - Jugar");
        System.out.println(" 2 - Reglas");
        System.out.println(" 3 - Puntuaciones");
        System.out.println(" 4 - Salir");
        return pedirNumero(5);
    }
    
    public static boolean bucleMenu(MongoCollection<Document> colPartida) throws InterruptedException {
        int numero = 0;
        do{
            numero = mostrarMenu();
            if(numero==1){
                return true;
            }else if(numero==2){
                mostrarReglas();
            }else if(numero==3){
                mostrarPuntuaciones(colPartida);
            }else{
                return false;
            }
        }while (numero==2 || numero==3);
        return false;
    }

    private static void mostrarPuntuaciones(MongoCollection<Document> colPartida) {
        int puntuacionesMostradas = 5;
        int indice = 1;
        List<Partida> partidas = PartidaCRUD.listarPartidas(colPartida);
        Collections.sort(partidas, new Comparator<Partida>(){
            public int compare(Partida o1, Partida o2){
                if(o1.getPuntuacion() == o2.getPuntuacion())
                    return 0;
                return o1.getPuntuacion() > o2.getPuntuacion() ? -1 : 1;
            }
        });

        System.out.println();
        System.out.println("PUNTUACIONES: ");
        System.out.println("____________________________");

        for (Partida partida:partidas
             ) {
            System.out.println(" - "+indice+": "+partida.getNombreJugador()+", "+partida.getPuntuacion()+" puntos.");
            indice++;
            if(indice>puntuacionesMostradas){
                break;
            }
        }
        System.out.println("____________________________");

        System.out.println();
    }

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

    public static String pedirNombre(){
        Scanner scanner = new Scanner(System.in);
        String nombre = "";

        do{
            nombre = scanner.nextLine();
            if(nombre.equals("")){
                System.out.println("Por favor, escriba un nombre");
            }else if(nombre.length()>15){
                System.out.println("Por favor, escriba un nombre más corto");
            }

        }while (nombre.equals("")||nombre.length()>15);

        return nombre;

    }

    public static void mostrarInventario(Partida partida) throws InterruptedException {
        System.out.println("________________________________");
        System.out.println(partida.getNombreJugador() + ":");
        System.out.println("Tienes " + partida.getPuntosDeGolpe() + " punto(s) de golpe.");
        System.out.println("Objetos: ");
        for (String objeto : partida.getInventario()) {
            System.out.println("- " + objeto);
        }
        System.out.println("________________________________");
        Thread.sleep(3000);
    }



}
