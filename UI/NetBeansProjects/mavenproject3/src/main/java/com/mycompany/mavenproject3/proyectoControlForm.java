/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author FP
 */
public class proyectoControlForm {

    @FXML
    private TextField campoParticipantes;
    
    @FXML
    private TextField campoSalas;
    
    @FXML
    private TextField campoHorario;
    
    @FXML
    private Button reservar;
    
    @FXML
    private TableView tView;
    
    @FXML
    private TableColumn column1;
    
    @FXML
    private TableColumn column2;
    
    @FXML
    private TableColumn column3;
    
    String user;
    
    ObservableList<Reserva> valoresLista = FXCollections.observableArrayList();
    
    public void initialize(){
        this.column1.setCellValueFactory((new PropertyValueFactory("participantsNumber")));
        this.column2.setCellValueFactory((new PropertyValueFactory("roomName")));
        this.column3.setCellValueFactory((new PropertyValueFactory("schedule")));

        
    }
    
    public void setUser(String user){
        this.user = user;
        //this.welcomeMessage.setText("Bienvenido/a"+user);
    }
    
    public void addReserva(ActionEvent event){
        Reserva reserva = new Reserva(campoParticipantes.getText(), campoSalas.getText(), campoHorario.getText());
        
        valoresLista.add(reserva);
        
        System.out.println(reserva.getParticipantsNumber());
        
        this.tView.setItems(valoresLista);
    }
    

    
    
    
    
    
   

 
   

}
