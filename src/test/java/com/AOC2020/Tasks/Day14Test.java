package com.AOC2020.Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day14Test {

  private AoCChallenge challenge;

  @Test
  void Part14FinalAnswer1Test_shouldBe165() {

    challenge = new Day14("ExampleData/Day14Example1.txt", true);

    //Correct answer given by AoC page.
    int expected = 165;

    Assertions.assertEquals(expected, ((Day14) challenge).getTask1SolutionAsLong());
  }

  @Test
  void Part14FinalAnswer2Test_shouldBe208() {

    challenge = new Day14("ExampleData/Day14Example2.txt", false);

    //Correct answer given by AoC page.
    int expected = 208;

    Assertions.assertEquals(expected, ((Day14) challenge).getTask2SolutionAsLong());
  }

}