module com.mycompany.com.aulanosa.paneljuegos {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.com.aulanosa.paneljuegos to javafx.fxml;
    exports com.mycompany.com.aulanosa.paneljuegos;
}
