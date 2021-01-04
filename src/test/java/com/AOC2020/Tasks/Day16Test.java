package com.AOC2020.Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day16Test {

  private AoCChallenge challenge;

  @Test
  void Part15FinalAnswer1Test1_shouldBe71() {

    challenge = new Day16("ExampleData/Day16Example1.txt", true);

    //Correct answer given by AoC page.
    int expected = 71;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part16FinalAnswer2Test1_shouldBe143() {

    challenge = new Day16("ExampleData/Day16Example2.txt", false);

    //Correct answer given by AoC page.
    int expected = 143;

    Assertions.assertEquals(expected, challenge.getTask2Solution());
  }

}