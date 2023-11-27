package com.mycompany.practica2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

/**
 * Contiene Controller Primario
 *
 * @author DVerd
 */
public class PrimaryController {

    @FXML
    private AnchorPane leftPane;

    @FXML
    private AnchorPane rightPane;

    @FXML
    private ToggleButton stylesButton;

    /**
     * Método que asigna Ids al inicializar FXML
     */
    public void initialize() {
        leftPane.setId("leftPane");
        rightPane.setId("rightPane");
    }

    /**
     * cambia estilos (stylesButton)
     *
     * @throws IOException
     */
    @FXML
    private void changeStyles() throws IOException {
        if (stylesButton.isSelected()) {
            App.stage.getScene().getStylesheets().clear();
            App.stage.getScene().setUserAgentStylesheet(null);
            App.stage.getScene().getStylesheets()
                    .add(getClass()
                            .getResource("secondStyles.css")
                            .toExternalForm());

        } else {
            App.stage.getScene().getStylesheets().clear();
            App.stage.getScene().setUserAgentStylesheet(null);
            App.stage.getScene().getStylesheets()
                    .add(getClass()
                            .getResource("firstStyles.css")
                            .toExternalForm());

        }

    }

}
