package com.AOC2020.Tasks;

import lombok.Data;

public @Data class Day9 extends AoCChallenge {

  private long task1SolutionAsLong, task2SolutionAsLong;

  public Day9(String overrideFileName) {
    super(overrideFileName);
  }

  public Day9(String overrideFileName, boolean oneNotTwo) {
    super(overrideFileName, oneNotTwo);
  }

  @Override
  protected void computeSolutionToTask1() {

    Long[] inputData = fileReader.getInPutDataAsLongArray();

    int preamble = 25;
    long finalAnswer = Integer.MIN_VALUE;

    boolean finalAnswerFound = false;
    boolean matchFound = false;

    for (int i = preamble; i < inputData.length; i++) {
      matchFound = false;

      for (int j = preamble; j > 0; j--) {
        for (int k = j - 1; k > 0; k--) {


          System.out.print(inputData[i - j] + " + " + inputData[i - k]);
          if (inputData[i - j] + inputData[i - k] == inputData[i]) {
            System.out.println(" = " + inputData[i] + ", MATCH FOUND");
             matchFound = true;
             break;
          }
          else {
            System.out.println(" != " + inputData[i]);
          }
        }
        if (matchFound) {
          break;
        }
      }


      if (matchFound == false) {
        finalAnswer = inputData[i];
        break;
      }
    }

    task1SolutionAsLong = finalAnswer;
  }

  @Override
  protected void computeSolutionToTask2() {

    Long[] inputData = fileReader.getInPutDataAsLongArray();
    computeSolutionToTask1();

    long finalAnswer = 0;

    for (int i = 2; i < inputData.length; i++) {

      long targetSum = 0;
      int index = i - 1;

      for (int j = 0; j < i; j++) {
        targetSum += inputData[j];
      }

      while (targetSum < task1SolutionAsLong) {

        targetSum = targetSum - inputData[index - (i - 1)];
        index++;
        targetSum = targetSum + inputData[index];
        System.out.println("i : " + i + ", Target Sum: " + targetSum);

      }

      if (targetSum == task1SolutionAsLong) {

        long lowValue = Long.MAX_VALUE, highValue = Long.MIN_VALUE;

        System.out.println("Index: " + index + " Lower Index: " + (index - (i - 1)));

        for (int j = index - (i - 1); j <= index; j++) {
          System.out.println("Current Value: " + inputData[j]);
          if (inputData[j] < lowValue) {
            lowValue = inputData[j];
          }
          if (inputData[j] > highValue) {
            highValue = inputData[j];
          }
        }


        finalAnswer = lowValue + highValue;
        System.out.println(lowValue + " + " + highValue + " = " + finalAnswer);
        break;
      }
    }

    task2SolutionAsLong = finalAnswer;
  }


  public long getTask1SolutionAsLong() {
    return task1SolutionAsLong;
  }

  public long getTask2SolutionAsLong() {
    return task2SolutionAsLong;
  }

}
