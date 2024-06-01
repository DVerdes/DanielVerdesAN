package com.mycompany.mavenproject1;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.mycompany.mavenproject1.utils.JsonUtils;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controlador de Login
 *
 * @author DVerd
 */
public class LoginController {

    @FXML
    private Button primaryButton;

    @FXML
    private TextField tfUsuario;

    @FXML
    private TextField tfPass;

    @FXML
    private Label labelVal;

    static String usuario;

    /**
     * Realiza petición a BackEnd para comprobar creedenciales válidas
     *
     * @throws IOException
     * @throws UnirestException
     */
    @FXML
    private void logearUsuario() throws IOException, UnirestException {

        String url = "http://localhost:33333/gestores/gestor/search";
        String body = "{\r\n    \"columns\" : [\"ID_PROFESIONAL\"],\r\n    \"filter\" : {\r\n        \"NOMBRE_PROFESIONAL\" : \"" + tfUsuario.getText() + "\",\r\n        \"CONTRASENA\": \"" + tfPass.getText() + "\"             \r\n    }\r\n}";
        Boolean validLoginGestor = JsonUtils.login(APIConnector.postMethod(url, body));

        String urlS = "http://localhost:33333/sanitarios/sanitario/search";
        String bodyS = "{\r\n    \"columns\" : [\"ID_PROFESIONAL\"],\r\n    \"filter\" : {\r\n        \"NOMBRE_PROFESIONAL\" : \"" + tfUsuario.getText() + "\",\r\n        \"CONTRASENA\": \"" + tfPass.getText() + "\"             \r\n    }\r\n}";
        Boolean validLoginSanitario = JsonUtils.login(APIConnector.postMethod(urlS, bodyS));

        if (validLoginGestor || validLoginSanitario) {

            usuario = tfUsuario.getText();

            irMain();
        } else {

            labelVal.setText("Usuario/contraseña incorrecto");
        }

    }

    /**
     * Dirige a Main
     * @throws IOException 
     */
    private void irMain() throws IOException {
        primaryButton.getScene().getWindow().setWidth(940);
        primaryButton.getScene().getWindow().setHeight(600);

        usuario = tfUsuario.getText();

        App.setRoot("main");

    }

    /**
     * Cambia a vista de registro
     * @throws IOException 
     */
    @FXML
    private void cambiarRegistro() throws IOException {
        App.setRoot("register");
    }

}
