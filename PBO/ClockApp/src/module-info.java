module com.example.clockapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.clockapp to javafx.fxml;
    exports com.example.clockapp;
}