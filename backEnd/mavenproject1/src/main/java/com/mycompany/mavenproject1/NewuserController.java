/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import static com.mycompany.mavenproject1.MainViewController.valoresLista;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author DVerd
 */
public class NewuserController implements Initializable {
    
     @FXML
    private TableView<Contacto> tViewContactos = new TableView<>();
    ;
    //Columnas
    @FXML
    private TableColumn<Contacto, String> columnNombre;
    
     @FXML
    private TableColumn<Contacto, String> columnApellidos;
     
      @FXML
    private TableColumn<Contacto, String> columnTelf;
      
        @FXML
    private TableColumn<Contacto, String> columnEmail;
        
        @FXML
    private ComboBox comboHabitacion;
        
         @FXML
    private ComboBox comboCama;
         
          @FXML
    private ChoiceBox comboGenero;
        
    static ObservableList<Contacto> valoresListaContacto = FXCollections.observableArrayList();
    
        static ObservableList<String> listaHabitaciones =  FXCollections.observableArrayList();
        
                static ObservableList<String> listaCamas =  FXCollections.observableArrayList();
                
                                static ObservableList<String> listaGenero =  FXCollections.observableArrayList();



    
    
    
    //Property
    private Property<ObservableList<Contacto>> contactoListProperty = new SimpleObjectProperty<>(valoresListaContacto);
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        listaHabitaciones.add("Doble 12");
        listaCamas.add("A");
        listaCamas.add("B");
        listaGenero.add("Hombre");
                listaGenero.add("Mujer");
        listaGenero.add("Otro");

        
        comboHabitacion.setItems(listaHabitaciones);
        comboCama.setItems(listaCamas);
        comboGenero.setItems(listaGenero);
        
        valoresListaContacto.add(new Contacto("Jesús","Ramirez","62345623","jesusram@gmail.com"));
        
         this.columnNombre.setCellValueFactory(new PropertyValueFactory("NOMBRE_CONTACTO"));
        this.columnApellidos.setCellValueFactory(new PropertyValueFactory("APELL_CONTACTO"));
        this.columnTelf.setCellValueFactory(new PropertyValueFactory("TELF_CONTACTO"));
        this.columnEmail.setCellValueFactory(new PropertyValueFactory("EMAIL_CONTACTO"));
        


        this.tViewContactos.setItems(valoresListaContacto);
        //Binding: valoresLista - formulario (TableView)
        tViewContactos.itemsProperty().bind(contactoListProperty);
        
        // TODO
    }    
    
     @FXML
    private void crearUsuario() throws IOException {
        
       
    }
    
}
