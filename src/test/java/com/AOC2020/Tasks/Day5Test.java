package com.AOC2020.Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day5Test {

  private AoCChallenge challenge;

  @Test
  void Part5FinalAnswer1Test_shouldBe357() {

    challenge = new Day5("ExampleData/Day5Example1.txt", true);

    //Correct answer given by AoC page.
    int expected = 357;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part5FinalAnswer1Test2_shouldBe567() {

    challenge = new Day5("ExampleData/Day5Example2.txt", true);

    //Correct answer given by AoC page.
    int expected = 567;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }
  @Test
  void Part5FinalAnswer1Test3_shouldBe119() {

    challenge = new Day5("ExampleData/Day5Example3.txt", true);

    //Correct answer given by AoC page.
    int expected = 119;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }
  @Test
  void Part5FinalAnswer1Test4_shouldBe820() {

    challenge = new Day5("ExampleData/Day5Example4.txt", true);

    //Correct answer given by AoC page.
    int expected = 820;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }


}