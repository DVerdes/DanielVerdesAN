package org.example;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;

public class JuegoUtils {

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


    public static void guardarPuntuacion(Partida partida, MongoCollection<Document> colPartida) {
        partida.setPuntuacion((100 - partida.getEscenasTotales()) + (partida.getPuntosDeGolpe() * 3));
        System.out.println(partida.getNombreJugador()+": su puntuación ha sido de " + partida.getPuntuacion());
        PartidaCRUD.insertarPartida(colPartida, partida);
    }


    public static void actualizarInventario(Partida partida, Escena escena) {
        ArrayList<String> inventario = partida.getInventario();

        //añadir objeto
        if (!escena.getDarObjeto().equals("no")) {
            inventario.add(escena.getDarObjeto());
            partida.setInventario(inventario);
        }
    }


    public static ArrayList <Elección> filtrarElecciones(Partida partida, Escena escenaConsultada){

        ArrayList<Elección> eleccionesFiltradas = new ArrayList<Elección>();

        //filtrado de elecciones según objetos en inventario
        for (Elección elección : escenaConsultada.getElecciones()) {
            if (partida.getInventario().contains(elección.getObjetoNecesario()) || elección.getObjetoNecesario().equals("")) {
                eleccionesFiltradas.add(elección);
            }
        }

        return eleccionesFiltradas;

    }


    public static ArrayList <Elección> gestionarElecciones(Partida partida, Escena escenaConsultada, int proximaEscena){
            ArrayList <Elección> elecciones = filtrarElecciones(partida, escenaConsultada);
        if (escenaConsultada.getId() != -1 && escenaConsultada.getId() != -2) {
            elecciones.add(new Elección(elecciones.size() + 1, "Panel de personaje", proximaEscena, ""));
        }
        return elecciones;
    }


    public static int mostrarElecciones(ArrayList <Elección> elecciones){

        int indice = 1;
        for (Elección elección : elecciones) {
            System.out.println(indice + " - " + elección.getTextoElección());
            indice++;
        }
        return AppUtils.pedirNumero(indice);

    }

}
