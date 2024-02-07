package com.aulanosa.bindingd;

import java.io.IOException;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;





public class PrimaryController {

  @FXML
  private TextField tf1;
  
  
  @FXML
  private TextField tf2;
  
  
  @FXML
  private TextField tf3;
  
  @FXML
  private Label label1;
  
 

  
   public void initialize() {
       
       

       
       
      label1.textProperty().bind(Bindings.concat(tf1.textProperty()," ",tf2.textProperty()," ",tf3.textProperty()));

  
  
  
  
  
   }

 
   
   
}
