package org.example;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;

/**
 * Clase que almacena métodos del bucle de partida
 */
public class JuegoUtils {

    /**
     * Muestra el Panel de Personaje
     * (nombreJugador)
     * (puntosDeGolpe)
     * (inventario)
     * @param partida Partida actual
     * @throws InterruptedException
     */
    public static void mostrarPanelPersonaje(Partida partida) throws InterruptedException {
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

    /**
     * Almacena en colección de MongoDB los datos de la partida
     * @param partida Partida actual
     * @param colPartida MongoCollection de partidas
     */
    public static void guardarPuntuacion(Partida partida, MongoCollection<Document> colPartida) {
        partida.setPuntuacion((100 - partida.getEscenasTotales()) + (partida.getPuntosDeGolpe() * 3));
        System.out.println(partida.getNombreJugador()+": su puntuación ha sido de " + partida.getPuntuacion());
        PartidaCRUD.insertarPartida(colPartida, partida);
    }

    /**
     * Actualiza el inventario
     *  comprueba si la escena tiene un objeto especificado y
     *  lo añade al inventario de la partida
     * @param partida Partida actual
     * @param escena Escena que otorga objeto
     */
    public static void actualizarInventario(Partida partida, Escena escena) {
        ArrayList<String> inventario = partida.getInventario();
        //Comprobar objeto
        if (!escena.getDarObjeto().equals("no")) {
            //Añadir objeto
            inventario.add(escena.getDarObjeto());
            partida.setInventario(inventario);
        }
    }

    /**
     * Filtra elecciones presentes en una escena:
     *  en función de si se poseen los objetos necesarios para desbloquear
     *  dicha elección
     * @param partida Partida actual
     * @param escenaConsultada Escena que contiene las elecciones
     * @return ArrayList de elecciones filtradas
     */
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

    /**
     * Recupera elecciones filtradas (ver filtrarElecciones()) y
     *  añade opción de consultar el Panel de Personaje
     * @param partida partida Actual
     * @param escenaConsultada Escena que contiene elecciones
     * @return ArrayList de elecciones completo
     */
    public static ArrayList <Elección> gestionarElecciones(Partida partida, Escena escenaConsultada){
            ArrayList <Elección> elecciones = filtrarElecciones(partida, escenaConsultada);
        if (escenaConsultada.getId() != -1 && escenaConsultada.getId() != -2) {
            elecciones.add(new Elección(elecciones.size() + 1, "Panel de personaje", escenaConsultada.getId(), ""));
        }
        return elecciones;
    }

    /**
     * Muestra por pantalla elecciones posibles y recibe elección del jugador
     * @param elecciones listado de elecciones posibles
     * @return elección del jugador
     */
    public static int mostrarElecciones(ArrayList <Elección> elecciones){

        int indice = 1;
        for (Elección elección : elecciones) {
            System.out.println(indice + " - " + elección.getTextoElección());
            indice++;
        }
        return AppUtils.pedirNumero(indice);
    }
}
