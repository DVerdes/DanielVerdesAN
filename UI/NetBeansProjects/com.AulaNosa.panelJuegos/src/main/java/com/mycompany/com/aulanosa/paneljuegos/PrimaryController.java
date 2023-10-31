package com.mycompany.com.aulanosa.paneljuegos;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Clase que contiene controlador del menú principal
 * @author DVerd
 */
public class PrimaryController {

    //Componentes interfaz
    
    //botón jugar
    @FXML
    private Button bJugar;

    //botón menú reservas
    @FXML
    private Button bReservar;

    //textField nombre jugador
    @FXML
    private TextField tfJugador;

    //textField email jugador
    @FXML
    private TextField tfEmail;

    //textField edad jugador
    @FXML
    private TextField tfEdad;

    /**
     * Método para cambiar a pantalla de juego (secondary)
     * @param event evento de botón
     * @throws IOException 
     */
    @FXML
    private void switchToSecondary(ActionEvent event) throws IOException {

        Scene scene = bJugar.getScene();

        if (scene != null) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    /**
     * Método para cambiar a ventana de reservas (Tertiary)
     * @param event
     * @throws IOException 
     */
    @FXML
    private void switchToTerciary(ActionEvent event) throws IOException {

        Scene scene = bReservar.getScene();

        if (scene != null) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("terciary.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            //mediante controlador se pasan datos de nombre y email del jugador
            TercController controlador = loader.getController();
            controlador.setUser(tfJugador.getText());
            controlador.setEmail(tfEmail.getText());
        }
    }
}
