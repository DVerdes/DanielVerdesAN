/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.mashape.unirest.http.exceptions.UnirestException;
import static com.mycompany.mavenproject1.MainViewController.centroActivo;
import static com.mycompany.mavenproject1.MainViewController.valoresLista;
import static com.mycompany.mavenproject1.NewuserController.valoresListaContacto;
import com.mycompany.mavenproject1.utils.JsonUtils;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
          
          @FXML
    private TableView<Contacto> tViewContactos = new TableView<>();
    
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
        private TextField tfContactoNombre;
        @FXML
        private TextField tfContactoApellidos;
        
        @FXML
        private TextField tfContactoTelefono;
        
        @FXML
        private TextField tfContactoEmail;
        
         static ObservableList<Contacto> valoresListaContacto = FXCollections.observableArrayList();
         
             private Property<ObservableList<Contacto>> contactoListProperty = new SimpleObjectProperty<>(valoresListaContacto);

          
          
          
          static Usuario usuario_static;
          
           public static ObservableList<String> desayunoItems;
    public static ObservableList<String> comidaItems;
    public static ObservableList<String> cenaItems;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       this.columnNombre.setCellValueFactory(new PropertyValueFactory("NOMBRE_CONTACTO"));
        this.columnApellidos.setCellValueFactory(new PropertyValueFactory("APELL_CONTACTO"));
        this.columnTelf.setCellValueFactory(new PropertyValueFactory("TELF_CONTACTO"));
        this.columnEmail.setCellValueFactory(new PropertyValueFactory("EMAIL_CONTACTO"));
        


        this.tViewContactos.setItems(valoresListaContacto);
        //Binding: valoresLista - formulario (TableView)
        tViewContactos.itemsProperty().bind(contactoListProperty);
        
         desayunoItems = FXCollections.observableArrayList();
        comidaItems = FXCollections.observableArrayList();
        cenaItems = FXCollections.observableArrayList();
        
        desayunoList.setItems(desayunoItems);
        comidaList.setItems(comidaItems);
        cenaList.setItems(cenaItems);
        
       


    }    
    
     @FXML
    private void insertarPauta() throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("newmed.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 277, 415);
            Stage stage = new Stage();

            NewmedController controlador = fxmlLoader.getController();
        stage.getIcons().add(new Image("file:C:\\Users\\DVerd\\Documents\\GitHub\\DanielVerdesAN\\backEnd\\mavenproject1\\src\\main\\resources\\imgs\\favicon.png"));

           
            stage.setTitle("Nueva Pauta");
            stage.setScene(scene);
            stage.show();
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
        
        
       Image img = new Image(usuario.getFOTO_USUARIO());
       imageUsuario.setImage(img);
        
        
        System.out.println(usuario.toString());
        
        searchHabitacionYCama();
        UserdetailController.valoresListaContacto.clear();
        searchContactos();

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
    
    @FXML
    public  void searchPautas() throws UnirestException, ParseException{
        
        desayunoList.getItems().clear();
        comidaList.getItems().clear();
        cenaList.getItems().clear();

        
        int usuarioId = usuario_static.getID_USUARIO();
         String url = "http://localhost:33333/pautas/pauta/search";
        String body = "{\n" +
"    \"columns\" : [\"NOMBRE_FARMACO\",\"VIA_ADMINISTRACION\",\"DOSIS\",\"POSOLOGIA\"],\n" +
"    \"filter\" : {\n" +
"        \"ID_USUARIO\" : "+usuarioId+"\n" +
"    }\n" +
"}";
        List<Pauta> listaPautas =  JsonUtils.parsePauta(APIConnector.postMethod(url, body));
        
        for(Pauta p : listaPautas){
            String posologia = p.getPosologia();
            
            if(posologia.contains("desayuno")){
                desayunoItems.add(p.toString());
            }
            if(posologia.contains("comida")){
                comidaItems.add(p.toString());
            }
            if(posologia.contains("cena")){
                cenaItems.add(p.toString());
            }
            
            
        }
        
        
        
    }
    
     @FXML
    private void removePauta() throws IOException {
         int indexDno = desayunoList.getSelectionModel().getSelectedIndex();
        if (indexDno != -1) {
            
            desayunoList.getItems().remove(indexDno);
        }
        
        int indexCda = comidaList.getSelectionModel().getSelectedIndex();
        if (indexCda != -1) {
            
            comidaList.getItems().remove(indexDno);
        }
        int indexCna = cenaList.getSelectionModel().getSelectedIndex();
        if (indexCna != -1) {
            
            cenaList.getItems().remove(indexDno);
        }
        
        
    }
    
    @FXML
    private void anadirContacto() throws UnirestException, ParseException{
                int usuarioId = usuario_static.getID_USUARIO();

        Contacto c = new Contacto();
        c.setNOMBRE_CONTACTO(tfContactoNombre.getText());
        c.setAPELL_CONTACTO(tfContactoApellidos.getText());
        c.setTELF_CONTACTO(tfContactoTelefono.getText());
        c.setEMAIL_CONTACTO(tfContactoEmail.getText());
        
        valoresListaContacto.add(c);
        
         String urlEndpoint = "http://localhost:33333/contactos/contacto";
        String urlCU = "http://localhost:33333/usuarioContactos/usuarioContacto";

        
            String body = "{\r\n    \"data\": \r\n        {\r\n                        \"NOMBRE_CONTACTO\": \""+c.getNOMBRE_CONTACTO()+"\",\r\n                                    \"APELLIDOS_CONTACTO\": \""+c.getAPELL_CONTACTO()+"\",\r\n\r\n   \"TELF_CONTACTO\": \""+c.getTELF_CONTACTO()+"\",\r\n\r\n  \"EMAIL_CONTACTO\": \""+c.getEMAIL_CONTACTO()+"\"\r\n            \r\n        }\r\n}";
            int idContacto =  JsonUtils.returnInsertedContactoId(APIConnector.postMethod(urlEndpoint, body));
            
            
            String bodyCU = "{\r\n    \"data\": \r\n        {\r\n                        \"ID_USUARIO\": \""+usuarioId+"\",\r\n\r\n  \"ID_CONTACTO\": \""+idContacto+"\"\r\n            \r\n        }\r\n}";
            APIConnector.postMethod(urlCU, bodyCU);
            
        tfContactoNombre.clear();
        tfContactoApellidos.clear();
        tfContactoTelefono.clear();
        tfContactoEmail.clear();
        
    }
    
    @FXML
    private void quitarContacto(){
        
        
    }
    
     private void searchContactos() throws UnirestException, ParseException{
        int usuarioId = usuario_static.getID_USUARIO();
        String url = "http://localhost:33333/contactos/contactosUsuario/search";
        String body = "{\n" +
"    \"columns\" : [\"NOMBRE_CONTACTO\",\"APELLIDOS_CONTACTO\",\"TELF_CONTACTO\",\"EMAIL_CONTACTO\"],\n" +
"    \"filter\" : {\n" +
"        \"UC.ID_USUARIO\" : "+usuarioId+"\n" +
"    }\n" +
"}";
        List<Contacto> listaC =  JsonUtils.parseContacto(APIConnector.postMethod(url, body));
        for(Contacto c: listaC){
            valoresListaContacto.add(c);
        }
        
        
    }
    
    
    
    
    
    
    
}
