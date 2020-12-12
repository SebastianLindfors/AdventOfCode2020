package com.AOC2020.Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day8Test {

  private AoCChallenge challenge;

  @Test
  void Part8FinalAnswer1Test_shouldBe5() {

    challenge = new Day8("ExampleData/Day8Example1.txt", true);

    //Correct answer given by AoC page.
    int expected = 5;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part8FinalAnswer2Test_shouldBe8() {

    challenge = new Day8("ExampleData/Day8Example1.txt", false);

    //Correct answer given by AoC page.
    int expected = 8;

    Assertions.assertEquals(expected, challenge.getTask2Solution());
  }

}