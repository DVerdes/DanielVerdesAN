module com.mycompany.practica2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.practica2 to javafx.fxml;
    exports com.mycompany.practica2;
}
