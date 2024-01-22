module com.aulanosa.ejerciciolayouts {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.aulanosa.ejerciciolayouts to javafx.fxml;
    exports com.aulanosa.ejerciciolayouts;
}
