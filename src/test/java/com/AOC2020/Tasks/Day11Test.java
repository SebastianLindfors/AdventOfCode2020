package com.AOC2020.Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day11Test {

  private AoCChallenge challenge;

  @Test
  void Part11FinalAnswer1Test_shouldBe37() {

    challenge = new Day11("ExampleData/Day11Example1.txt", true);

    //Correct answer given by AoC page.
    int expected = 37;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part11FinalAnswer2Test_shouldBe26() {

    challenge = new Day11("ExampleData/Day11Example1.txt", false);

    //Correct answer given by AoC page.
    int expected = 26;

    Assertions.assertEquals(expected, challenge.getTask2Solution());
  }

}