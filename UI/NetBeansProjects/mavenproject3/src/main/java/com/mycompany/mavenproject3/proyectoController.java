/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author FP
 */
public class proyectoController {

    @FXML
    private ChoiceBox listaDesplegable;
    
    @FXML
    private Label labelGanador;
    
    @FXML
    private Label elecCPU;
    
    @FXML
    private Label labelPuntosJugador;
    
    @FXML
    private Label labelPuntosCPU;

    @FXML
    private Label labelListaDesplegable;

    @FXML
    private Button botonEnviar;
    
   

    ObservableList <String> valoresLista = FXCollections.observableArrayList("Piedra","Papel","Tijera");
    
    int contadorJugador = 0;
    int contadorCPU = 0;
    
    boolean finPartida = false;
    

    private void setListaDesplegable() {
        listaDesplegable.setItems(valoresLista);
    }
    
   
    
    public void initialize(){
        setListaDesplegable();
    }
    
    public void accButton() throws IOException{
        
        
        String eleccionCPU = randomElection();
        elecCPU.setText(eleccionCPU);
        
        if(victJugador(eleccionCPU)==0){
            contadorJugador++;
        }else if(victJugador(eleccionCPU)==1){
            contadorCPU++;
        }else{
            
        }
        
        labelPuntosJugador.setText("Puntos: "+contadorJugador);
        labelPuntosCPU.setText("Puntos: "+contadorCPU);
        
        comprobarVictoria();
        
        listaDesplegable.setValue(null);
        
        
        
        
        
        
    }
    
    public String randomElection(){
      int random = (int)Math.floor(Math.random()*(3-1+1)+1);
      if(random==1){
          return "Piedra";
      }else if(random==2){
          return "Papel";
      }else{
          return "Tijera";
      }
    }
      
      public int victJugador(String elecCPU){
          String elecJugador = listaDesplegable.getValue().toString();
          
          if(elecJugador.equals("Piedra")){
              switch (elecCPU) {
                  case "Piedra":
                      return 2;
                  case "Papel":
                      return 1;
                  default:
                      return 0;
              }
          }else if(elecJugador.equals("Papel")){
               switch (elecCPU) {
                  case "Piedra":
                      return 0;
                  case "Papel":
                      return 2;
                  default:
                      return 1;
              }              
              
          }else{
               switch (elecCPU) {
                  case "Piedra":
                      return 1;
                  case "Papel":
                      return 0;
                  default:
                      return 2;
              }              
          }
 
      }
    
    
    
    public void comprobarVictoria(){
        if(contadorJugador==5){
            labelGanador.setText("GANA EL JUGADOR!");
            resetVariables();
        }else if(contadorCPU==5){
            labelGanador.setText("GANA LA CPU!");
            resetVariables();
        }else{
            
        }
    }
    
    public void resetVariables(){
        contadorJugador = 0;
        contadorCPU = 0;
        labelPuntosJugador.setText("Puntos: "+contadorJugador);
        labelPuntosCPU.setText("Puntos: "+contadorCPU);
        botonEnviar.setText("Volver");
        finPartida = true;
    }

    public void cambiarVentana(javafx.event.ActionEvent event) throws IOException{
        
            Parent blah = FXMLLoader.load(getClass().getResource("Interface2.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();

    }
    
   

}
