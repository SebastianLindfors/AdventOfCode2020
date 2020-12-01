package com.AOC2020.Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class Day1Test {

  private Day1 challenge;

  @Test
  void Part1FinalAnswer1Test_shouldBe514579() {

    challenge = new Day1("ExampleData/Day1Example1.txt", true);

    //Correct answer given by AoC page.
    int expected = 514579;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part1FinalAnswer2Test_shouldBe241861950() {

    challenge = new Day1("ExampleData/Day1Example1.txt", false);

    //Correct answer given by AoC page.
    int expected = 241861950;

    Assertions.assertEquals(expected, challenge.getTask2Solution());
  }

}