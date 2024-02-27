package com.mycompany.repasobinding;

import java.io.IOException;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {
    
    @FXML 
    public Button boton ;
    @FXML
    public CheckBox cb ;
    @FXML
    public Label labelAp;
    @FXML 
    public TextField tf ;
     @FXML 
    public TextField tf2 ;
    

    public void initialize(){
        
        boton.visibleProperty().bind(cb.selectedProperty());
        //este seria para hacerlo que funcione al reves
        // boton.visibleProperty().bind(Bindings.when(cb.selectedProperty()).then(false).otherwise(true));
        
        
        //otra forma de hacerlo definiendo una condicion y aplicandola al property
        
       // ObservableBooleanValue  cond = new SimpleBooleanProperty(false);
        //boton.visibleProperty().bind(cb.selectedProperty().isEqualTo(cond));
        
        
        // podemos añadir cosas a los property en caso de que no sean directo(bool - bool) , como en este caso 
        //con el isEmpty hacemos bool la propiedad de text
        labelAp.visibleProperty().bind(tf.textProperty().isNotEmpty());
        tf2.visibleProperty().bind(tf.textProperty().isNotEmpty());
    }
    

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
