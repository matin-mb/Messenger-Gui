module com.example.graphic_002 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.graphic_002 to javafx.fxml;
    exports com.example.graphic_002;
}