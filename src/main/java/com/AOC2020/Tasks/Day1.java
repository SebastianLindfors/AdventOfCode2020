package com.AOC2020.Tasks;

import com.AOC2020.Utilities.AoCFileReader;
import lombok.Data;

public @Data class Day1 extends AoCChallenge{


  private int task1Solution, task2Solution;

  public Day1(String overrideFileName) {
    super(overrideFileName);
  }

  public Day1(String overrideFileName, boolean oneNotTwo) {
    super(overrideFileName, oneNotTwo);
  }

  protected void computeSolutionToTask1() {

    Integer[] inputDataList = fileReader.getInPutDataAsIntegerArray();
    boolean solutionFound = false;

    for(int i = 0; i < inputDataList.length; i++) {
      for(int j = i; j < inputDataList.length; j++) {
        if (inputDataList[i] + inputDataList[j] == 2020) {
          task1Solution = inputDataList[i] * inputDataList[j];
          solutionFound = true;
          break;
        }
        if (solutionFound) {
          break;
        }

      }
      if (solutionFound) {
        break;
      }

    }

  }

  protected void computeSolutionToTask2() {

    Integer[] inputDataList = fileReader.getInPutDataAsIntegerArray();
    boolean solutionFound = false;

    for(int i = 0; i < inputDataList.length; i++) {
      for(int j = i; j < inputDataList.length; j++) {
        for(int k = j; k < inputDataList.length; k++) {
        if (inputDataList[i] + inputDataList[j] + inputDataList[k] == 2020) {
          task2Solution = inputDataList[i] * inputDataList[j] * inputDataList[k];
          solutionFound = true;
          break;
          }
        }
        if (solutionFound) {
          break;
        }
      }
      if (solutionFound) {
        break;
      }
    }

    }

  }

