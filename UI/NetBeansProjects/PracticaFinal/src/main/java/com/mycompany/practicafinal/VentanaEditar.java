/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *
 * Clase con controlador para editar jugadores
 */
public class VentanaEditar {

    //Elementos javaFX
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

    static Jugador jugador;

    static int indexLista;

    final FileChooser f = new FileChooser();
    @FXML
    ImageView mv = new ImageView(); // create empty ImageView

    String url = "";

    public void initialize() {

    }

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
     * Edita jugador con valores introducidos y actualiza en BBDD
     *
     * @throws SQLException
     */
    @FXML
    private void editarJugador() throws SQLException {

        if (validateAge() && !url.isEmpty()) {

            jugador.setNombre(nombre.getText());
            jugador.setApellido(apellidos.getText());
            jugador.setEquipo(equipo.getText());
            jugador.setPosicion(posicion.getText());
            jugador.setEdad(Integer.valueOf(edad.getText()));
            jugador.setImgURL(url);
            //Persiste en BBDD
            JdbcDao.updateRecord(jugador);
            //Persiste en lista
            PrimaryController.valoresLista.set(indexLista, jugador);

            Stage stage = (Stage) añadirImagen.getScene().getWindow();
            stage.close();
        }

    }

    /**
     * Valida campo edad
     *
     * @return booleano con validación
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

    /**
     * Recibe jugador de PrimaryController
     *
     * @param jugadorU jugador enviado
     * @param index índice en lista
     */
    public void setJugador(Jugador jugadorU, int index) {
        this.jugador = jugadorU;
        indexLista = index;

        nombre.setText(jugador.getNombre());
        apellidos.setText(jugador.getApellido());
        equipo.setText(jugador.getEquipo());
        posicion.setText(jugador.getPosicion());
        edad.setText(String.valueOf(jugador.getEdad()));
        url = jugador.getImgURL();
        Image img = new Image(url);

        mv.setImage(img);

        System.out.println(jugador);

    }

}
