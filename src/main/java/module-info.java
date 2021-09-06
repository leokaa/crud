module com.example.crud {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.crud to javafx.fxml;
    exports com.example.crud;
}