package com.AOC2020.Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day6Test {

  private AoCChallenge challenge;

  @Test
  void Part5FinalAnswer1Test_shouldBe11() {

    challenge = new Day6("ExampleData/Day6Example1.txt", true);

    //Correct answer given by AoC page.
    int expected = 11;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part5FinalAnswer2Test_shouldBe11() {

    challenge = new Day6("ExampleData/Day6Example1.txt", false);

    //Correct answer given by AoC page.
    int expected = 6;

    Assertions.assertEquals(expected, challenge.getTask2Solution());
  }

}