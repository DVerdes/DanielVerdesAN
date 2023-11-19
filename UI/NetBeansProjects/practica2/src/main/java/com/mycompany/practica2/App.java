package com.mycompany.practica2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static Stage stage;


    @Override
    public void start(Stage primStage) throws IOException {
        stage = primStage;
        scene = new Scene(loadFXML("primary"), 640, 480);

        String cssScene = this.getClass().getResource("firstStyles.css").toExternalForm();
        scene.getStylesheets().add(cssScene);

        primStage.setScene(scene);
        primStage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
