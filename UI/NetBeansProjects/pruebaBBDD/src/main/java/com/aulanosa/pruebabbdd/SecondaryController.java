package com.aulanosa.pruebabbdd;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SecondaryController {

     @FXML
    private Button select;
     
     @FXML
     private TextField tfMail;
     
     @FXML
     private Label mostrarNombre;
    
    String resultado = "";
    

    @FXML
    private void switchToPrimary() throws IOException {
        System.out.println("sdfgsdg");

        try{
            JbdcDao jbdcdao = new JbdcDao();
                        System.out.println(tfMail.getText());

            resultado = jbdcdao.selectRecord(tfMail.getText());
            System.out.println(resultado);
            mostrarNombre.setText(resultado);
            
        }catch(SQLException e){
            
        }
    }
    
    @FXML
     public void acConsultar(){
                                 System.out.println("sdfgsdg");

        try{
            JbdcDao jbdcdao = new JbdcDao();
                        System.out.println(tfMail.getText());

            resultado = jbdcdao.selectRecord(tfMail.getText());
            System.out.println(resultado);
            mostrarNombre.setText(resultado);
            
        }catch(SQLException e){
            
        }
        
    }
}