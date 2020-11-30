package com.AOC2020.Utilities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AoCFileReaderTest {

  private AoCFileReader simpleFileReader;
  private AoCFileReader multiLineFileReader;
  private AoCFileReader simpleDelimitedFileReader;

  @BeforeEach
  void initEach() {

    simpleFileReader = new AoCFileReader("Test Data/testDataABC.txt");
    multiLineFileReader = new AoCFileReader("Test Data/testData_Multiline.txt");
    simpleDelimitedFileReader = new AoCFileReader("Test Data/testData_Delimited.txt");

  }

  @Test
  void constructorTest_shouldBeTrue() {

    Assertions.assertEquals("ABC", simpleFileReader.getFileData());

  }

  @Test
  void getInputDataAsLineArrayTest_shouldBeTrue() {

    String[] expected = new String[] {"This is the first line.", "This is the second line.", "This is the third line."};

    Assertions.assertArrayEquals(expected, multiLineFileReader.getInputDataAsLineArray());
  }

  @Test
  void getInputDataAsCharArrayTest_shouldBeTrue() {

    char[] expected = new char[] {'A', 'B', 'C'};

    Assertions.assertArrayEquals(expected, simpleFileReader.getInputDataAsCharArray());

  }

  @Test
  void getInputDataAsDelimitedArrayTest_shouldBeTrue() {

    String[] expected = new String[] {"1", "2", "3"};

    Assertions.assertArrayEquals(expected, simpleDelimitedFileReader.getInputDataAsDelimitedArray(","));
  }

  @Test
  void getInputDataAsIntegerList_shouldBeTrue() {

    Integer[] expected = new Integer[] {1, 2, 3};

    Assertions.assertArrayEquals(expected, simpleDelimitedFileReader.getInPutDataAsIntegerArray());

  }



}