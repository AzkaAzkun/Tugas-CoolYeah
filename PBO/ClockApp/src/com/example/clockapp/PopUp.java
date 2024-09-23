package com.example.clockapp;

import javafx.scene.control.Alert;

public class PopUp {
    private final Alert alert;

    public PopUp(Alert.AlertType type,String message){
        alert = new Alert(type);
        alert.setTitle("Information");
        alert.setContentText(message);
    }

    public void show(){
        alert.showAndWait();
    }
}
