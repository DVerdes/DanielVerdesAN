/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author FP
 */
public class VentanaEditar {
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
    
    static Jugador jugador;
    
    static int indexLista;
    
    final FileChooser f = new FileChooser();
    @FXML
     ImageView mv = new ImageView(); // create empty ImageView
    
    String url="";
 
    
       public void initialize()  {
           //jugador = new Jugador("pepe","sanchez","deportivo","c",34,"sdgfd");
           
    }
    
    
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
    private void editarJugador() throws SQLException{
        
        jugador.setNombre(nombre.getText());
        jugador.setApellido(apellidos.getText());
        jugador.setEquipo(equipo.getText());
        jugador.setPosicion(posicion.getText());
        jugador.setEdad(Integer.valueOf(edad.getText()));
        jugador.setImgURL(url);
        
        
        
        JdbcDao.updateRecord(jugador);
        PrimaryController.valoresLista.set(indexLista, jugador);
       
        Stage stage = (Stage) añadirImagen.getScene().getWindow();
        stage.close();
      
    }
    
    
    
    
    
    

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    public void setJugador(Jugador jugadorU, int index) {
        this.jugador = jugadorU;
        indexLista = index;
        
         nombre.setText(jugador.getNombre());
           apellidos.setText(jugador.getApellido());
           equipo.setText(jugador.getEquipo());
           posicion.setText(jugador.getPosicion());
           edad.setText(String.valueOf(jugador.getEdad()));
           url = jugador.getImgURL();
                        Image img = new Image(url);

           mv.setImage(img);
           
                      System.out.println(jugador);

    
    }

  
}
