package com.aulanosa.pruebabbdd;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField tf1;
    
    
      @FXML
    private TextField tf2;
      
    @FXML
    private Button registrar;
    
        @FXML
    private Button ir;
    
    @FXML
    public void acRegistrar(ActionEvent event){
        try{
            JbdcDao jbdcdao = new JbdcDao();
            jbdcdao.insertRecord(tf1.getText(), tf2.getText());
            
        }catch(SQLException e){
            
        }
        
    }
    
    @FXML
     private void ir() throws IOException {
        App.setRoot("secondary");
    }
    
    
}
