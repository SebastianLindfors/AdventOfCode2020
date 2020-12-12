package com.AOC2020.Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day12Test {

  private AoCChallenge challenge;

  @Test
  void Part12FinalAnswer1Test_shouldBe37() {

    challenge = new Day12("ExampleData/Day12Example1.txt", true);

    //Correct answer given by AoC page.
    int expected = 25;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part12FinalAnswer2Test_shouldBe286() {

    challenge = new Day12("ExampleData/Day12Example1.txt", false);

    //Correct answer given by AoC page.
    int expected = 286;

    Assertions.assertEquals(expected, challenge.getTask2Solution());
  }

}