package com.AOC2020.Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day13Test {

  private AoCChallenge challenge;

  @Test
  void Part13FinalAnswer1Test_shouldBe295() {

    challenge = new Day13("ExampleData/Day13Example1.txt", true);

    //Correct answer given by AoC page.
    int expected = 295;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part13FinalAnswer2Test_shouldBe1068781() {

    challenge = new Day13("ExampleData/Day13Example1.txt", false);

    //Correct answer given by AoC page.
    int expected = 1068781;

    Assertions.assertEquals(expected, ((Day13) challenge).getTask2SolutionAsLong());
  }

  @Test
  void Part13FinalAnswer2Test_shouldBe3417() {

    challenge = new Day13("ExampleData/Day13Example2.txt", false);

    //Correct answer given by AoC page.
    int expected = 3417;

    Assertions.assertEquals(expected, ((Day13) challenge).getTask2SolutionAsLong());
  }

  @Test
  void Part13FinalAnswer2Test_shouldBe754018() {

    challenge = new Day13("ExampleData/Day13Example3.txt", false);

    //Correct answer given by AoC page.
    int expected = 754018;

    Assertions.assertEquals(expected, ((Day13) challenge).getTask2SolutionAsLong());
  }

  @Test
  void Part13FinalAnswer2Test_shouldBe779210() {

    challenge = new Day13("ExampleData/Day13Example4.txt", false);

    //Correct answer given by AoC page.
    int expected = 779210;

    Assertions.assertEquals(expected, ((Day13) challenge).getTask2SolutionAsLong());
  }

  @Test
  void Part13FinalAnswer2Test_shouldBe1261476() {

    challenge = new Day13("ExampleData/Day13Example5.txt", false);

    //Correct answer given by AoC page.
    int expected = 1261476;

    Assertions.assertEquals(expected, ((Day13) challenge).getTask2SolutionAsLong());
  }

  @Test
  void Part13FinalAnswer2Test_shouldBe1202161486() {

    challenge = new Day13("ExampleData/Day13Example6.txt", false);

    //Correct answer given by AoC page.
    int expected = 1202161486;

    Assertions.assertEquals(expected, ((Day13) challenge).getTask2SolutionAsLong());
  }

}