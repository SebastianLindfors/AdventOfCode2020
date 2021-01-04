package com.AOC2020.Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day17Test {

  private AoCChallenge challenge;

  @Test
  void Part15FinalAnswer1Test1_shouldBe112() {

    challenge = new Day17("ExampleData/Day17Example1.txt", true);

    //Correct answer given by AoC page.
    int expected = 112;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part16FinalAnswer2Test1_shouldBe143() {

    challenge = new Day17("ExampleData/Day17Example1.txt", false);

    //Correct answer given by AoC page.
    int expected = 848;

    Assertions.assertEquals(expected, challenge.getTask2Solution());
  }

}