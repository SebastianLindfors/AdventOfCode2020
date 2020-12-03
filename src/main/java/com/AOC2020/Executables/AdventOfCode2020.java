package com.AOC2020.Executables;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class AdventOfCode2020 extends Application {

  public static void main(String[] args) {

    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Advent Of Code 2020!");

    Button day1Task = new Button();
    day1Task.setText("Day 1: Report Repair");
    day1Task.setOnAction(event -> System.out.println("\"Day 1: Report Repair"));

    Button day2Task = new Button();
    day2Task.setText("Day 2: Password Philosophy");
    day2Task.setOnAction(event -> System.out.println("\"Day 2: Password Philosophy"));




    StackPane root = new StackPane();
    root.getChildren().add(day1Task);
    root.getChildren().add(day2Task);
    primaryStage.setScene(new Scene(root, 300, 250));
    primaryStage.show();
  }
}
