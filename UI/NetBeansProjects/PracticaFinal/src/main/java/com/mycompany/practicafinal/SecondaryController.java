package com.mycompany.practicafinal;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SecondaryController {
    
    @FXML
    private Button añadirImagen;
    @FXML
    private Button guardar;
    @FXML
    private Button refresh;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField edad;
    
    final FileChooser f = new FileChooser();
    @FXML
     ImageView mv = new ImageView(); // create empty ImageView
    
    String url="";
 
    @FXML
    private void seleccionimg(){
        
        
         añadirImagen.setOnAction((event) -> {
         File file = f.showOpenDialog(new Window() {
         });
         if (file != null) {
             url=file.toURI().toString();// only proceed, if file was chosen
             Image img = new Image(file.toURI().toString());
             mv.setImage(img);
             
             
         }

        });
    }
    
       @FXML
    private void guardarContacto(){
        
        Contacto contacto = new Contacto(nombre.getText(), apellidos.getText(), Integer.valueOf(edad.getText()),url);
       
        PrimaryController.valoresLista.add(contacto);
        Stage stage = (Stage) añadirImagen.getScene().getWindow();
        stage.close();
      
    }
    
    
    
    
    
    

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}