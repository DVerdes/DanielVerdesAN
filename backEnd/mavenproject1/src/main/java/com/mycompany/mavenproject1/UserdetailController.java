/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author DVerd
 */
public class UserdetailController implements Initializable {
    
    @FXML
    private ListView desayunoList = new ListView();;
    
       @FXML
    private ListView comidaList = new ListView();;
       
          @FXML
    private ListView cenaList = new ListView();;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        desayunoList.getItems().add("Paracetamol oral 1g");
        desayunoList.getItems().add("Atorvastatina 20mg");
        desayunoList.getItems().add("Atenolol 50mg");
                desayunoList.getItems().add("Clexane 40 sc");

                comidaList.getItems().add("Adiro 100mg");
                cenaList.getItems().add("Paracetamol oral 1g");
                cenaList.getItems().add("Levofloxacino 500mg");


    }    
    
     @FXML
    private void insertarPauta() throws IOException {
        
        App.setRoot("newmed");
    }
    
}
