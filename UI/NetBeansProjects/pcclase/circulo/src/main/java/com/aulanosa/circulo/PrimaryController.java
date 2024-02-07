package com.aulanosa.circulo;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * Controlador de fxml primario
 * @author FP
 */
public class PrimaryController {

    // Layout de fondo
    public Pane fondo;

    // Botón
    public Button rectangulo;

    // TranslateTransition
    TranslateTransition tt = new TranslateTransition();

    // Counter
    int contador = 5;

    // Color botón
    String color = "-fx-background-color:rgba(255, 255, 255, 0.87)";

    /**
     * Initialize
     */
    public void initialize() {

        // Auto Reverse
        tt.setAutoReverse(true);

        //Duración transición
        tt.setDuration(Duration.millis(5000));

        // Valores iniciales
        tt.setByX(500);
        tt.setByY(350);

        //Cycle count
        tt.setCycleCount(500);

        // Nodo
        tt.setNode(rectangulo);

        //Ejecutar
        tt.play();
    }

    /**
     * Método de control del botón
     */
    @FXML
    private void cambiarDireccion() {

        // Disminuye contador
        contador--;

        // Condición
        if (contador <= 0) {
            ventanaEmergente();
        } else {
            direccionAleatoria();
        }

    }

    /**
     * Método de juego aún activo
     */
    @FXML
    private void direccionAleatoria() {
        
        // Detiene tt anterior
        tt.stop();

        // Cambia texto
        rectangulo.setText("Púlsame: " + contador);

        // Cambia duración
        tt.setDuration(Duration.millis((int) Math.floor(Math.random() * (1200 - 1000 + 1) + 1000)));
        
        // Ruta tt aleatoria
        int randomx = (int) Math.floor(Math.random() * ((fondo.getWidth()) - 1 + 1) + 1);
        int randomy = (int) Math.floor(Math.random() * ((fondo.getHeight()) - 1 + 1) + 1);
        tt.setToX(randomx);
        tt.setToY(randomy);

        // Color aleatorio
        int rgb1 = (int) Math.floor(Math.random() * 255 - 0 + 1 + 0);
        int rgb2 = (int) Math.floor(Math.random() * 255 - 0 + 1 + 0);
        int rgb3 = (int) Math.floor(Math.random() * 255 - 0 + 1 + 0);
        int rgb4 = (int) Math.floor(Math.random() * 255 - 0 + 1 + 0);
        color = "-fx-background-color:rgba(" + rgb1 + "," + rgb2 + "," + rgb3 + "," + rgb4 + ")";
        rectangulo.setStyle(color);

        //Ejecutar tt con nuevos parámetros
        tt.play();
        
        System.out.println("Click");
    }

    /**
     * Fin de partida
     */
    @FXML
    private void ventanaEmergente() {

        tt.stop();
        rectangulo.setText("0");

        // Ventana emergente
        Alert alert = new Alert(AlertType.CONFIRMATION, "Has ganado!", ButtonType.CLOSE);
        alert.showAndWait();

    }
}
