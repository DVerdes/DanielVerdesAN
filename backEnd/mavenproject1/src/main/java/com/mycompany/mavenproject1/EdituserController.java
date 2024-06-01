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
 * FXML Controller class de Editar Usuario
 *
 * @author DVerd
 */
public class EdituserController implements Initializable {

    @FXML
    private Button subirImage;

    @FXML
    private Label labelCentro;

    @FXML
    private ComboBox comboCama;

    @FXML
    private ChoiceBox comboGenero;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfApellido1;

    final FileChooser f = new FileChooser();
    @FXML
    ImageView mv = new ImageView();
    String url = "";

    @FXML
    private Slider sliDependencia = new Slider(0, 3, 0);

    @FXML
    private DatePicker dateNacimiento;

    static ObservableList<Cama> listaCamas = FXCollections.observableArrayList();

    static ObservableList<String> listaGenero = FXCollections.observableArrayList();

    static Centro centro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tfNombre.setText(UserdetailController.usuario_static.getNOMBRE_USUARIO());
        tfApellido1.setText(UserdetailController.usuario_static.getAPELLIDOS_USUARIO());
        Image img = new Image(UserdetailController.usuario_static.getFOTO_USUARIO());
        mv.setImage(img);

        sliDependencia.setValue(parsearDependencia(UserdetailController.usuario_static.getDEPENDENCIA_USUARIO()));
        dateNacimiento.setValue(UserdetailController.usuario_static.getFECHA_NACIMIENTO().toLocalDate());

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

        comboGenero.setValue(UserdetailController.usuario_static.getGENERO_USUARIO());

        // TODO
    }

    /**
     * Actualiza usuario con datos aportados
     * @throws IOException
     * @throws UnirestException
     * @throws ParseException 
     */
    @FXML
    private void actualizarUsuario() throws IOException, UnirestException, ParseException {
        String apellidos = tfApellido1.getText();
        int dependenciaN = (int) Math.round(sliDependencia.getValue());
        String dependencia = completarDependencia(String.valueOf(dependenciaN));
        String genero = (String) comboGenero.getValue();
        Date sqlDate = Date.valueOf(dateNacimiento.getValue());

        System.out.println(apellidos + " " + dependencia + " " + genero + " " + sqlDate);

        String urlEndpoint = "http://localhost:33333/usuarios/usuario";
        String body = "{\r\n    \"filter\":{\r\n        \"ID_USUARIO\":" + UserdetailController.usuario_static.getID_USUARIO() + "\r\n    },\r\n    \"data\": \r\n        {\r\n                        \"FOTO_USUARIO\": \"" + url + "\",\r\n                                    \"NOMBRE_USUARIO\": \"" + tfNombre.getText() + "\",\r\n\r\n   \"APELLIDOS_USUARIO\": \"" + apellidos + "\",\r\n\r\n    \"FECHA_NACIMIENTO\": \"" + sqlDate + "\",\r\n\r\n   \"GENERO_USUARIO\": \"" + genero + "\",\r\n\r\n  \"DEPENDENCIA_USUARIO\": \"" + dependencia + "\"\r\n            \r\n        }\r\n      \r\n    \r\n    \r\n}";
        APIConnector.putMethod(urlEndpoint, body);

        Stage stage = (Stage) comboGenero.getScene().getWindow();
        stage.close();

        MainViewController.searchUsuariosCentro();

    }

    /**
     * Permite subir imágen
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
     * Completa dependencia
     * @param string dependencia del slider
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
     * Transforma dependencia recuperada en double
     * @param string dependencia de BBDD
     * @return 
     */
    private Double parsearDependencia(String string) {
        if (string.equals("Independiente")) {
            return 0.0;
        } else {

            String[] split = string.split(" ");

            return Double.valueOf(split[1]);
        }

    }

    /**
     * Centro del usuario
     * @param c centro
     * @throws UnirestException
     * @throws ParseException 
     */
    public void setCentro(Centro c) throws UnirestException, ParseException {
        this.centro = c;
        System.out.println(getCamasDisponibles().toString());

        labelCentro.setText(c.getNOMBRE_CENTRO());

    }

    /**
     * Devuelve camas disponibles
     * @return
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
     * Inserta habitar
     * @param idUsuario idUsuario de la habitación
     * @throws UnirestException 
     */
    private void insertarHabitar(int idUsuario) throws UnirestException {
        Cama cama = (Cama) comboCama.getValue();
        int idCama = cama.getID_CAMA();
        String urlHabitar = "http://localhost:33333/habitares/habitar";
        String body = "{\r\n    \"data\": \r\n        {\r\n                        \"ID_USUARIO\": \"" + idUsuario + "\",\r\n\r\n  \"ID_CAMA\": \"" + idCama + "\"\r\n            \r\n        }\r\n}";
        APIConnector.postMethod(urlHabitar, body);
    }

}
