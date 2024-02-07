module com.aulanosa.pruebabbdd {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.sql;


    opens com.aulanosa.pruebabbdd to javafx.fxml;
    exports com.aulanosa.pruebabbdd;
}
