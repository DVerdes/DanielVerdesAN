/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.aulanosa.customcomponent;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.apache.commons.validator.routines.EmailValidator;

/**
 * FXML Controller class
 *
 */
public class EmailField extends VBox {

    @FXML
    private TextField textField;

    @FXML
    private Label errorLabel;

    public EmailField() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("emailControl.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public TextField getContador() {
        return textField;
    }

    public void setContador(TextField contador) {
        this.textField = contador;
    }

    @FXML
    public boolean validateEmail() {

        EmailValidator ev = EmailValidator.getInstance();

        if (!ev.isValid(textField.getText())) {
            errorLabel.setText("Dirección incorrecta");
            return false;
        } else {
            errorLabel.setText("");
            return true;

        }

    }
}
