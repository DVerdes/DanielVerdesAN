/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * Controlador de Registro
 *
 * @author DVerd
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfUsuario;
    @FXML
    private TextField tfPass1;
    @FXML
    private TextField tfPass2;

    @FXML
    private RadioButton radioSanitario;

    @FXML
    private RadioButton radioGestor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Vuelve a vista de Login
     * @throws IOException 
     */
    @FXML
    private void volverLogin() throws IOException {
        App.setRoot("login");
    }

    /**
     * Registra nuevo usuario Gestor o Sanitario
     * @throws IOException
     * @throws UnirestException 
     */
    @FXML
    private void confirmarRegistro() throws IOException, UnirestException {

        if (validarContrasena(tfPass1.getText()) && compararContrasena(tfPass1.getText(), tfPass2.getText())) {

            if (radioGestor.isSelected()) {

                String urlEndpoint = "http://localhost:33333/gestores/gestor";
                String body = "{\r\n    \"data\": \r\n        {\r\n                                                         \"NOMBRE_PROFESIONAL\": \"" + tfUsuario.getText() + "\",\r\n\r\n  \"CONTRASENA\": \"" + tfPass1.getText() + "\"\r\n            \r\n        }\r\n}";
                APIConnector.postMethod(urlEndpoint, body);

            } else {

                String urlEndpoint = "http://localhost:33333/sanitarios/sanitario";
                String body = "{\r\n    \"data\": \r\n        {\r\n                                                         \"NOMBRE_PROFESIONAL\": \"" + tfUsuario.getText() + "\",\r\n\r\n  \"CONTRASENA\": \"" + tfPass1.getText() + "\"\r\n            \r\n        }\r\n}";
                APIConnector.postMethod(urlEndpoint, body);

            }

            App.setRoot("login");

        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Contraseña no válida");
            alert.setHeaderText("Error en contraseña");
            alert.setContentText("Comprueba la contraseña introducida");
            alert.showAndWait();

        }

    }

    /**
     * Valida formato valido de Contraseña
     * @param password contraseña introducida en el primer TF
     * @return booleano si cumple o no condiciones
     */
    public static boolean validarContrasena(String password) {
        if (password.length() < 6) {
            return false;
        }
        Pattern uppercasePattern = Pattern.compile("[A-Z]");
        Matcher uppercaseMatcher = uppercasePattern.matcher(password);
        if (!uppercaseMatcher.find()) {
            return false;
        }
        Pattern digitPattern = Pattern.compile("[0-9]");
        Matcher digitMatcher = digitPattern.matcher(password);
        if (!digitMatcher.find()) {
            return false;
        }
        return true;
    }

    /**
     * Compara las contraseñas de los dos campos 
     * @param pass1 tf1
     * @param pass2 tf2
     * @return booleano si cumple o no condiciones
     */
    public static boolean compararContrasena(String pass1, String pass2) {
        if (pass1 == null && pass2 == null) {
            return true;
        } else if (pass1 == null || pass2 == null) {
            return false;
        }
        return pass1.equalsIgnoreCase(pass2);
    }
}
