package com.mycompany.practicafinal;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
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
    private TextField equipo;
    @FXML
    private TextField posicion;
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
    private void guardarJugador() throws SQLException{
        
        Jugador jugador = new Jugador(nombre.getText(), apellidos.getText(),equipo.getText(),posicion.getText(),Integer.valueOf(edad.getText()),url);
        JdbcDao.insertRecord(jugador);
       
        PrimaryController.valoresLista.add(jugador);
        Stage stage = (Stage) añadirImagen.getScene().getWindow();
        stage.close();
      
    }
    
    
    
    
    
    

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}