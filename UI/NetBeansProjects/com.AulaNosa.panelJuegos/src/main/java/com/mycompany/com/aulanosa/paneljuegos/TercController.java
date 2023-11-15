/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.com.aulanosa.paneljuegos;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.apache.commons.validator.routines.DateValidator;
import org.apache.commons.validator.routines.IntegerValidator;

/**
 * Método de controlador de ventana de reservas
 *
 * @author DVerd
 */
public class TercController {

    //componentes interfaz
    //textField para participantes reserva
    @FXML
    private TextField campoParticipantes;

    //textField para salas reserva
    @FXML
    private TextField campoSalas;

    //datePicker para horario reserva
    @FXML
    private DatePicker campoHorario;

    //botón para realizar reserva
    @FXML
    private Button reservar;

    //botón para volver al menú principal
    @FXML
    private Button botonVolverPanel;

    //tableView
    @FXML
    private TableView tView;

    //Columnas
    @FXML
    private TableColumn column1;

    @FXML
    private TableColumn column2;

    @FXML
    private TableColumn column3;

    @FXML
    private TableColumn column4;

    @FXML
    private TableColumn column5;

    @FXML
    private TableColumn column6;

    //label con mensaje de bienvenida (cabecera)
    @FXML
    private Label labelBienvenido;

    @FXML
    private Label labelValPart;

    @FXML
    private Label labelValS;

    @FXML
    private Label labelValH;

    //String para recibir datos menú principal
    //usuario
    String user = "";
    //email
    String email = "";

    //string para guardar horario
    String horario = "";

    //fecha actual
    String fecha = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());

    //lista de objetos Reserva
    ObservableList<Reserva> valoresLista = FXCollections.observableArrayList();

    /**
     * Método para inicializar columnas del tView
     */
    public void initialize() {
        this.column1.setCellValueFactory((new PropertyValueFactory("participantsNumber")));
        this.column2.setCellValueFactory((new PropertyValueFactory("roomName")));
        this.column3.setCellValueFactory((new PropertyValueFactory("schedule")));
        this.column4.setCellValueFactory((new PropertyValueFactory("usuario")));
        this.column5.setCellValueFactory((new PropertyValueFactory("email")));
        this.column6.setCellValueFactory((new PropertyValueFactory("currentDate")));
    }

    /**
     * set usuario introducido en menú principal
     *
     * @param user usuario
     */
    public void setUser(String user) {
        this.user = user;
        this.labelBienvenido.setText("Bienvenido/a " + user);
    }

    /**
     * Método para añadir reserva con datos introducidos
     *
     * @param event evento de botón
     */
    public void addReserva(ActionEvent event) {

        if (tryForm()) {
            //si el datePicker no es nulo...
            if (campoHorario.getValue() != null) {
                horario = campoHorario.getValue().toString();
            }
            campoHorario.setValue(null);
            //Creación de objeto Reserva
            Reserva reserva = new Reserva(user, email, campoParticipantes.getText(), campoSalas.getText(), horario, fecha);
            //se añade objeto a valoresLista
            valoresLista.add(reserva);
            //cargamos valores de la lista en tabla
            this.tView.setItems(valoresLista);
        } else {

        }
    }

    /**
     * set email introducido en menú principal
     *
     * @param email email
     */
    void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método para volver al menú principal
     *
     * @param event evento de botón
     * @throws IOException
     */
    @FXML
    private void switchToPanel(ActionEvent event) throws IOException {

        Scene scene = botonVolverPanel.getScene();

        if (scene != null) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public boolean validateParticipants() {

        IntegerValidator vr = IntegerValidator.getInstance();

        if (!vr.isValid(campoParticipantes.getText())) {
            labelValPart.setText("Introduce un valor válido");
            labelValPart.setStyle("fx-text-fill:red");
            return false;

        } else {
            if (Integer.parseInt(campoParticipantes.getText()) < 4) {
                labelValPart.setText("Participantes insuficientes");
                return false;
            } else {
                labelValPart.setText("");
                return true;

            }
        }

    }

    public boolean validateRoom() {
        if (campoSalas.getText().isEmpty()) {
            labelValS.setText("Introduzca un nombre");
            return false;
        } else {
            labelValS.setText("");
            return true;
        }
    }

    public boolean validateDate() {

        /*
        DateValidator dv = DateValidator.getInstance();

        if (!dv.isValid(campoHorario.getValue().toString())) {
            labelValH.setText("Formato incorrecto");
            return false;
        } else {
            return true;
        }
         */
        if (campoHorario.getValue() == null) {
            
            labelValH.setText("Introduzca una fecha válida");

            return false;
        } 
        horario = campoHorario.getValue().toString();

        if (horario.matches("\\d{4}-\\d{2}-\\d{2}")) {
            labelValH.setText("");
            return true;
        } else {
            labelValH.setText("Formato incorrecto");
            return false;
        }
    }

    public boolean tryForm() {
        if (validateParticipants() && validateRoom() &&  validateDate()) {
            return true;
        } else {
            return false;
        }
    }
}
