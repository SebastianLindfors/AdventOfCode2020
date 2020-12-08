package com.AOC2020.Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day7Test {

  private AoCChallenge challenge;

  @Test
  void Part7FinalAnswer1Test_shouldBe4() {

    challenge = new Day7("ExampleData/Day7Example1.txt", true);

    //Correct answer given by AoC page.
    int expected = 4;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part7FinalAnswer2Test_shouldBe32() {

    challenge = new Day7("ExampleData/Day7Example1.txt", false);

    //Correct answer given by AoC page.
    int expected = 32;

    Assertions.assertEquals(expected, challenge.getTask2Solution());
  }

  @Test
  void Part7FinalAnswer2Test2_shouldBe126() {

    challenge = new Day7("ExampleData/Day7Example2.txt", false);

    //Correct answer given by AoC page.
    int expected = 126;

    Assertions.assertEquals(expected, challenge.getTask2Solution());
  }

}