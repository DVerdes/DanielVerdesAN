module com.mycompany.practicafinal {
    requires javafx.controls;
    requires javafx.fxml;
        requires commons.validator;

    requires mysql.connector.java;
        requires java.sql;



    opens com.mycompany.practicafinal to javafx.fxml;
    exports com.mycompany.practicafinal;
}
