package com.AOC2020.Executables;

import com.AOC2020.Tasks.AoCChallenge;
import com.AOC2020.Tasks.Day1;
import com.AOC2020.Tasks.Day2;
import com.AOC2020.Tasks.Day3;

public class AdventOfCode2020Data {

  public static void main(String args[]) {

    int dayToCompute = 3;

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
    }
  }

}

