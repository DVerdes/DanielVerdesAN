/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.com.aulanosa.paneljuegos;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Clase que contiene controlador de la pantalla de juego
 *
 * @author DVerd
 */
public class SecondaryController {

    //componentes interfaz
    //choiceBox para elegir piedra, papel o tijera
    @FXML
    private ChoiceBox listaDesplegable;

    //label con resultado de la partida
    @FXML
    private Label labelGanador;

    //label con elección aleatoria de CPU
    @FXML
    private Label elecCPU;

    //boton para enviar elección jugador (Jugar)
    @FXML
    private Button botonEnviar;

    //boton para acceder a pantalla de resultados
    @FXML
    private Button botonResultados;

    //lista con valores de ChoiceBox
    ObservableList<String> valoresLista = FXCollections.observableArrayList("Piedra", "Papel", "Tijera");

    //ArrayList de objetos Partida 
    ArrayList<Partida> listaPartidas = new ArrayList<Partida>();

    /**
     * Setear contenido valoresLista en ChoiceBox
     */
    private void setListaDesplegable() {
        listaDesplegable.setItems(valoresLista);
    }

    /**
     * inicializa listaDesplegable
     */
    public void initialize() {
        setListaDesplegable();
    }

    /**
     * Método principal de juego (al pulsar botón Enviar)
     *
     * @throws IOException
     */
    public void accButton() throws IOException {

        if (listaDesplegable.getValue() != null) {
            //String con elección jugador
            String elecJugador = listaDesplegable.getValue().toString();
            //Se invoca método para generar elección aleatoria CPU
            String eleccionCPU = randomElection();
            elecCPU.setText(eleccionCPU);

            //resultado para guardar en objeto Partida
            String resultado = "";
            //Condicionales con método victJugador
            if (victJugador(eleccionCPU, elecJugador) == 0) {
                //VICTORIA
                labelGanador.setText("Ganaste!");
                resultado = "Victoria";
            } else if (victJugador(eleccionCPU, elecJugador) == 1) {
                //DERROTA
                labelGanador.setText("Perdiste!");
                resultado = "Derrota";
            } else {
                //EMPATE
                labelGanador.setText("Empate!");
                resultado = "Empate";
            }

            //Se añade a lista nuevo objeto Partida con atributos definidos en el constructor
            listaPartidas.add(new Partida(elecJugador, eleccionCPU, resultado, new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime())));
        } else {
            //Si no se ha elegido opción en el ChoiceBox
            labelGanador.setText("Elige...");
        }
    }

    /**
     * Método que genera elección aleatoria para la CPU
     *
     * @return String con jugada CPU
     */
    public String randomElection() {
        int random = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
        if (random == 1) {
            return "Piedra";
        } else if (random == 2) {
            return "Papel";
        } else {
            return "Tijera";
        }
    }

    /**
     * Método para determinar resultado en función elecciones jugador y CPU
     *
     * @param elecCPU jugada de la CPU
     * @param elecJugador jugada del humano
     * @return número entero (0:victoria, 1:derrota, 2:empate)
     */
    public int victJugador(String elecCPU, String elecJugador) {
        //elección jugador "Piedra"
        if (elecJugador.equals("Piedra")) {
            switch (elecCPU) {
                case "Piedra":
                    return 2;
                case "Papel":
                    return 1;
                default:
                    return 0;
            }
            //elección jugador "Papel"
        } else if (elecJugador.equals("Papel")) {
            switch (elecCPU) {
                case "Piedra":
                    return 0;
                case "Papel":
                    return 2;
                default:
                    return 1;
            }
            //elección jugador "Tijera"
        } else {
            switch (elecCPU) {
                case "Piedra":
                    return 1;
                case "Papel":
                    return 0;
                default:
                    return 2;
            }
        }
    }

    /**
     * Método para cambiar a ventana de resultados (results)
     * @param event evento de botón
     * @throws IOException 
     */
    public void cambiarVentana(javafx.event.ActionEvent event) throws IOException {

        Scene scene = botonResultados.getScene();

        if (scene != null) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("results.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            //mediante controlador se envía la lista de objetos Partida
            ResultsController controlador = loader.getController();
            controlador.setResultados(listaPartidas);
        }
    }

}
