package com.AOC2020.Tasks;

import javafx.scene.SnapshotParameters;
import lombok.Data;

public @Data class Day12 extends AoCChallenge {

  private int task1Solution, task2Solution;

  public Day12(String overrideFileName) {
    super(overrideFileName);
  }

  public Day12(String overrideFileName, boolean oneNotTwo) {
    super(overrideFileName, oneNotTwo);
  }

  @Override
  protected void computeSolutionToTask1() {

    String[] inputData = fileReader.getInputDataAsLineArray();
    Ship ship = new Ship();

    for (String instructionString : inputData) {
      ship.executeAbsoluteInstruction(instructionString);
    }

    task1Solution = ship.getManhattanDistanceFromStart();


  }

  @Override
  protected void computeSolutionToTask2() {

    String[] inputData = fileReader.getInputDataAsLineArray();
    Ship ship = new Ship();

    for (String instructionString : inputData) {
      ship.executeWaypointInstruction(instructionString);
    }

    task2Solution = ship.getManhattanDistanceFromStart();

  }

  private class Ship {

    private char[] headingArray = {'E', 'S', 'W', 'N'};

    private int headingPointer = 0;
    private int xPosition = 0;
    private int yPosition = 0;
    
    private int waypointXPosition = 10;
    private int waypointYPosition = 1;

    public Ship() {}

    public void executeAbsoluteInstruction(String instructionString) {

      char instruction = instructionString.charAt(0);
      String magnitude = instructionString.substring(1);
      System.out.println("Order Received: '" + instruction + "' Magnitude: " + magnitude); //DEBUGGING

      switch(instruction) {
        case 'E':
          moveEast(Integer.parseInt(magnitude));
          break;
        case 'W':
          moveWest(Integer.parseInt(magnitude));
          break;
        case 'N':
          moveNorth(Integer.parseInt(magnitude));
          break;
        case 'S':
          moveSouth(Integer.parseInt(magnitude));
          break;
        case 'F':
          moveForward(Integer.parseInt(magnitude));
          break;
        case 'R':
          turnRight(Integer.parseInt(magnitude));
          break;
        case 'L':
          turnLeft(Integer.parseInt(magnitude));
          break;
        default:
          throw new IllegalArgumentException("Instruction '" + instruction + "' not valid!");
      }

    }
    
    public void executeWaypointInstruction(String instructionString) {

      char instruction = instructionString.charAt(0);
      String magnitude = instructionString.substring(1);
      System.out.println("Order Received: '" + instruction + "' Magnitude: " + magnitude); //DEBUGGING

      switch(instruction) {
        case 'E':
          moveWaypointEast(Integer.parseInt(magnitude));
          break;
        case 'W':
          moveWaypointWest(Integer.parseInt(magnitude));
          break;
        case 'N':
          moveWaypointNorth(Integer.parseInt(magnitude));
          break;
        case 'S':
          moveWaypointSouth(Integer.parseInt(magnitude));
          break;
        case 'F':
          moveTowardsWaypoint(Integer.parseInt(magnitude));
          break;
        case 'R':
          rotateWaypointRight(Integer.parseInt(magnitude));
          break;
        case 'L':
          rotateWaypointLeft(Integer.parseInt(magnitude));
          break;
        default:
          throw new IllegalArgumentException("Instruction '" + instruction + "' not valid!");
      
      }
    }

    public int getManhattanDistanceFromStart() {
      return Math.abs(xPosition) + Math.abs(yPosition);
    }



    //region <Relative Movement>

    private void moveForward(int amount) {

      switch(headingArray[headingPointer]) {
        case 'E':
          moveEast(amount);
          break;
        case 'W':
          moveWest(amount);
          break;
        case 'N':
          moveNorth(amount);
          break;
        case 'S':
          moveSouth(amount);
      }
    }

    private void moveTowardsWaypoint(int amount) {

      xPosition += (amount * waypointXPosition);
      yPosition += (amount * waypointYPosition);

    }

    private void turnRight(int degrees) {

      int amount = degrees / 90;
      amount = amount % 4;

      headingPointer += amount;
      if (headingPointer >= 4) {
        headingPointer -= 4;
      }

    }

    private void rotateWaypointRight(int degrees) {

      int newXPosition = waypointXPosition;
      int newYPosition = waypointYPosition;

      int amount = degrees / 90;
      amount = amount % 4;

      switch(amount) {
        case 0:
          break;
        case 1:
          newXPosition = waypointYPosition;
          newYPosition = (-1) * waypointXPosition;
          break;
        case 2:
          newXPosition = (-1) * waypointXPosition;
          newYPosition = (-1) * waypointYPosition;
          break;
        case 3:
          newXPosition = (-1) * waypointYPosition;
          newYPosition =  waypointXPosition;
          break;
        default:
          throw new IllegalArgumentException("Cannot turn ship by " + degrees + "degrees. Only orthogonal turns allowed.");
      }

      waypointXPosition = newXPosition;
      waypointYPosition = newYPosition;

    }

    private void turnLeft(int degrees) {

      int amount = degrees / 90;
      amount = amount % 4;

      headingPointer -= amount;
      if (headingPointer < 0) {
        headingPointer += 4;
      }
    }

    private void rotateWaypointLeft(int degrees) {

      int newXPosition = waypointXPosition;
      int newYPosition = waypointYPosition;

      int amount = degrees / 90;
      amount = amount % 4;

      switch (amount) {
        case 0:
          break;
        case 1:
          newXPosition = (-1) * waypointYPosition;
          newYPosition = waypointXPosition;
          break;
        case 2:
          newXPosition = (-1) * waypointXPosition;
          newYPosition = (-1) * waypointYPosition;
          break;
        case 3:
          newXPosition = waypointYPosition;
          newYPosition = (-1) * waypointXPosition;
          break;
        default:
          throw new IllegalArgumentException("Cannot turn ship by " + degrees + "degrees. Only orthogonal turns allowed.");
      }
      waypointXPosition = newXPosition;
      waypointYPosition = newYPosition;

    }

    //endregion

    //region <Compass Movement>

    private void moveNorth(int distance) {
      yPosition += distance;
    }

    private void moveWaypointNorth(int distance) {
      waypointYPosition += distance;
    }

    private void moveSouth(int distance) {
      yPosition -= distance;
    }

    private void moveWaypointSouth(int distance) {
      waypointYPosition -= distance;
    }

    private void moveEast(int distance) {
      xPosition += distance;
    }

    private void moveWaypointEast(int distance) {
      waypointXPosition += distance;
    }

    private void moveWest(int distance) {
      xPosition -= distance;
    }

    private void moveWaypointWest(int distance) {
      waypointXPosition -= distance;
    }

    //endregion


  }

}
