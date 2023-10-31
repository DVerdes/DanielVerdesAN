/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

/**
 *
 * @author FP
 */
public class PrimaryController {

    @FXML
    private ChoiceBox listaDesplegable;

    @FXML
    private Label labelListaDesplegable;

    @FXML
    private Button botonEnviar;

    ObservableList<String> valoresLista = FXCollections.observableArrayList("Azul", " Rojo", "Verde");

    private void setListaDesplegable() {
        listaDesplegable.setItems(valoresLista);
    }
    
    public void initialize(){
        setListaDesplegable();
    }
    

}

