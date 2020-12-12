package com.AOC2020.Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day10Test {

  private AoCChallenge challenge;

  @Test
  void Part8FinalAnswer1Test_shouldBe220() {

    challenge = new Day10("ExampleData/Day10Example1.txt", true);

    //Correct answer given by AoC page.
    int expected = 220;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part8FinalAnswer2Test_shouldBe19208() {

    challenge = new Day10("ExampleData/Day10Example1.txt", false);

    //Correct answer given by AoC page.
    long expected = 19208;

    Assertions.assertEquals(expected, ((Day10) challenge).getTask2SolutionAsLong());
  }


}