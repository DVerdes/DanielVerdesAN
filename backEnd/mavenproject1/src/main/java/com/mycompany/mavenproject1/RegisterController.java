/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.mycompany.mavenproject1.utils.JsonUtils;
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
 * FXML Controller class
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
    
     @FXML
    private void volverLogin() throws IOException {
        App.setRoot("login");
    }
    
    @FXML
    private void confirmarRegistro() throws IOException, UnirestException {
        
        if(validarContrasena(tfPass1.getText()) && compararContrasena(tfPass1.getText(),tfPass2.getText())){
            
            
            if(radioGestor.isSelected()){
                
                 String urlEndpoint = "http://localhost:33333/gestores/gestor";
        String body = "{\r\n    \"data\": \r\n        {\r\n                                                         \"NOMBRE_PROFESIONAL\": \""+tfUsuario.getText()+"\",\r\n\r\n  \"CONTRASENA\": \""+tfPass1.getText()+"\"\r\n            \r\n        }\r\n}";
        APIConnector.postMethod(urlEndpoint, body);
            
            }else{
                
                 String urlEndpoint = "http://localhost:33333/sanitarios/sanitario";
        String body = "{\r\n    \"data\": \r\n        {\r\n                                                         \"NOMBRE_PROFESIONAL\": \""+tfUsuario.getText()+"\",\r\n\r\n  \"CONTRASENA\": \""+tfPass1.getText()+"\"\r\n            \r\n        }\r\n}";
        APIConnector.postMethod(urlEndpoint, body);
                
                
            }
            
            
            
           
            
           
            
            
                    App.setRoot("login");

        }else{
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Contraseña no válida");
    alert.setHeaderText("Error en contraseña");
    alert.setContentText("Comprueba la contraseña introducida");
            alert.showAndWait();

        }
        
        
    }
    
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
    
    public static boolean compararContrasena(String pass1, String pass2) {
        if (pass1 == null && pass2 == null) {
            return true;
        }
        else if (pass1 == null || pass2 == null) {
            return false;
        }
        return pass1.equalsIgnoreCase(pass2);
    }
}
