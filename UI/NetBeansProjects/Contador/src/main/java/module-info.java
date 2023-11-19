module com.aulanosa.customcomponent {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.aulanosa.customcomponent to javafx.fxml;
    exports com.aulanosa.customcomponent;
}
