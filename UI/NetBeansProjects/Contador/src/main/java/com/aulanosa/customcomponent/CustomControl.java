/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.aulanosa.customcomponent;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class de Contador
 *
 * @author Dverd
 */
public class CustomControl extends VBox {

    @FXML
    private TextField contador;

    public CustomControl() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customControl.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public TextField getContador() {
        return contador;
    }

    public void setContador(TextField contador) {
        this.contador = contador;
    }

    /**
     * Decremento contador
     */
    @FXML
    protected void startContador() {
        var valor = Integer.parseInt(contador.getText()) - 1;
        contador.setText(Integer.toString(valor));
    }
}
