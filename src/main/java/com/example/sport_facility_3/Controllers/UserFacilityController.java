package com.example.sport_facility_3.Controllers;

import com.example.sport_facility_3.data.SceneLoader;
import com.example.sport_facility_3.data.UserData;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserFacilityController implements Initializable {
    public Button btnLogOut;
    public Label UseName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UseName.setText(UserData.getInstance().getUserRecord().username());
    }

    public void LogOut(ActionEvent actionEvent) throws IOException {
        UserData.resetInstance();
        SceneLoader.loadScreen("/com/example/sport_facility_3/Login.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }
}
