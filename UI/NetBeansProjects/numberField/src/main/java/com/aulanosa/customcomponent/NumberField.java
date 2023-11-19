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
import org.apache.commons.validator.routines.IntegerValidator;

/**
 * FXML Controller class
 *
 */
public class NumberField extends VBox {

    @FXML
    private TextField textField;

    @FXML
    private Label errorLabel;

    public NumberField() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("numberControl.fxml"));
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
    public boolean validateAge() {

        IntegerValidator vr = IntegerValidator.getInstance();

        if (!vr.isValid(textField.getText())) {
            errorLabel.setText("Valor incorrecto");
            return false;

        } else {
            if (Integer.parseInt(textField.getText()) < 18) {
                errorLabel.setText("Debe ser >18");
                return false;
            } else {
                errorLabel.setText("");
                return true;

            }
        }

    }
}
