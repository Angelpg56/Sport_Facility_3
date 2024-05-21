package com.example.sport_facility_3.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("/com/example/sport_facility_3/Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 200, 300);
        stage.setTitle("Sport Facility 3");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}