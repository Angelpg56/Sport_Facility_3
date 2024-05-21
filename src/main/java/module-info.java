module com.example.sport_facility_3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sport_facility_3 to javafx.fxml;
    exports com.example.sport_facility_3.main;
    opens com.example.sport_facility_3.main to javafx.fxml;
    exports com.example.sport_facility_3.data;
    opens com.example.sport_facility_3.data to javafx.fxml;
    exports com.example.sport_facility_3.Controllers;
    opens com.example.sport_facility_3.Controllers to javafx.fxml;
}