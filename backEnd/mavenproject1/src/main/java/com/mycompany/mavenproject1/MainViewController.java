package com.mycompany.mavenproject1;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mycompany.mavenproject1.utils.JsonUtils;
import static com.mycompany.mavenproject1.utils.JsonUtils.getResponseData;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.json.JSONArray;

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
    private Label labelUsuarios;
    
    @FXML
    private ComboBox comboCentros;
    
     //ObservableList
    static ObservableList<Usuario> valoresLista = FXCollections.observableArrayList();
    
    static ObservableList<Centro> listaCentros =  FXCollections.observableArrayList();
    
    static Centro centroActivo;
    
    
    
    //Property
    private Property<ObservableList<Usuario>> usuarioListProperty = new SimpleObjectProperty<>(valoresLista);
    
    public void initialize() throws IOException, UnirestException, ParseException{
        
        requestCenterList();

        
        comboCentros.setItems(listaCentros);
        comboCentros.setVisibleRowCount(8);
        comboCentros.getSelectionModel().selectFirst();
        
        //centroActivo = (Centro) comboCentros.getValue();
        
       
        
        
        
        
        //searchUsuariosCentro();

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
    private void changeActiveCenter() throws IOException, UnirestException, ParseException {
        
        centroActivo = (Centro) comboCentros.getValue();
        searchUsuariosCentro();
    }
    
     @FXML
    private void verDetalles() throws IOException, UnirestException, ParseException {
        
        //indice
        int index = tViewUsuarios.getSelectionModel().getSelectedIndex();
        if (index != -1) {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("userdetail.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();

            UserdetailController controlador = fxmlLoader.getController();
        stage.getIcons().add(new Image("file:C:\\Users\\DVerd\\Documents\\GitHub\\DanielVerdesAN\\backEnd\\mavenproject1\\src\\main\\resources\\imgs\\favicon.png"));

            controlador.setUsuario(valoresLista.get(index),centroActivo.getNOMBRE_CENTRO());
           
            stage.setTitle("Detalles Usuario");
            stage.setScene(scene);
            stage.show();
        }
    }
    
    
    public void requestUserList() throws IOException, UnirestException, ParseException{
        
        List<Usuario> listaUsuario =  JsonUtils.parseUsuarios(        APIConnector.getMethod("http://localhost:33333/usuarios/usuario?columns=ID_USUARIO%2CFOTO_USUARIO%2CNOMBRE_USUARIO%2CAPELLIDOS_USUARIO%2CFECHA_NACIMIENTO%2CGENERO_USUARIO%2CDEPENDENCIA_USUARIO%2CALTA_USUARIO%2CBAJA_USUARIO"));
        for(Usuario u : listaUsuario){
            valoresLista.add(u);
        }
    }
    
     public void requestCenterList() throws IOException, UnirestException, ParseException{
        
        List<Centro> listaCentro =  JsonUtils.parseCentro(        APIConnector.getMethod("http://localhost:33333/centros/centro?columns=NOMBRE_CENTRO%2CID_CENTRO"));
        for(Centro u : listaCentro){
            listaCentros.add(u);
        }
    }
     
      @FXML
    private void searchUsuariosCentro() throws UnirestException, ParseException{
        valoresLista.clear();
        int centroId = centroActivo.getID_CENTRO();
        String url = "http://localhost:33333/usuarios/usuarioCentro/search";
        String body = "{\n" +
"    \"columns\" : [\"U.ID_USUARIO\",\"U.NOMBRE_USUARIO\",\"U.APELLIDOS_USUARIO\",\"U.FECHA_NACIMIENTO\",\"U.GENERO_USUARIO\",\"U.DEPENDENCIA_USUARIO\",\"U.FOTO_USUARIO\",\"U.ALTA_USUARIO\"],\n" +
"    \"filter\" : {\n" +
"        \"CE.ID_CENTRO\" : "+centroId+"\n" +
"    }\n" +
"}";
        List<Usuario> listaUsuario =  JsonUtils.parseUsuarios(APIConnector.postMethod(url, body));
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