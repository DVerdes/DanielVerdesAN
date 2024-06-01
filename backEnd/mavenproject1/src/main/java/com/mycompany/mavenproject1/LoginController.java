package com.mycompany.mavenproject1;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import static com.mycompany.mavenproject1.MainViewController.centroActivo;
import static com.mycompany.mavenproject1.MainViewController.valoresLista;
import com.mycompany.mavenproject1.utils.JsonUtils;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;





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

    @FXML
    private void switchToSecondary() throws IOException, UnirestException {
        
        
        
           
        String url = "http://localhost:33333/gestores/gestor/search";
        String body = "{\r\n    \"columns\" : [\"ID_PROFESIONAL\"],\r\n    \"filter\" : {\r\n        \"NOMBRE_PROFESIONAL\" : \""+tfUsuario.getText()+"\",\r\n        \"CONTRASENA\": \""+tfPass.getText()+"\"             \r\n    }\r\n}";
        Boolean validLoginGestor =  JsonUtils.login(APIConnector.postMethod(url, body));
        
         String urlS = "http://localhost:33333/sanitarios/sanitario/search";
        String bodyS = "{\r\n    \"columns\" : [\"ID_PROFESIONAL\"],\r\n    \"filter\" : {\r\n        \"NOMBRE_PROFESIONAL\" : \""+tfUsuario.getText()+"\",\r\n        \"CONTRASENA\": \""+tfPass.getText()+"\"             \r\n    }\r\n}";
        Boolean validLoginSanitario =  JsonUtils.login(APIConnector.postMethod(urlS, bodyS));
        
        
        if(validLoginGestor || validLoginSanitario){
            primaryButton.getScene().getWindow().setWidth(940);
                primaryButton.getScene().getWindow().setHeight(600);

                usuario = tfUsuario.getText();
        

        
        App.setRoot("main");
            
        }else{
            
            labelVal.setText("Usuario/contraseña incorrecto");
        }
        
        
        
        
        
        
        
        
        
    }
    
   

     @FXML
    private void cambiarRegistro() throws IOException {
        App.setRoot("register");
    }
    
}
