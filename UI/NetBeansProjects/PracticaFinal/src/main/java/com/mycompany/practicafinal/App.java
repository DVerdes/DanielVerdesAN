package com.mycompany.practicafinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * PRÁCTICA FINAL
 * MANUEL CARRO SUÁREZ - DANIEL VERDES MARTÍNEZ
 */
public class App extends Application {

    // Scene
    private static Scene scene;

    /**
     * Carga stage + scene
     * @param stage
     * @throws IOException 
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 879, 465);

        // Hoja de estilos css inicial
        String cssScene = this.getClass().getResource("firstStyles.css").toExternalForm();
        scene.getStylesheets().add(cssScene);

        stage.setScene(scene);
        stage.setTitle("Jugadores");
        stage.show();
    }

    /**
     * Set raíz
     * @param fxml fxml a usar como raíz
     * @throws IOException 
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Carga fxml
     * @param fxml
     * @return Parent
     * @throws IOException 
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * Main
     * @param args 
     */
    public static void main(String[] args) {
        launch();
    }

}
