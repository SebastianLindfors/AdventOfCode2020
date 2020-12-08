package com.AOC2020.Executables;

import com.AOC2020.Tasks.*;

public class AdventOfCode2020Data {

  public static void main(String args[]) {

    int dayToCompute = 7;

    AoCChallenge day;

    switch (dayToCompute) {
      case 1:
        day = new Day1("Day1Data.txt");
        System.out.println("Solution to task 1: " + day.getTask1Solution());
        System.out.println("Solution to task 2: " + day.getTask2Solution());
        break;
      case 2:
        day = new Day2("Day2Data.txt");
        System.out.println("Solution to task 1: " + day.getTask1Solution());
        System.out.println("Solution to task 2: " + day.getTask2Solution());
        break;
      case 3:
        day = new Day3("Day3Data.txt");
        System.out.println("Solution to task 1: " + day.getTask1Solution());
        System.out.println("Solution to task 2: " + day.getTask2Solution());
        break;
      case 4:
        day = new Day4("Day4Data.txt");
        System.out.println("Solution to task 1: " + day.getTask1Solution());
        System.out.println("Solution to task 2: " + day.getTask2Solution());
        break;
      case 5:
        day = new Day5("Day5Data.txt");
        System.out.println("Solution to task 1: " + day.getTask1Solution());
        System.out.println("Solution to task 2: " + day.getTask2Solution());
        break;
      case 6:
        day = new Day6("Day6Data.txt");
        System.out.println("Solution to task 1: " + day.getTask1Solution());
        System.out.println("Solution to task 2: " + day.getTask2Solution());
        break;
      case 7:
        day = new Day7("Day7Data.txt");
        System.out.println("Solution to task 1: " + day.getTask1Solution());
        System.out.println("Solution to task 2: " + day.getTask2Solution());
        break;
    }
  }

}

