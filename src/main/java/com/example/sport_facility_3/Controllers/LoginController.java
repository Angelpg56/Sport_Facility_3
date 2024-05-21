package com.example.sport_facility_3.Controllers;

import com.example.sport_facility_3.data.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.sport_facility_3.data.UserFileManagement.userList;

public class LoginController implements Initializable {

    public Button btnLogin;
    public Button btnRegister;
    public TextField txtName;
    public TextField txtPassword;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserData.getInstance();
        UserFileManagement.readUsersFromFile();
    }

    @FXML
    private void LoginVerification(ActionEvent event) throws IOException {
        String credentialUN = txtName.getText();
        String credentialPW = txtPassword.getText();
        switch(Login(credentialUN, credentialPW)) {
            case -1:
                showWarning("Empty Fields", "Empty Fields", "Please fill all the fields");
                break;
            case -2:
                showWarning("User not found", "User not found", "The user does not exist");
                break;
            case -3:
                showWarning("Wrong password", "Wrong password", "Wrong password");
                break;
            case 1:
                UserData.getInstance().setUserRecord(new UserRecord(credentialUN, credentialPW));
                SceneLoader.loadScreen("/com/example/sport_facility_3/UserFacility.fxml",
                        (Stage) ((Node) event.getSource()).getScene().getWindow());
                break;
        }
    }
    public int Login(String credentialUN, String credentialPW) {
        boolean existCredentials = false, correctPassword = false;
        if (credentialUN.isEmpty() || credentialPW.isEmpty()) {
            return -1;
        }
        else {
            for (UserRecord userRecord : UserFileManagement.getUserList()) {
                if (userRecord.username().equals(credentialUN)) {
                    existCredentials = true;
                    if (userRecord.password().equals(credentialPW))
                        correctPassword = true;
                }
            }
            if (!existCredentials) {
                return -2;
            } else if (correctPassword) {
                return 1;
            } else
                return -3;
        }
    }
    public void registerNewUser(ActionEvent event) throws IOException {
        if (txtName.getText().isEmpty() || txtPassword.getText().isEmpty()) {
            showWarning("Empty Fields", "Empty Fields", "Please fill all the fields");
        }
        else {
            switch (register(txtName.getText(), txtPassword.getText())) {
                case -1:
                    showWarning("Password Error", "Password Error",
                            "Password must contain at least 8 characters, one uppercase letter, one lowercase letter, one number and one special character");
                    break;
                case -2:
                    showWarning("Username Error", "Username Error", "Username already registered");
                    break;
                case 1:
                    userList.add(new UserRecord(txtName.getText(), txtPassword.getText()));
                    UserFileManagement.saveUsersToFile();
                    UserData.getInstance().setUserRecord(new UserRecord(txtName.getText(), txtPassword.getText()));
                    SceneLoader.loadScreen("/com/example/sport_facility_3/UserFacility.fxml",
                        (Stage) ((Node) event.getSource()).getScene().getWindow());
                    break;
            }
        }
    }
    public int register(String username, String password) {
        if (!Validator.ExistUsername(username)) {
            if (Validator.SecurityPassword(password)) {
                return 1;
            } else
                return -1;
        } else
            return -2;
    }
    public void showWarning(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }

    public void LogGuest(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("/com/example/sport_facility_3/GuestFacility.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }
}
