module com.mycompany.repasobinding {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.repasobinding to javafx.fxml;
    exports com.mycompany.repasobinding;
}
