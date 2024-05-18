/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.mashape.unirest.http.exceptions.UnirestException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author DVerd
 */
public class NewcenterController implements Initializable {
    
    @FXML
    private TextField centroNombre;
    
    @FXML
    private TextField centroDireccion;
    
    @FXML
    private TextField individualHab;
    
    @FXML
    private TextField dobleHab;
    
    @FXML
    private TextField tripleHab;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void insertarCentro() throws UnirestException{
        String url = "http://localhost:33333/centros/centro";
        String body = "{\r\n    \"data\": \r\n        {\r\n                        \"ID_GESTOR\": \"demo\",\r\n                                    \"DIR_CENTRO\": \""+centroDireccion.getText()+"\",\r\n\r\n   \"HAB_INDIV\": \""+individualHab.getText()+"\",\r\n\r\n    \"HAB_DOBLE\": \""+tripleHab.getText()+"\",\r\n\r\n   \"HAB_TRIPLE\": \""+dobleHab.getText()+"\",\r\n\r\n  \"NOMBRE_CENTRO\": \""+centroNombre.getText()+"\"\r\n            \r\n        }\r\n}";
        APIConnector.postMethod(url, body);
    }
    
}
