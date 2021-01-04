package com.AOC2020.Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day15Test {

  private AoCChallenge challenge;

  @Test
  void Part15FinalAnswer1Test1_shouldBe1() {

    challenge = new Day15("ExampleData/Day15Example1.txt", true);

    //Correct answer given by AoC page.
    int expected = 1;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part15FinalAnswer1Test2_shouldBe10() {

    challenge = new Day15("ExampleData/Day15Example2.txt", true);

    //Correct answer given by AoC page.
    int expected = 10;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part15FinalAnswer1Test3_shouldBe27() {

    challenge = new Day15("ExampleData/Day15Example3.txt", true);

    //Correct answer given by AoC page.
    int expected = 27;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part15FinalAnswer1Test4_shouldBe78() {

    challenge = new Day15("ExampleData/Day15Example4.txt", true);

    //Correct answer given by AoC page.
    int expected = 78;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part15FinalAnswer1Test5_shouldBe438() {

    challenge = new Day15("ExampleData/Day15Example5.txt", true);

    //Correct answer given by AoC page.
    int expected = 438;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part15FinalAnswer1Test6_shouldBe1836() {

    challenge = new Day15("ExampleData/Day15Example6.txt", true);

    //Correct answer given by AoC page.
    int expected = 1836;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part15FinalAnswer1Test7_shouldBe436() {

    challenge = new Day15("ExampleData/Day15Example7.txt", true);

    //Correct answer given by AoC page.
    int expected = 436;

    Assertions.assertEquals(expected, challenge.getTask1Solution());
  }

  @Test
  void Part15FinalAnswer2Test7_shouldBe175594() {

    challenge = new Day15("ExampleData/Day15Example7.txt", false);

    //Correct answer given by AoC page.
    int expected = 175594;

    Assertions.assertEquals(expected, challenge.getTask2Solution());
  }

  @Test
  void Part15FinalAnswer2Test1_shouldBe2578() {

    challenge = new Day15("ExampleData/Day15Example1.txt", false);

    //Correct answer given by AoC page.
    int expected = 2578;

    Assertions.assertEquals(expected, challenge.getTask2Solution());
  }

  @Test
  void Part15FinalAnswer2Test1_shouldBe3544142() {

    challenge = new Day15("ExampleData/Day15Example2.txt", false);

    //Correct answer given by AoC page.
    int expected = 3544142;

    Assertions.assertEquals(expected, challenge.getTask2Solution());
  }

  @Test
  void Part15FinalAnswer2Test1_shouldBe261214() {

    challenge = new Day15("ExampleData/Day15Example3.txt", false);

    //Correct answer given by AoC page.
    int expected = 261214;

    Assertions.assertEquals(expected, challenge.getTask2Solution());
  }

  @Test
  void Part15FinalAnswer2Test1_shouldBe6895259() {

    challenge = new Day15("ExampleData/Day15Example4.txt", false);

    //Correct answer given by AoC page.
    int expected = 6895259;

    Assertions.assertEquals(expected, challenge.getTask2Solution());
  }

  @Test
  void Part15FinalAnswer2Test1_shouldBe18() {

    challenge = new Day15("ExampleData/Day15Example5.txt", false);

    //Correct answer given by AoC page.
    int expected = 18;

    Assertions.assertEquals(expected, challenge.getTask2Solution());
  }

  @Test
  void Part15FinalAnswer2Test1_shouldBe362() {

    challenge = new Day15("ExampleData/Day15Example6.txt", false);

    //Correct answer given by AoC page.
    int expected = 362;

    Assertions.assertEquals(expected, challenge.getTask2Solution());
  }

}