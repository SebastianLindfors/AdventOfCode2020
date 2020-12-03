package com.AOC2020.Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day3Test {

  private Day3 challenge;

  @Test
  void Part3FinalAnswer1Test_shouldBe7() {

    challenge = new Day3("ExampleData/Day3Example1.txt", true);

    //Correct answer given by AoC page.
    int expected = 7;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part3FinalAnswer2Test_shouldBe336() {

    challenge = new Day3("ExampleData/Day3Example1.txt", false);

    //Correct answer given by AoC page.
    int expected = 336;

    Assertions.assertEquals(expected, challenge.getTask2Solution());
  }

}