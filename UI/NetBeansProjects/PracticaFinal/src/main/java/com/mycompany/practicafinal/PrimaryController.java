package com.mycompany.practicafinal;

import java.io.IOException;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PrimaryController {
    
    private Scene scene;
    private Stage stage;
    
    @FXML
    private Button añadir ;
    @FXML
    private TableView formulario;

    @FXML 
    private TableColumn column1;
    @FXML 
    private TableColumn column2;
    @FXML 
    private TableColumn colunm3;
    @FXML
    private ImageView img ;
    
    static  ObservableList<Contacto> valoresLista =  FXCollections.observableArrayList();
   
    @FXML
    private void añadirAlgo() throws IOException{
            
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("secondary.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("New Window");
        stage.setScene(scene);
        stage.show();
   
        
    }
    
    @FXML
    public void refrescar() {
                  
        this.column1.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.column2.setCellValueFactory(new PropertyValueFactory("apellidos"));
        this.colunm3.setCellValueFactory(new PropertyValueFactory("edad"));
        this.formulario.setItems(valoresLista); 
  
    }
    
    @FXML
    public void clickImagen() {
        
      
       int index = formulario.getSelectionModel().getSelectedIndex();     
       Contacto c = (Contacto) formulario.getItems().get( index);
       Image i = new Image(c.getUrl());
       img.setImage(i);
             
  
    }
    
    
    

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    
}
