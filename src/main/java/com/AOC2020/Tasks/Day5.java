package com.AOC2020.Tasks;


import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public @Data class Day5 extends AoCChallenge {

  private int task1Solution, task2Solution;

  public Day5(String overrideFileName) {
      super(overrideFileName);
    }

  public Day5(String overrideFileName, boolean oneNotTwo) {
      super(overrideFileName, oneNotTwo);
    }

    @Override
    protected void computeSolutionToTask1() {

    int maxSeatId = Integer.MIN_VALUE;

    String[] inputDataStrings = fileReader.getInputDataAsLineArray();
    for (String inputDataString : inputDataStrings) {
        int seatId = computeSeatId(inputDataString);
        if (seatId > maxSeatId) {
          maxSeatId = seatId;
        }
    }

    task1Solution = maxSeatId;

  }

  @Override
  protected void computeSolutionToTask2() {

    String[] inputDataStrings = fileReader.getInputDataAsLineArray();

    String occupiedSeatString = "";
    int maximumSeatId = 1027;

    for (int i = 0; i < maximumSeatId; i++) {
      occupiedSeatString += "_";
    }

    for (String inputDataString : inputDataStrings) {
      int seatId = computeSeatId(inputDataString);
      occupiedSeatString = occupiedSeatString.substring(0,seatId) + "X" + occupiedSeatString.substring(seatId + 1);
    }

    int seatId = occupiedSeatString.indexOf("X_X") + 1;

    task2Solution = seatId;

  }

  private int computeSeatId(String boardingPassString) {
    String rowString = boardingPassString.substring(0,7);
    String columnString = boardingPassString.substring(7);

    int columnNumber = pivotSearch(rowString, 'B', 'F');
    int rowNumber = pivotSearch(columnString, 'R', 'L');

    return (columnNumber * 8) + rowNumber;

  }

  private int pivotSearch(String halvingString, char upIndicator, char downIndicator) {


    int lowerBound = 0;
    int upperBound = (int) Math.pow(2, halvingString.length()) - 1;

    for (char indicator : halvingString.toCharArray()) {
      int newBound = lowerBound + (upperBound - lowerBound) / 2;
      if (indicator == upIndicator) {
        lowerBound = newBound + 1;
      }
      else if (indicator == downIndicator) {
        upperBound = newBound;
      }
      else {
        throw new IllegalArgumentException("Illegal character: '" + indicator + "' in halving string");
      }
    }
    return lowerBound;
  }


}
