/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.mashape.unirest.http.exceptions.UnirestException;
import static com.mycompany.mavenproject1.NewuserController.listaGenero;
import static com.mycompany.mavenproject1.UserdetailController.cenaItems;
import static com.mycompany.mavenproject1.UserdetailController.comidaItems;
import static com.mycompany.mavenproject1.UserdetailController.desayunoItems;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class de Nueva Medicación
 *
 * @author DVerd
 */
public class NewmedController implements Initializable {

    @FXML
    private ComboBox comboAdmin;

    @FXML
    private TextField tfFarmaco;

    @FXML
    private TextField tfDosis;

    @FXML
    private RadioButton rDesayuno;
    @FXML
    private RadioButton rComida;
    @FXML
    private RadioButton rCena;
    @FXML
    private DatePicker dateIniciotto;
    @FXML
    private DatePicker dateFintto;

    private UserdetailController usercontroller;

    static ObservableList<String> listaAdmin = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        listaAdmin.add("Oral");
        listaAdmin.add("IV");
        listaAdmin.add("sc");

        comboAdmin.setItems(listaAdmin);
    }

    /**
     * Añade nueva pauta
     * @throws UnirestException
     * @throws ParseException 
     */
    @FXML
    private void anadirFarmaco() throws UnirestException, ParseException {
        String nombreFarmaco = tfFarmaco.getText();
        String dosis = tfDosis.getText();
        String viaAdm = (String) comboAdmin.getValue();
        Boolean enDesayuno = rDesayuno.isSelected();
        Boolean enComida = rComida.isSelected();
        Boolean enCena = rCena.isSelected();
        String posologia = "";

        if (enDesayuno) {
            posologia += "desayuno,";
        }
        if (enComida) {
            posologia += "comida,";
        }
        if (enCena) {
            posologia += "cena";
        }

        Date sqlDateInicio = Date.valueOf(dateIniciotto.getValue());
        Date sqlDateFin = Date.valueOf(dateFintto.getValue());

        int userId = UserdetailController.usuario_static.getID_USUARIO();

        String urlHabitar = "http://localhost:33333/farmacos/farmaco";
        String body = "{\r\n    \"data\": \r\n        {\r\n                        \"ID_USUARIO\": \"" + userId + "\",\r\n\r\n   \"VIA_ADMINISTRACION\": \"" + viaAdm + "\",\r\n\r\n   \"DOSIS\": \"" + dosis + "\",\r\n\r\n   \"POSOLOGIA\": \"" + posologia + "\",\r\n\r\n   \"INICIO_PAUTA\": \"" + sqlDateInicio + "\",\r\n\r\n   \"FIN_PAUTA\": \"" + sqlDateFin + "\",\r\n\r\n  \"NOMBRE_FARMACO\": \"" + nombreFarmaco + "\"\r\n            \r\n        }\r\n}";
        APIConnector.postMethod(urlHabitar, body);

        Pauta p = new Pauta();
        p.setNombreFarmaco(nombreFarmaco);
        p.setDosis(dosis);
        p.setPosologia(posologia);
        p.setViaAdministracion(viaAdm);

        if (posologia.contains("desayuno")) {
            desayunoItems.add(p.toString());
        }
        if (posologia.contains("comida")) {
            comidaItems.add(p.toString());
        }
        if (posologia.contains("cena")) {
            cenaItems.add(p.toString());
        }

        Stage stage = (Stage) comboAdmin.getScene().getWindow();
        stage.close();
    }

}
