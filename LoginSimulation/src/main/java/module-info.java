module com.example.loginsimulation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.loginsimulation to javafx.fxml;
    exports com.example.loginsimulation;
}