package com.mycompany.com.aulanosa.paneljuegos;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.IntegerValidator;

/**
 * Clase que contiene controlador del menú principal
 *
 * @author DVerd
 */
public class PrimaryController {

    //Componentes interfaz
    //botón jugar
    @FXML
    private Button bJugar;

    //botón menú reservas
    @FXML
    private Button bReservar;

    //textField nombre jugador
    @FXML
    private TextField tfJugador;

    //textField email jugador
    @FXML
    private TextField tfEmail;

    //textField edad jugador
    @FXML
    private TextField tfEdad;

    @FXML
    private Label labelValName;

    @FXML
    private Label labelValMail;

    @FXML
    private Label labelValAge;
    
    @FXML 
    private Label labelPanel;

    /**
     * Método para cambiar a pantalla de juego (secondary)
     *
     * @param event evento de botón
     * @throws IOException
     */
    
    
    public void initialize(){
        labelPanel.setStyle("-fx-text-fill:red");
    }
    
    
    @FXML
    private void switchToSecondary(ActionEvent event) throws IOException {

        
        if(tryForm()){
            
             Scene scene = bJugar.getScene();

        if (scene != null) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
            
        }
        
       
    }

    /**
     * Método para cambiar a ventana de reservas (Tertiary)
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void switchToTerciary(ActionEvent event) throws IOException {
        
        if(tryForm()){
            
            Scene scene = bReservar.getScene();

        if (scene != null) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("terciary.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            //mediante controlador se pasan datos de nombre y email del jugador
            TercController controlador = loader.getController();
            controlador.setUser(tfJugador.getText());
            controlador.setEmail(tfEmail.getText());
        }
            
            
            
        }else{
            
           System.out.println("Validación incompleta");
        }

        
    }
    
    public boolean validateAge(){
        
        IntegerValidator vr = IntegerValidator.getInstance();
        
        if(!vr.isValid(tfEdad.getText())){
                 labelValAge.setText("Introduce un valor válido");
                                  labelValAge.setStyle("fx-text-fill:red");
                                  return false;


        }else{
            if(Integer.parseInt(tfEdad.getText())<18){
                labelValAge.setText("Es necesario ser mayor de edad");
                return false;
            }else{
                            labelValAge.setText("");
                            return true;

            }
        }
    
    }
    
    public boolean validateEmail(){
        
        EmailValidator ev = EmailValidator.getInstance();
        
        if(!ev.isValid(tfEmail.getText())){
            labelValMail.setText("Introduce una dirección válida");
            return false;
        }else{
                                        labelValMail.setText("");
                                        return true;

        }
        
        
        
    }
    
    
    public boolean validateName(){
        if(tfJugador.getText().isEmpty()){
            labelValName.setText("Introduzca un nombre");
            return false;
        }else{
            return true;
        }
    }
    
    public boolean tryForm(){
        if(validateName() && validateEmail() && validateAge()){
            return true;
        }else{
            return false;
        }
    }
}
