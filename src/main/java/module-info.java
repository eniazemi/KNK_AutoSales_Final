module com.example.enifinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.enifinal to javafx.fxml;

    exports com.example.enifinal.controllers;
    opens com.example.enifinal.controllers to javafx.fxml;
    exports com.example.enifinal;
    exports com.example.enifinal.process;
    opens com.example.enifinal.process to javafx.fxml;
}