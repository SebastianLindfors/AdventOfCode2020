package com.AOC2020.Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day4Test {

  private AoCChallenge challenge;

  @Test
  void Part4FinalAnswer1Test_shouldBe2() {

    challenge = new Day4("ExampleData/Day4Example1.txt", true);

    //Correct answer given by AoC page.
    int expected = 2;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part4FinalAnswer2Test_shouldBe2() {

    challenge = new Day4("ExampleData/Day4Example1.txt", false);

    //Correct answer given by AoC page.
    int expected = 2;

    Assertions.assertEquals(expected, challenge.getTask2Solution());
  }

  @Test
  void Part4FinalAnswer2Test2_shouldBe0() {

    challenge = new Day4("ExampleData/Day4Example2.txt", false);

    //Correct answer given by AoC page.
    int expected = 0;

    Assertions.assertEquals(expected, challenge.getTask2Solution());
  }

  @Test
  void Part4FinalAnswer2Test3_shouldBe4() {

    challenge = new Day4("ExampleData/Day4Example3.txt", false);

    //Correct answer given by AoC page.
    int expected = 4;

    Assertions.assertEquals(expected, challenge.getTask2Solution());
  }


}