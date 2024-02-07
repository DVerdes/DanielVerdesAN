module com.aulanosa.bindingd {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.aulanosa.bindingd to javafx.fxml;
    exports com.aulanosa.bindingd;
}
