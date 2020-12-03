package com.AOC2020.Tasks;

import com.AOC2020.Utilities.AoCFileReader;
import lombok.Data;

public abstract @Data class AoCChallenge {

  private int task1Solution, task2Solution;

  protected AoCFileReader fileReader;

  protected long[][] timing = new long[2][3];

  public AoCChallenge() {}; //For Lombok

  public AoCChallenge(String overrideFileName) {

    fileReader = new AoCFileReader(overrideFileName);

    timing[0][0] = System.nanoTime();
    computeSolutionToTask1();
    timing[0][1] = System.nanoTime();
    timing[0][2] = timing[0][1] - timing[0][0];
    System.out.println("Time taken to compute solution 1: " + timing[0][2]/1000 + " ms");

    timing[1][0] = System.nanoTime();
    computeSolutionToTask2();
    timing[1][1] = System.nanoTime();
    timing[1][2] = timing[1][1] - timing[1][0];
    System.out.println("Time taken to compute solution 2: " + timing[1][2]/1000 + " ms");

  }

  public AoCChallenge(String overrideFileName, boolean oneNotTwo) {

    fileReader = new AoCFileReader(overrideFileName);

    if (oneNotTwo) {
      timing[0][0] = System.nanoTime();
      computeSolutionToTask1();
      timing[0][1] = System.nanoTime();
      timing[0][2] = timing[0][1] - timing[0][0];
      System.out.println("Time taken to compute solution 1: " + timing[0][2] / 1000 + " ms");
    }
    else {
      timing[1][0] = System.nanoTime();
      computeSolutionToTask2();
      timing[1][1] = System.nanoTime();
      timing[1][2] = timing[1][1] - timing[1][0];
      System.out.println("Time taken to compute solution 2: " + timing[1][2] / 1000 + " ms");
    }
  }

  protected void computeSolutionToTask1(){}
  protected void computeSolutionToTask2(){}


}
