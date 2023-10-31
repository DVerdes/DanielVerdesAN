module com.mycompany.mavenproject3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.mavenproject3 to javafx.fxml;
    exports com.mycompany.mavenproject3;
}
