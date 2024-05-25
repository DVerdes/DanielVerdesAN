/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.mashape.unirest.http.exceptions.UnirestException;
import static com.mycompany.mavenproject1.MainViewController.centroActivo;
import static com.mycompany.mavenproject1.MainViewController.valoresLista;
import com.mycompany.mavenproject1.utils.JsonUtils;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author DVerd
 */
public class UserdetailController implements Initializable {
    
    @FXML
    private ListView desayunoList = new ListView();;
    
       @FXML
    private ListView comidaList = new ListView();;
       
          @FXML
    private ListView cenaList = new ListView();;
          
          
          @FXML
          private Label labelNacimiento;
          
          @FXML
          private Label labelGenero;
          
          @FXML
          private Label labelDependencia;
          
          @FXML
          private Label labelIngreso;
          
          @FXML
          private Label labelHabitacion;
          
          @FXML
          private Label labelNombre;
          
          @FXML
          private Label labelApellidos;
          
          @FXML
          private Label labelCentro;
          
          @FXML
          private ImageView imageUsuario;
          
          
          
          static Usuario usuario_static;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     
        
        desayunoList.getItems().add("Paracetamol oral 1g");
        desayunoList.getItems().add("Atorvastatina 20mg");
        desayunoList.getItems().add("Atenolol 50mg");
                desayunoList.getItems().add("Clexane 40 sc");

                comidaList.getItems().add("Adiro 100mg");
                cenaList.getItems().add("Paracetamol oral 1g");
                cenaList.getItems().add("Levofloxacino 500mg");


    }    
    
     @FXML
    private void insertarPauta() throws IOException {
        
        App.setRoot("newmed");
    }
    
    public void setUsuario(Usuario usuario, String nombreCentro) throws UnirestException, ParseException {
        this.usuario_static = new Usuario();
        this.usuario_static.setID_USUARIO(usuario.getID_USUARIO());
        
        
        labelNacimiento.setText(usuario.getFECHA_NACIMIENTO().toString());
        labelGenero.setText(usuario.getGENERO_USUARIO());
        labelIngreso.setText(usuario.getALTA_USUARIO().toString());
        labelDependencia.setText(usuario.getDEPENDENCIA_USUARIO());
        labelNombre.setText(usuario.getNOMBRE_USUARIO());
        labelApellidos.setText(usuario.getAPELLIDOS_USUARIO());
        if(usuario.getGENERO_USUARIO().equals("Mujer")){
            labelCentro.setText("Usuaria de "+nombreCentro);
        }else{
            labelCentro.setText("Usuario de "+nombreCentro);

        }
        
        
       // Image img = new Image(usuario.getFOTO_USUARIO());
       // imageUsuario.setImage(img);
        
        
        System.out.println(usuario.toString());
        
        searchHabitacionYCama();

    }
    
    private void searchHabitacionYCama() throws UnirestException, ParseException{
        int usuarioId = usuario_static.getID_USUARIO();
        String url = "http://localhost:33333/usuarios/usuarioCama/search";
        String body = "{\n" +
"    \"columns\" : [\"HT.NOM_HABITACION\",\"C.NOMBRE_CAMA\",\"U.APELLIDOS_USUARIO\",\"U.FECHA_NACIMIENTO\",\"U.GENERO_USUARIO\",\"U.DEPENDENCIA_USUARIO\",\"U.FOTO_USUARIO\",\"U.ALTA_USUARIO\"],\n" +
"    \"filter\" : {\n" +
"        \"U.ID_USUARIO\" : "+usuarioId+"\n" +
"    }\n" +
"}";
        List<String> listaCamas =  JsonUtils.parseHabitacionCama(APIConnector.postMethod(url, body));
        labelHabitacion.setText(listaCamas.get(0));
        
        
    }
    
    
    
}
