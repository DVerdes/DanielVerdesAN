module com.mycompany.customcontrolexample {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.customcontrolexample to javafx.fxml;
    exports com.mycompany.customcontrolexample;
}
