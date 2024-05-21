/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import static com.mycompany.mavenproject1.NewuserController.listaGenero;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author DVerd
 */
public class NewmedController implements Initializable {
    
           @FXML
    private ComboBox comboAdmin;
           
                                           static ObservableList<String> listaAdmin =  FXCollections.observableArrayList();
                                           
                                           


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         listaAdmin.add("Oral");
                listaAdmin.add("IV");
        listaAdmin.add("sc");
        
        comboAdmin.setItems(listaAdmin);
    }    
    
}
