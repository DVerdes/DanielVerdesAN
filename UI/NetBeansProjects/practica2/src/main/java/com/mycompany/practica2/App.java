package com.mycompany.practica2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App Práctica 2 Main
 */
public class App extends Application {

    private static Scene scene;
    public static Stage stage;

    /**
     * Start
     *
     * @param primStage stage
     * @throws IOException
     */
    @Override
    public void start(Stage primStage) throws IOException {
        //stage
        stage = primStage;
        scene = new Scene(loadFXML("primary"), 640, 480);

        // hoja de estilos css inicial
        String cssScene = this.getClass().getResource("firstStyles.css").toExternalForm();
        scene.getStylesheets().add(cssScene);

        primStage.setScene(scene);
        primStage.show();
    }

    /**
     * setea root
     *
     * @param fxml ruta FXML
     * @throws IOException
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * carga FXML
     *
     * @param fxml ruta FXML
     * @return método
     * @throws IOException
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * lanza app
     *
     * @param args argumentos
     */
    public static void main(String[] args) {
        launch();
    }

}
