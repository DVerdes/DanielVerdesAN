package com.mycompany.practicafinal;

import java.io.IOException;
import java.util.Observable;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private TableView<Jugador> formulario = new TableView<>();;

    @FXML 
    private TableColumn<Jugador,String> column1;
    @FXML 
    private TableColumn<Jugador,String> column2;
    @FXML 
    private TableColumn<Jugador,String> colunm3;
    @FXML 
    private TableColumn <Jugador,String>colunm4;
    @FXML 
    private TableColumn <Jugador,String>colunm5;
    @FXML
    private ImageView img ;
    @FXML
    private Label datosJugador;
    

    static  ObservableList<Jugador> valoresLista =  FXCollections.observableArrayList();
    private Property<ObservableList<Jugador>> jugadorListProperty = new SimpleObjectProperty<>(valoresLista);
    
    public void initialize() {
        this.column1.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.column2.setCellValueFactory(new PropertyValueFactory("apellido"));
        this.colunm3.setCellValueFactory(new PropertyValueFactory("equipo"));
        this.colunm4.setCellValueFactory(new PropertyValueFactory("posicion"));
        this.colunm5.setCellValueFactory(new PropertyValueFactory("edad"));
        this.formulario.setItems(valoresLista); 
        formulario.itemsProperty().bind(jugadorListProperty); 
    
    }

   
    @FXML
    private void añadirAlgo() throws IOException{
            
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("secondary.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 476, 652);
        Stage stage = new Stage();
        stage.setTitle("Nuevo jugador");
        stage.setScene(scene);
        stage.show();
   
        
    }
    
   
    
    @FXML
    public void clickImagen() {
        
      
       int index = formulario.getSelectionModel().getSelectedIndex(); 
       if(index!=-1){
             Jugador c = (Jugador) formulario.getItems().get( index);
       Image i = new Image(c.getImgURL());
       img.setImage(i);
       datosJugador.setText(c.getNombre()+" "+c.getApellido()+" - "+c.getPosicion()+"\n"+c.getEquipo()+"\n"+c.getEdad()+" años");
                     img.setVisible(true);

           
       }
     
  
    }
    
    @FXML
    public void borrarJugador(){
        int index = formulario.getSelectionModel().getSelectedIndex();  
         if(index!=-1){
        valoresLista.remove(index);
        datosJugador.setText("");
        img.setVisible(false);
         }
       
    }
    
    
    

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    
}
