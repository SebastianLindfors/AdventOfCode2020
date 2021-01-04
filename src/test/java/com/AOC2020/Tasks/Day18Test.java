package com.AOC2020.Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day18Test {

  private AoCChallenge challenge;

  @Test
  void Part18FinalAnswer1Test1_shouldBe71() {

    challenge = new Day18("ExampleData/Day18Example1.txt", true);

    //Correct answer given by AoC page.
    int expected = 71;

    Assertions.assertEquals(expected, ((Day18) challenge).getTask1SolutionAsLong());
  }

  @Test
  void Part18FinalAnswer1Test2_shouldBe51() {

    challenge = new Day18("ExampleData/Day18Example2.txt", true);

    //Correct answer given by AoC page.
    int expected = 51;

    Assertions.assertEquals(expected, ((Day18) challenge).getTask1SolutionAsLong());
  }

  @Test
  void Part18FinalAnswer1Test3_shouldBe26() {

    challenge = new Day18("ExampleData/Day18Example3.txt", true);

    //Correct answer given by AoC page.
    int expected = 26;

    Assertions.assertEquals(expected, ((Day18) challenge).getTask1SolutionAsLong());
  }

  @Test
  void Part18FinalAnswer1Test4_shouldBe437() {

    challenge = new Day18("ExampleData/Day18Example4.txt", true);

    //Correct answer given by AoC page.
    int expected = 437;

    Assertions.assertEquals(expected, ((Day18) challenge).getTask1SolutionAsLong());
  }

  @Test
  void Part18FinalAnswer1Test5_shouldBe12240() {

    challenge = new Day18("ExampleData/Day18Example5.txt", true);

    //Correct answer given by AoC page.
    int expected = 12240;

    Assertions.assertEquals(expected, ((Day18) challenge).getTask1SolutionAsLong());
  }

  @Test
  void Part18FinalAnswer1Test6_shouldBe13632() {

    challenge = new Day18("ExampleData/Day18Example6.txt", true);

    //Correct answer given by AoC page.
    int expected = 13632;

    Assertions.assertEquals(expected, ((Day18) challenge).getTask1SolutionAsLong());
  }

  @Test
  void Part18FinalAnswer2Test1_shouldBe231() {

    challenge = new Day18("ExampleData/Day18Example1.txt", false);

    //Correct answer given by AoC page.
    int expected = 231;

    Assertions.assertEquals(expected, ((Day18) challenge).getTask2SolutionAsLong());
  }

  @Test
  void Part18FinalAnswer2Test2_shouldBe51() {

    challenge = new Day18("ExampleData/Day18Example2.txt", false);

    //Correct answer given by AoC page.
    int expected = 51;

    Assertions.assertEquals(expected, ((Day18) challenge).getTask2SolutionAsLong());
  }

  @Test
  void Part18FinalAnswer2Test3_shouldBe46() {

    challenge = new Day18("ExampleData/Day18Example3.txt", false);

    //Correct answer given by AoC page.
    int expected = 46;

    Assertions.assertEquals(expected, ((Day18) challenge).getTask2SolutionAsLong());
  }

  @Test
  void Part18FinalAnswer2Test4_shouldBe1445() {

    challenge = new Day18("ExampleData/Day18Example4.txt", false);

    //Correct answer given by AoC page.
    int expected = 1445;

    Assertions.assertEquals(expected, ((Day18) challenge).getTask2SolutionAsLong());
  }

  @Test
  void Part18FinalAnswer2Test5_shouldBe669060() {

    challenge = new Day18("ExampleData/Day18Example5.txt", false);

    //Correct answer given by AoC page.
    int expected = 669060;

    Assertions.assertEquals(expected, ((Day18) challenge).getTask2SolutionAsLong());
  }

  @Test
  void Part18FinalAnswer2Test6_shouldBe23340() {

    challenge = new Day18("ExampleData/Day18Example6.txt", false);

    //Correct answer given by AoC page.
    int expected = 23340;

    Assertions.assertEquals(expected, ((Day18) challenge).getTask2SolutionAsLong());
  }
}