/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.mashape.unirest.http.exceptions.UnirestException;
import static com.mycompany.mavenproject1.MainViewController.listaCentros;
import static com.mycompany.mavenproject1.MainViewController.valoresLista;
import static com.mycompany.mavenproject1.UserdetailController.usuario_static;
import com.mycompany.mavenproject1.utils.JsonUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class de Nuevo Usuario
 *
 * @author DVerd
 */
public class NewuserController implements Initializable {

    @FXML
    private Button subirImage;

    @FXML
    private Label labelCentro;

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
    private TextField tfContactoNombre;
    @FXML
    private TextField tfContactoApellidos;

    @FXML
    private TextField tfContactoTelefono;

    @FXML
    private TextField tfContactoEmail;

    @FXML
    private ComboBox comboCama;

    @FXML
    private ChoiceBox comboGenero;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfApellido1;

    @FXML
    private TextField tfApellido2;

    final FileChooser f = new FileChooser();
    @FXML
    ImageView mv = new ImageView();
    String url = "";

    @FXML
    private Slider sliDependencia = new Slider(0, 3, 0);

    @FXML
    private DatePicker dateNacimiento;

    static ObservableList<Contacto> valoresListaContacto = FXCollections.observableArrayList();

    static ObservableList<Cama> listaCamas = FXCollections.observableArrayList();

    static ObservableList<String> listaGenero = FXCollections.observableArrayList();

    static Centro centro;

    //Property
    private Property<ObservableList<Contacto>> contactoListProperty = new SimpleObjectProperty<>(valoresListaContacto);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sliDependencia.setMax(3);
        sliDependencia.setMajorTickUnit(1);
        sliDependencia.setMinorTickCount(0);
        sliDependencia.setSnapToTicks(true);
        sliDependencia.setShowTickMarks(true);
        sliDependencia.setShowTickLabels(true);

        String fechaInicial = "01-01-1950";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        dateNacimiento.setValue(LocalDate.parse(fechaInicial, formatter));

        comboCama.setVisibleRowCount(8);
        comboCama.getSelectionModel().selectFirst();

        listaGenero.clear();
        listaGenero.add("Hombre");
        listaGenero.add("Mujer");
        listaGenero.add("Otro");

        comboGenero.setItems(listaGenero);

        this.columnNombre.setCellValueFactory(new PropertyValueFactory("NOMBRE_CONTACTO"));
        this.columnApellidos.setCellValueFactory(new PropertyValueFactory("APELL_CONTACTO"));
        this.columnTelf.setCellValueFactory(new PropertyValueFactory("TELF_CONTACTO"));
        this.columnEmail.setCellValueFactory(new PropertyValueFactory("EMAIL_CONTACTO"));

        this.tViewContactos.setItems(valoresListaContacto);
        //Binding: valoresLista - formulario (TableView)
        tViewContactos.itemsProperty().bind(contactoListProperty);

        // TODO
    }

    /**
     * Introduce usuario en BBDD
     * @throws IOException
     * @throws UnirestException
     * @throws ParseException 
     */
    @FXML
    private void crearUsuario() throws IOException, UnirestException, ParseException {
        String apellidos = tfApellido1.getText() + " " + tfApellido2.getText();
        int dependenciaN = (int) Math.round(sliDependencia.getValue());
        String dependencia = completarDependencia(String.valueOf(dependenciaN));
        String genero = (String) comboGenero.getValue();
        Date sqlDate = Date.valueOf(dateNacimiento.getValue());

        System.out.println(apellidos + " " + dependencia + " " + genero + " " + sqlDate);

        String urlEndpoint = "http://localhost:33333/usuarios/usuario";
        String body = "{\r\n    \"data\": \r\n        {\r\n                        \"FOTO_USUARIO\": \"" + url + "\",\r\n                                    \"NOMBRE_USUARIO\": \"" + tfNombre.getText() + "\",\r\n\r\n   \"APELLIDOS_USUARIO\": \"" + apellidos + "\",\r\n\r\n    \"FECHA_NACIMIENTO\": \"" + sqlDate + "\",\r\n\r\n   \"GENERO_USUARIO\": \"" + genero + "\",\r\n\r\n  \"DEPENDENCIA_USUARIO\": \"" + dependencia + "\"\r\n            \r\n        }\r\n}";
        int id = JsonUtils.returnInsertedUserId(APIConnector.postMethod(urlEndpoint, body));
        System.out.println("Id insertada: " + id);

        insertarHabitar(id);

        insertarContactosUsuario(id);

        Stage stage = (Stage) comboGenero.getScene().getWindow();
        stage.close();

        MainViewController.searchUsuariosCentro();

    }

    /**
     * Permite subir imágenes
     * @throws IOException 
     */
    @FXML
    private void subirImagen() throws IOException {

        subirImage.setOnAction((event) -> {
            File file = f.showOpenDialog(new Window() {
            });
            if (file != null) {
                url = file.toURI().toString();// only proceed, if file was chosen
                Image img = new Image(file.toURI().toString());
                mv.setImage(img);

            }

        });
    }

    /**
     * Completa valor dependencia según valor slider
     * @param string
     * @return 
     */
    private String completarDependencia(String string) {
        String depend = "Grado " + string;
        if (string.equals("0")) {
            return "Independiente";
        } else {
            return depend;
        }

    }

    /**
     * Setea Centro del usuario a crear
     * @param c
     * @throws UnirestException
     * @throws ParseException 
     */
    public void setCentro(Centro c) throws UnirestException, ParseException {
        this.centro = c;
        System.out.println(getCamasDisponibles().toString());

        labelCentro.setText(c.getNOMBRE_CENTRO());

    }

    /**
     * Obtiene camas disponibles del centro
     * @return camas disponibles
     * @throws UnirestException
     * @throws ParseException 
     */
    public List<Cama> getCamasDisponibles() throws UnirestException, ParseException {
        int centroId = centro.getID_CENTRO();
        String url = "http://localhost:33333/camas/camaCentro/search";
        String body = "{\n"
                + "    \"columns\" : [\"ID_CAMA\",\"NOMBRE_CAMA\",\"NOM_HABITACION\",\"ID_USUARIO\"],\n"
                + "    \"filter\" : {\n"
                + "        \"ID_CENTRO\" : " + centroId + "\n"
                + "    }\n"
                + "}";
        List<Cama> listCamas = JsonUtils.parseCama(APIConnector.postMethod(url, body));

        listaCamas.clear();
        for (Cama c : listCamas) {
            listaCamas.add(c);
        }

        comboCama.setItems(listaCamas);

        return listCamas;
    }

    /**
     * Inserta tabla Habitar
     * @param idUsuario id del usuario que va a habitar la habitación
     * @throws UnirestException 
     */
    private void insertarHabitar(int idUsuario) throws UnirestException {
        Cama cama = (Cama) comboCama.getValue();
        int idCama = cama.getID_CAMA();
        String urlHabitar = "http://localhost:33333/habitares/habitar";
        String body = "{\r\n    \"data\": \r\n        {\r\n                        \"ID_USUARIO\": \"" + idUsuario + "\",\r\n\r\n  \"ID_CAMA\": \"" + idCama + "\"\r\n            \r\n        }\r\n}";
        APIConnector.postMethod(urlHabitar, body);
    }

    /**
     * Añade contacto a la lista 
     */
    @FXML
    private void anadirContacto() {
        Contacto co = new Contacto(tfContactoNombre.getText(), tfContactoApellidos.getText(), tfContactoTelefono.getText(), tfContactoEmail.getText());
        valoresListaContacto.add(co);
    }

    /**
     * Quita contacto de la lista
     */
    @FXML
    private void quitarContacto() {

        Contacto co = tViewContactos.getSelectionModel().getSelectedItem();
        valoresListaContacto.remove(co);

    }

    /**
     * Inserta contactos de la lista en la BBDD
     * @param idUsuario id del usuario de los contactos
     * @throws UnirestException
     * @throws ParseException 
     */
    private void insertarContactosUsuario(int idUsuario) throws UnirestException, ParseException {

        String urlEndpoint = "http://localhost:33333/contactos/contacto";
        String urlCU = "http://localhost:33333/usuarioContactos/usuarioContacto";

        for (Contacto c : valoresListaContacto) {
            String body = "{\r\n    \"data\": \r\n        {\r\n                        \"NOMBRE_CONTACTO\": \"" + c.getNOMBRE_CONTACTO() + "\",\r\n                                    \"APELLIDOS_CONTACTO\": \"" + c.getAPELL_CONTACTO() + "\",\r\n\r\n   \"TELF_CONTACTO\": \"" + c.getTELF_CONTACTO() + "\",\r\n\r\n  \"EMAIL_CONTACTO\": \"" + c.getEMAIL_CONTACTO() + "\"\r\n            \r\n        }\r\n}";
            int idContacto = JsonUtils.returnInsertedContactoId(APIConnector.postMethod(urlEndpoint, body));

            String bodyCU = "{\r\n    \"data\": \r\n        {\r\n                        \"ID_USUARIO\": \"" + idUsuario + "\",\r\n\r\n  \"ID_CONTACTO\": \"" + idContacto + "\"\r\n            \r\n        }\r\n}";
            APIConnector.postMethod(urlCU, bodyCU);

        }

        valoresListaContacto.clear();

    }

}
