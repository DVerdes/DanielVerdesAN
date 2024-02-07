module com.aulanosa.circulo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.aulanosa.circulo to javafx.fxml;
    exports com.aulanosa.circulo;
}
