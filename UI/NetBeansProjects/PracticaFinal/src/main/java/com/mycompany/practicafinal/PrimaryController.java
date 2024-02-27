package com.mycompany.practicafinal;

import java.io.IOException;
import java.sql.SQLException;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Controlador primario (ventana listado jugadores)
 *
 */
public class PrimaryController {

    private Scene scene;
    private Stage stage;

    //Botones
    @FXML
    private Button añadir;
    @FXML
    private Button btnEditar;

    //TableView
    @FXML
    private TableView<Jugador> formulario = new TableView<>();
    ;
    //Columnas
    @FXML
    private TableColumn<Jugador, String> column1;
    @FXML
    private TableColumn<Jugador, String> column2;
    @FXML
    private TableColumn<Jugador, String> colunm3;
    @FXML
    private TableColumn<Jugador, String> colunm4;
    @FXML
    private TableColumn<Jugador, String> colunm5;

    //ImageView
    @FXML
    private ImageView img;
    //Label
    @FXML
    private Label datosJugador;
    //Pane
    @FXML
    private Pane paneFondo;

    //ObservableList
    static ObservableList<Jugador> valoresLista = FXCollections.observableArrayList();
    //Property
    private Property<ObservableList<Jugador>> jugadorListProperty = new SimpleObjectProperty<>(valoresLista);

    /**
     * Initialize
     *
     * @throws SQLException
     */
    public void initialize() throws SQLException {
        //Se cargan registros BBDD
        cargarBBDD();
        //Asociación columnas
        this.column1.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.column2.setCellValueFactory(new PropertyValueFactory("apellido"));
        this.colunm3.setCellValueFactory(new PropertyValueFactory("equipo"));
        this.colunm4.setCellValueFactory(new PropertyValueFactory("posicion"));
        this.colunm5.setCellValueFactory(new PropertyValueFactory("edad"));
        this.formulario.setItems(valoresLista);
        //Binding: valoresLista - formulario (TableView)
        formulario.itemsProperty().bind(jugadorListProperty);

    }

    /**
     * Abre ventana de añadir jugador
     *
     * @throws IOException
     */
    @FXML
    private void añadirAlgo() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("secondary.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 476, 652);
        Stage stage = new Stage();
        String cssScene = this.getClass().getResource("firstStyles.css").toExternalForm();
        scene.getStylesheets().add(cssScene);
        stage.setTitle("Nuevo jugador");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Permite elegir imagen y persistirla en un objeto Jugador
     */
    @FXML
    public void clickImagen() {

        //índice seleccionado
        int index = formulario.getSelectionModel().getSelectedIndex();
        //índice válido (elegido)
        if (index != -1) {
            Jugador c = (Jugador) formulario.getItems().get(index);
            //crea objeto Image
            Image i = new Image(c.getImgURL());
            //setea en ImgView
            img.setImage(i);
            //Descripción jugador bajo imagen
            datosJugador.setText(c.getNombre() + " " + c.getApellido() + " - " + c.getPosicion() + "\n" + c.getEquipo() + "\n" + c.getEdad() + " años");
            img.setVisible(true);

        }

    }

    /**
     * Borra jugador lista + BBDD
     */
    @FXML
    public void borrarJugador() throws SQLException {
        //índice seleccionado
        int index = formulario.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            System.out.println(valoresLista.get(index).toString());
            //borra de bbdd
            JdbcDao.deleteRecord(valoresLista.get(index).getIdJugador());
            //elimina de lista
            valoresLista.remove(index);
            datosJugador.setText("");
            img.setVisible(false);
        }

    }

    /**
     * Abre ventana de edición de jugadores
     *
     * @throws IOException
     */
    @FXML
    private void editarJugador() throws IOException {

        //indice
        int index = formulario.getSelectionModel().getSelectedIndex();
        if (index != -1) {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("editar.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 476, 652);
            Stage stage = new Stage();

            VentanaEditar controlador = fxmlLoader.getController();

            controlador.setJugador(valoresLista.get(index), index);
            String cssScene = this.getClass().getResource("firstStyles.css").toExternalForm();
            scene.getStylesheets().add(cssScene);
            stage.setTitle("Editar jugador");
            stage.setScene(scene);
            stage.show();
        }

    }

    /**
     * Carga datos BBDD
     *
     * @throws SQLException
     */
    private void cargarBBDD() throws SQLException {
        for (Jugador jugador : JdbcDao.selectRecords()) {
            PrimaryController.valoresLista.add(jugador);
        }
    }

}
