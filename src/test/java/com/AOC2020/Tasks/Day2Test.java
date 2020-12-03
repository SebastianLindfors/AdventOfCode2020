package com.AOC2020.Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

  private Day2 challenge;

  @Test
  void Part1FinalAnswer1Test_shouldBe2() {

    challenge = new Day2("ExampleData/Day2Example1.txt", true);

    //Correct answer given by AoC page.
    int expected = 2;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part1FinalAnswer2Test_shouldBe1() {

    challenge = new Day2("ExampleData/Day2Example1.txt", false);

    //Correct answer given by AoC page.
    int expected = 1;

    Assertions.assertEquals(expected, challenge.getTask2Solution());
  }

}