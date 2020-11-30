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

    Button day1Task1 = new Button();
    day1Task1.setText("Day 1");
    day1Task1.setOnAction(event -> System.out.println("Hello World!"));




    StackPane root = new StackPane();
    root.getChildren().add(day1Task1);
    primaryStage.setScene(new Scene(root, 300, 250));
    primaryStage.show();
  }
}
