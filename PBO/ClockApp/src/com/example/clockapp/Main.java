package com.example.clockapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        ClockDisplay clockDisplay = new ClockDisplay();

        VBox root = clockDisplay.getLayout();
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Clock Application");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();

        clockDisplay.startClock();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
