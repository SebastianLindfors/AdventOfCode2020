package com.AOC2020.Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day9Test {

  private AoCChallenge challenge;

  @Test
  void Part9FinalAnswer1Test_shouldBe5() {

    challenge = new Day9("ExampleData/Day9Example1.txt", true);

    //Correct answer given by AoC page.
    int expected = 127;

    Assertions.assertEquals(expected, ((Day9) challenge).getTask1SolutionAsLong());
  }

  @Test
  void Part9FinalAnswer2Test_shouldBe62() {

    challenge = new Day9("ExampleData/Day9Example1.txt", false);

    //Correct answer given by AoC page.
    int expected = 62;

    Assertions.assertEquals(expected, ((Day9) challenge).getTask2SolutionAsLong());
  }


}