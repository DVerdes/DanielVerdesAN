/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.com.aulanosa.paneljuegos;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * Clase con controlador de ventana de resultados
 *
 * @author DVerd
 */
public class ResultsController {

    //componentes interfaz
    //TableView
    @FXML
    private TableView tView;

    //Columnas
    //itemJugador
    @FXML
    private TableColumn column1;
    //itemCPU
    @FXML
    private TableColumn column2;
    //resultado
    @FXML
    private TableColumn column3;
    //fecha
    @FXML
    private TableColumn column4;

    //botón para volver al menú principal
    @FXML
    private Button botonVolverPanel;

    //observableList con valores de Partida de listaPartidas
    ObservableList<Partida> valoresLista = FXCollections.observableArrayList();

    /**
     * Método para inicializar tview
     */
    public void initialize() {
        this.column1.setCellValueFactory((new PropertyValueFactory("itemJugador")));
        this.column2.setCellValueFactory((new PropertyValueFactory("itemCPU")));
        this.column3.setCellValueFactory((new PropertyValueFactory("resultado")));
        this.column4.setCellValueFactory((new PropertyValueFactory("fecha")));
    }

    /**
     * Método para setear resultados en tview
     *
     * @param listaPartidas
     */
    void setResultados(ArrayList<Partida> listaPartidas) {
        //pasar objetos Partida a ObservableList
        for (Partida partida : listaPartidas) {
            valoresLista.add(partida);
        }

        this.tView.setItems(valoresLista);
    }

    /**
     * Método para cambiar a menú principal
     *
     * @param event evento de botón botonVolverPanel
     * @throws IOException
     */
    @FXML
    private void switchToGame(ActionEvent event) throws IOException {

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
}
