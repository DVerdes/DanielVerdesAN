module com.mycompany.practicafinal {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.practicafinal to javafx.fxml;
    exports com.mycompany.practicafinal;
}
