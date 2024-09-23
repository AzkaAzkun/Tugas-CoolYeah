package com.example.clockapp;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.time.LocalTime;

public class ClockDisplay {
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private NumberDisplay seconds;
    private final Label clockLabel;
    private final VBox layout;

    public ClockDisplay() {
        hours = new NumberDisplay(23);
        minutes = new NumberDisplay(59);
        seconds = new NumberDisplay(59);

        clockLabel = new Label();
        clockLabel.setStyle("-fx-font-size: 70px; -fx-text-fill: white;");
        clockLabel.setFont(Font.font("Roboto"));

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4.0);
        dropShadow.setOffsetY(4.0);
        dropShadow.setColor(Color.AQUA);

        clockLabel.setEffect(dropShadow);

        layout = new VBox(clockLabel);
        layout.setStyle("-fx-background-color: black;");
        layout.setAlignment(Pos.CENTER);

        initCurrentTime();
        updateDisplay();
    }

    public void initCurrentTime(){
        LocalTime currentTime = LocalTime.now();
        hours.setValue(currentTime.getHour());
        minutes.setValue(currentTime.getMinute());
        seconds.setValue(currentTime.getSecond());
    }

    public void startClock() {
        Timeline clock = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            seconds.increment();
            if (seconds.getValue().equals("00")) {
                minutes.increment();
                if (minutes.getValue().equals("00")) {
                    hours.increment();
                }
            }
            updateDisplay();
        }));
        clock.setCycleCount(Timeline.INDEFINITE);
        clock.play();
    }

    private void updateDisplay() {
        String time = String.format("%s:%s:%s", hours.getValue(), minutes.getValue(), seconds.getValue());
        clockLabel.setText(time);
    }

    public VBox getLayout() {
        return layout;
    }
}
