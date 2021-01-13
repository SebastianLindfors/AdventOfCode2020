package com.AOC2020.Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day19Test {

  private AoCChallenge challenge;

  @Test
  void Part19FinalAnswer1Test1_shouldBe2() {

    challenge = new Day19("ExampleData/Day19Example1.txt", true);

    //Correct answer given by AoC page.
    int expected = 2;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part19FinalAnswer1Test2_shouldBe2() {

    challenge = new Day19("ExampleData/Day19Example2.txt", true);

    //Correct answer given by AoC page.
    int expected = 2;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part19FinalAnswer1Test3_shouldBe2() {

    challenge = new Day19("ExampleData/Day19Example3.txt", true);

    //Correct answer given by AoC page.
    int expected = 2;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

}