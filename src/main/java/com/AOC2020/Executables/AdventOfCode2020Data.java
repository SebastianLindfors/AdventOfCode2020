package com.AOC2020.Executables;

import com.AOC2020.Tasks.*;

public class AdventOfCode2020Data {

  public static void main(String args[]) {

    int dayToCompute = 19;

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
      case 8:
        day = new Day8("Day8Data.txt");
        System.out.println("Solution to task 1: " + day.getTask1Solution());
        System.out.println("Solution to task 2: " + day.getTask2Solution());
        break;
      case 9:
        day = new Day9("Day9Data.txt");
        System.out.println("Solution to task 1: " + ((Day9) day).getTask1SolutionAsLong());
        System.out.println("Solution to task 2: " + ((Day9) day).getTask2SolutionAsLong());
        break;
      case 10:
        day = new Day10("Day10Data.txt");
        System.out.println("Solution to task 1: " + day.getTask1Solution());
        System.out.println("Solution to task 2: " + ((Day10) day).getTask2SolutionAsLong());
        break;
      case 11:
        day = new Day11("Day11Data.txt");
        System.out.println("Solution to task 1: " + day.getTask1Solution());
        System.out.println("Solution to task 2: " + day.getTask2Solution());
        break;
      case 12:
        day = new Day12("Day12Data.txt");
        System.out.println("Solution to task 1: " + day.getTask1Solution());
        System.out.println("Solution to task 2: " + day.getTask2Solution());
        break;
      case 13:
        day = new Day13("Day13Data.txt");
        System.out.println("Solution to task 1: " + day.getTask1Solution());
        System.out.println("Solution to task 2: " + ((Day13) day).getTask2SolutionAsLong());
        break;
      case 14:
        day = new Day14("Day14Data.txt");
        System.out.println("Solution to task 1: " + ((Day14) day).getTask1SolutionAsLong());
        System.out.println("Solution to task 2: " + ((Day14) day).getTask2SolutionAsLong());
        break;
      case 15:
        day = new Day15("Day15Data.txt");
        System.out.println("Solution to task 1: " + day.getTask1Solution());
        System.out.println("Solution to task 2: " + day.getTask2Solution());
        break;
      case 16:
        day = new Day16("Day16Data.txt");
        System.out.println("Solution to task 1: " + day.getTask1Solution());
        System.out.println("Solution to task 2: " + ((Day16) day).getTask2SolutionAsLong());
        break;
      case 17:
        day = new Day17("Day17Data.txt");
        System.out.println("Solution to task 1: " + day.getTask1Solution());
        System.out.println("Solution to task 2: " + day.getTask2Solution());
        break;
      case 18:
        day = new Day18("Day18Data.txt");
        System.out.println("Solution to task 1: " + ((Day18) day).getTask1SolutionAsLong());
        System.out.println("Solution to task 2: " + ((Day18) day).getTask2SolutionAsLong());
        break;
      case 19:
        day = new Day19("Day19Data.txt");
        AoCChallenge day2 = new Day19("Day19Data2.txt");
        System.out.println("Solution to task 1: " + day.getTask1Solution());
        System.out.println("Solution to task 2: " + day.getTask2Solution());
        break;

    }
  }

}

