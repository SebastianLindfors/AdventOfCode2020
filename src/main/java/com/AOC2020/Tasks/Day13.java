package com.AOC2020.Tasks;

import lombok.Data;

import javax.print.DocFlavor;
import javax.swing.*;
import java.sql.SQLOutput;

public @Data class Day13 extends AoCChallenge {

  private int task1Solution;
  private long task2SolutionAsLong;

  public Day13(String overrideFileName) {
    super(overrideFileName);
  }

  public Day13(String overrideFileName, boolean oneNotTwo) {
    super(overrideFileName, oneNotTwo);
  }

  @Override
  protected void computeSolutionToTask1() {

    String[] inputData = fileReader.getInputDataAsLineArray();

    int arrivalTime = Integer.parseInt(inputData[0]);

    String[] busLines = inputData[1].split(",");

    int[][] busData = new int[busLines.length][3];
    for (int i = 0; i < busLines.length; i++ ) {

      if (busLines[i].equals("x")) {
        busData[i][0] = Integer.MAX_VALUE;
        busData[i][1] = Integer.MAX_VALUE;
        busData[i][2] = Integer.MAX_VALUE;
      }
      else {
        int busLineNumber = Integer.parseInt(busLines[i]);
        int firstDepartureAfterArrival = ((arrivalTime / busLineNumber) + 1) * busLineNumber;
        int minutesToWait = firstDepartureAfterArrival - arrivalTime;

        busData[i][0] = busLineNumber;
        busData[i][1] = firstDepartureAfterArrival;
        busData[i][2] = minutesToWait;
      }
    }

    int minWaitTime = Integer.MAX_VALUE;
    int bestBusIndex = -1;
    for (int i = 0; i < busLines.length; i++ ) {
      if (busData[i][2] < minWaitTime) {
        minWaitTime = busData[i][2];
        bestBusIndex = i;
      }
    }

    task1Solution = busData[bestBusIndex][0] * busData[bestBusIndex][2];


  }

  @Override
  protected void computeSolutionToTask2() {

    String[] inputData = fileReader.getInputDataAsLineArray();

    int arrivalTime = Integer.parseInt(inputData[0]);

    String[] busLines = inputData[1].split(",");

    long busLineProduct = 1;

    int[] busData = new int[busLines.length];
    for (int i = 0; i < busLines.length; i++ ) {

      if (busLines[i].equals("x")) {
        busData[i] = 0;
      }
      else {
        int busLineNumber = Integer.parseInt(busLines[i]);
        busLineProduct *= busLineNumber;


        busData[i] = busLineNumber;

      }
    }

    long startTime = 0;
    long busProduct = busData[0];

    for (int i = 1; i < busData.length; i++) {

      if (busData[i] == 0) {
        continue;
      }

      long newStartTime = computeNextBusConvergence(startTime, busProduct, busData[i], i);

      if (newStartTime == -1) {
        throw new ArithmeticException("Found no convergence time for: " + startTime + " " + busProduct + " " + busData[i] + " " + i);
      }

      busProduct *= busData[i];
      startTime = newStartTime;
    }

    task2SolutionAsLong = startTime;

  }

  public long getTask2SolutionAsLong() {
    return task2SolutionAsLong;
  }

  long computeNextBusConvergence(long startTime, long bus1Value, int bus2Value, int bus2Offset) {

    int multiplier = 0;
    if (startTime == 0) {
      multiplier = 1;
    }

    long timeStamp = startTime;
    System.out.println(timeStamp + " < " + bus1Value * bus2Value + ": " + (timeStamp <= (100 * bus1Value * bus2Value)));
    while(timeStamp <= (100L * bus1Value * bus2Value)) {
      timeStamp = startTime + multiplier * bus1Value;
      if ((timeStamp + bus2Offset) %  bus2Value == 0) {
        System.out.println("New Time Stamp: " + timeStamp);
        return timeStamp;
      }
      else {
        multiplier++;
      }
    }
    return -1;
  }

}




