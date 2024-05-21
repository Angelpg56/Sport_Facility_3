package com.example.sport_facility_3.data;

import com.example.sport_facility_3.main.main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLoader
{
    public static void loadScreen(String viewPath, Stage stage)
            throws IOException
    {
        Parent root = FXMLLoader.load(
            main.class.getResource(viewPath)
        );
        Scene viewScene = new Scene(root);
        stage.setScene(viewScene);
        stage.show();
    }
}
