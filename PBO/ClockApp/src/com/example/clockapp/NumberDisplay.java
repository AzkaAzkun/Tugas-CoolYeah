package com.example.clockapp;

import javafx.scene.control.Alert;

public class NumberDisplay {
    private final int limit;
    private int value;

    NumberDisplay(int limit){
        this.limit = limit;
        value = 0;
    }

    public void increment(){
        value++;
        value %= limit;
    }

    public String getValue(){
        if(value<10){
            return "0" + value;
        }else{
            return "" + value;
        }
    }

    public void setValue(int value){
        if(value >= 0 && value <= limit){
            this.value = value;
        }else{
            PopUp error = new PopUp(Alert.AlertType.ERROR,"value input error");
            error.show();
        }
    }
}
