package com.AOC2020.Tasks;

import lombok.Data;

public @Data class Day3 extends AoCChallenge{

  private int task1Solution, task2Solution;

  public Day3(String overrideFileName) {
    super(overrideFileName);
  }

  public Day3(String overrideFileName, boolean oneNotTwo) {
    super(overrideFileName, oneNotTwo);
  }

  @Override
  protected void computeSolutionToTask1() {

    String [] inputData = fileReader.getInputDataAsLineArray();

    int numberOfTreesHit = 0;
    SlopeSpotCalculator slopeSpotCalculator = new SlopeSpotCalculator(3,1, inputData[0].length());

    for (String treeLine : inputData) {
      if (treeLine.charAt(slopeSpotCalculator.getNext()) == '#') {
        numberOfTreesHit++;
      }
    }
    task1Solution = numberOfTreesHit;

  }

  @Override
  protected void computeSolutionToTask2() {

    String [] inputData = fileReader.getInputDataAsLineArray();

    int[] numberOfTreesHit = new int[5];

    SlopeSpotCalculator[] slopeSpotCalculatorArray = new SlopeSpotCalculator[5];
    slopeSpotCalculatorArray[0] = new SlopeSpotCalculator(1,1, inputData[0].length());
    slopeSpotCalculatorArray[1] = new SlopeSpotCalculator(3,1, inputData[0].length());
    slopeSpotCalculatorArray[2] = new SlopeSpotCalculator(5,1, inputData[0].length());
    slopeSpotCalculatorArray[3] = new SlopeSpotCalculator(7,1, inputData[0].length());
    slopeSpotCalculatorArray[4] = new SlopeSpotCalculator(1,2, inputData[0].length());

    for (int i = 0; i < slopeSpotCalculatorArray.length; i++) {
      int downPosition = 0;
      do {
        if (inputData[downPosition].charAt(slopeSpotCalculatorArray[i].getNext()) == '#') {
          numberOfTreesHit[i]++;
        }
        downPosition += slopeSpotCalculatorArray[i].getDownSpeed();
      } while (downPosition < inputData.length);
    }

    int product = 1;
    for (int i = 0; i < numberOfTreesHit.length; i++) {
      product = product * numberOfTreesHit[i];
    }

    task2Solution = product;


  }

  private class SlopeSpotCalculator {

    private int rightSpeed;
    private int downSpeed;
    private int slopeWidth;

    private int arrayPointer;
    private int[] slopeSpotArray;

    public SlopeSpotCalculator(int rightSpeed, int downSpeed, int slopeWidth) {

      this.rightSpeed = rightSpeed;
      this.slopeWidth = slopeWidth;
      this.downSpeed = downSpeed;

      this.arrayPointer = 0;
      computeSlopeSpotArray();
    }

    private void computeSlopeSpotArray() {

      int[] newArray = new int[slopeWidth + 1];
      newArray[0] = 0;

      for (int i = 1; i < newArray.length; i++) {
        newArray[i] = (rightSpeed * i) % slopeWidth;
        if (newArray[i] == 0) {
          //System.out.printf("Creating new slopeSpotArray (length %d): ", i); //Debugging
          slopeSpotArray = new int[i];
          for (int j = 0; j < i; j++) {
            slopeSpotArray[j] = newArray[j];
            System.out.printf("%d, ", slopeSpotArray[j]);
          }
          System.out.print("\n");
          break;
        }
      }
    }

    public int getNext() {
      int output = slopeSpotArray[arrayPointer++];
      if (arrayPointer == slopeSpotArray.length) {
        arrayPointer = 0;
      }
      return output;
    }

    public int getDownSpeed() {
      return downSpeed;
    }
  }

}
