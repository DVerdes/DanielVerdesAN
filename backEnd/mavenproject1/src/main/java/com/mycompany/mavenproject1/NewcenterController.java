/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.mashape.unirest.http.exceptions.UnirestException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.apache.commons.validator.routines.IntegerValidator;


/**
 * FXML Controller class
 *
 * @author DVerd
 */
public class NewcenterController implements Initializable {
    
    @FXML
    private TextField centroNombre;
    
    @FXML
    private TextField centroDireccion;
    
    @FXML
    private TextField individualHab;
    
    @FXML
    private TextField dobleHab;
    
    @FXML
    private TextField tripleHab;
    
    @FXML
    private Label validacionHabitaciones;
    
    @FXML
    private Button botonInsertar;
    
     private IntegerProperty number = new SimpleIntegerProperty();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        BooleanBinding numeroValidoBinding = Bindings.createBooleanBinding(
            this::validateAge,
            number
        );
        
        botonInsertar.disableProperty().bind(numeroValidoBinding.not());    
    
        validacionHabitaciones.setText("");
    }    
    
    @FXML
    private void insertarCentro() throws UnirestException{
        if(validateAge()){
            insertMsg();
            String url = "http://localhost:33333/centros/centro";
        String body = "{\r\n    \"data\": \r\n        {\r\n                        \"ID_GESTOR\": \"demo\",\r\n                                    \"DIR_CENTRO\": \""+centroDireccion.getText()+"\",\r\n\r\n   \"HAB_INDIV\": \""+individualHab.getText()+"\",\r\n\r\n    \"HAB_DOBLE\": \""+tripleHab.getText()+"\",\r\n\r\n   \"HAB_TRIPLE\": \""+dobleHab.getText()+"\",\r\n\r\n  \"NOMBRE_CENTRO\": \""+centroNombre.getText()+"\"\r\n            \r\n        }\r\n}";
        APIConnector.postMethod(url, body);
        }
        
    }
    
    /**
     * Valida campo edad
     *
     * @return booleano con validación afirmativa o negativa
     */
    @FXML
    public boolean validateAge() {

        IntegerValidator vr = IntegerValidator.getInstance();

        if (!vr.isValid(individualHab.getText()) || !vr.isValid(dobleHab.getText()) || !vr.isValid(tripleHab.getText())  ) {
            validacionHabitaciones.setText("Introduce un valor numérico válido");
            validacionHabitaciones.setStyle("fx-text-fill:red");
            number.set(0);
            return false;

        } else {
            if (Integer.parseInt(individualHab.getText() + dobleHab.getText() + tripleHab.getText()) < 1) {
                validacionHabitaciones.setText("El centro ha de tener al menos una habitacion");
                            number.set(0);

                return false;
            } else {
                validacionHabitaciones.setText("");
                            number.set(1);

                return true;

            }
        }

    }
    
    public void insertMsg(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Centro insertado");
    alert.setHeaderText("Centro insertado correctamente");
    alert.setContentText("El centro "+centroNombre.getText()+" ha sido insertado correctamente");

alert.showAndWait();
    }
    
}
