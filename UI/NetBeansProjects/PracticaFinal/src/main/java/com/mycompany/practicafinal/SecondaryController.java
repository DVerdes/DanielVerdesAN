package com.mycompany.practicafinal;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.apache.commons.validator.routines.IntegerValidator;

/**
 * Controlador de ventana de añadir jugador
 *
 * @author FP
 */
public class SecondaryController {

    //Elementos interfaz
    @FXML
    private Button añadirImagen;
    @FXML
    private Button guardar;
    @FXML
    private Button refresh;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField equipo;
    @FXML
    private TextField posicion;
    @FXML
    private TextField edad;
    @FXML
    private Label labelValAge;

    final FileChooser f = new FileChooser();
    @FXML
    ImageView mv = new ImageView(); // create empty ImageView

    String url = "";

    /**
     * Permite elegir imágen y persistirla en objeto
     */
    @FXML
    private void seleccionimg() {

        añadirImagen.setOnAction((event) -> {
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
     * Persiste jugador en lista + BBDD
     *
     * @throws SQLException
     */
    @FXML
    private void guardarJugador() throws SQLException {

        if (validateAge() && !url.isEmpty()) {

            //Datos del jugador    
            Jugador jugador = new Jugador(nombre.getText(), apellidos.getText(), equipo.getText(), posicion.getText(), Integer.valueOf(edad.getText()), url);
            //obtenemos id de jugador
            int id = JdbcDao.insertRecord(jugador);
            jugador.setIdJugador(id);

            //añade imágen 
            PrimaryController.valoresLista.add(jugador);
            Stage stage = (Stage) añadirImagen.getScene().getWindow();
            stage.close();
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

        if (!vr.isValid(edad.getText())) {
            labelValAge.setText("Introduce un valor válido");
            labelValAge.setStyle("fx-text-fill:red");
            return false;

        } else {
            if (Integer.parseInt(edad.getText()) < 15) {
                labelValAge.setText("Valor incorrecto");
                return false;
            } else {
                labelValAge.setText("");
                return true;

            }
        }

    }
}
