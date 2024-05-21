package com.mycompany.mavenproject1;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.mycompany.mavenproject1.utils.JsonUtils;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

public class MainViewController {
    
    @FXML
    private TableView<Usuario> tViewUsuarios = new TableView<>();
    ;
    //Columnas
    @FXML
    private TableColumn<Usuario, String> columnNombre;
    
     @FXML
    private TableColumn<Usuario, String> columnApellidos;
     
      @FXML
    private TableColumn<Usuario, String> columnEdad;
      
        @FXML
    private TableColumn<Usuario, String> columnGenero;
        
         @FXML
    private TableColumn<Usuario, String> columnIngreso;
    
    
    
    @FXML
    private Label labelEdad;
    
    @FXML
    private ChoiceBox comboCentros;
    
     //ObservableList
    static ObservableList<Usuario> valoresLista = FXCollections.observableArrayList();
    
    static ObservableList<String> listaCentros =  FXCollections.observableArrayList();
    
    
    
    //Property
    private Property<ObservableList<Usuario>> usuarioListProperty = new SimpleObjectProperty<>(valoresLista);
    
    public void initialize() throws IOException, UnirestException, ParseException{
        
        listaCentros.add("RESIDENCIA MIRAMAR");
        
        comboCentros.setItems(listaCentros);
       
        
        requestUserList();

        this.columnNombre.setCellValueFactory(new PropertyValueFactory("NOMBRE_USUARIO"));
        this.columnApellidos.setCellValueFactory(new PropertyValueFactory("APELLIDOS_USUARIO"));
        this.columnGenero.setCellValueFactory(new PropertyValueFactory("GENERO_USUARIO"));
        this.columnEdad.setCellValueFactory(new PropertyValueFactory("EDAD"));
        this.columnIngreso.setCellValueFactory(new PropertyValueFactory("ALTA_USUARIO"));
        


        this.tViewUsuarios.setItems(valoresLista);
        //Binding: valoresLista - formulario (TableView)
        tViewUsuarios.itemsProperty().bind(usuarioListProperty);
        
                
               

        
        
    }
    
    @FXML
    private void switchToNewUser() throws IOException {
        
        App.setRoot("newuser");
    }
    
     @FXML
    private void switchToNewCenter() throws IOException {
        
        App.setRoot("newcenter");
    }
    
     @FXML
    private void verDetalles() throws IOException {
        
        App.setRoot("userdetail");
    }
    
    
    public void requestUserList() throws IOException, UnirestException, ParseException{
        
        List<Usuario> listaUsuario =  JsonUtils.parseUsuarios(        APIConnector.getMethod("http://localhost:33333/usuarios/usuario?columns=ID_USUARIO%2CFOTO_USUARIO%2CNOMBRE_USUARIO%2CAPELLIDOS_USUARIO%2CFECHA_NACIMIENTO%2CGENERO_USUARIO%2CDEPENDENCIA_USUARIO%2CALTA_USUARIO%2CBAJA_USUARIO"));
        for(Usuario u : listaUsuario){
            valoresLista.add(u);
        }
    }
    
    @FXML
    public void detalleUsuario() {

        //índice seleccionado
        int index = tViewUsuarios.getSelectionModel().getSelectedIndex();
        //índice válido (elegido)
        if (index != -1) {
            Usuario c = (Usuario) tViewUsuarios.getItems().get(index);
            //crea objeto Image
            //Image i = new Image(c.getFOTO_USUARIO());
            //setea en ImgView
            //img.setImage(i);
            //Descripción jugador bajo imagen
            labelEdad.setText(c.getNOMBRE_USUARIO()+" "+c.getAPELLIDOS_USUARIO()+"\n"+c.getEDAD()+" años");
            //img.setVisible(true);

        }

    }
    
   
    
    
    
}