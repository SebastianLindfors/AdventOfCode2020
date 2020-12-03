package com.AOC2020.Executables;

import com.AOC2020.Tasks.Day1;
import com.AOC2020.Tasks.Day2;

public class AdventOfCode2020Data {

  public static void main(String args[]) {

    int dayToCompute = 2;

    switch (dayToCompute) {
      case 1:
        Day1 day1 = new Day1("Day1Data.txt");
        System.out.println("Solution to task 1: " + day1.getTask1Solution());
        System.out.println("Solution to task 2: " + day1.getTask2Solution());
        break;
      case 2:
        Day2 day2 = new Day2("Day2Data.txt");
        System.out.println("Solution to task 1: " + day2.getTask1Solution());
        System.out.println("Solution to task 2: " + day2.getTask2Solution());
        break;
      }
    }
}

