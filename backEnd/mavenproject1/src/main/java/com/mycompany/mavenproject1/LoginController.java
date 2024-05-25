package com.mycompany.mavenproject1;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mycompany.mavenproject1.utils.JsonUtils;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;





public class LoginController {
    
    @FXML
    private Button primaryButton;
    
    

    @FXML
    private void switchToSecondary() throws IOException {
        primaryButton.getScene().getWindow().setWidth(940);
                primaryButton.getScene().getWindow().setHeight(545);

      
        

        
        App.setRoot("main");
        
    }
    
    @FXML
    private void getData() throws IOException, UnirestException {     
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("http://localhost:33333/farmacos/farmaco?columns=NOMBRE_FARMACO")
                .header("Authorization", "Basic ZGVtbzpkZW1vdXNlcg==")
                .header("Cookie", "JSESSIONID=D10598DB040BC72EFB26AC5AB22C60CD")
                .asString();
            
                       System.out.println(JsonUtils.parseFarmaco(response.getBody()).toString());

    }

     @FXML
    private void cambiarRegistro() throws IOException {
        App.setRoot("register");
    }
    
}
