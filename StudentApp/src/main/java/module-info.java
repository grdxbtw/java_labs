module org.example.studentapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.studentapp to javafx.fxml;
    opens org.example.studentapp.view to javafx.fxml;
    exports org.example.studentapp;
}