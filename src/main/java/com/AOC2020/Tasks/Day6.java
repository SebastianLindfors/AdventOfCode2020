package com.AOC2020.Tasks;

import lombok.Data;

import java.util.*;

public @Data class Day6 extends AoCChallenge {

  private int task1Solution, task2Solution;

  public Day6(String overrideFileName) {
    super(overrideFileName);
  }

  public Day6(String overrideFileName, boolean oneNotTwo) {
    super(overrideFileName, oneNotTwo);
  }

  @Override
  protected void computeSolutionToTask1() {

    String [] inputDataStrings = fileReader.getInputDataAsDelimitedArray("\r\n\r\n");
    int totalAnsweredQuestions = 0;

    for (String inputData : inputDataStrings) {
      List<Character> listOfCharacters = new ArrayList<>();

      String[] inputCharString = inputData.split("\r\n");
      for (String answerString: inputCharString) {
        for (Character answerCharacter : answerString.toCharArray()) {
          if (listOfCharacters.contains(answerCharacter)) {
            continue;
          }
          else {
            listOfCharacters.add(answerCharacter);
          }
        }
      }
      totalAnsweredQuestions += listOfCharacters.size();

    }

    task1Solution = totalAnsweredQuestions;

  }

  @Override
  protected void computeSolutionToTask2() {

    String [] inputDataStrings = fileReader.getInputDataAsDelimitedArray("\r\n\r\n");
    int totalAnsweredQuestions = 0;

    for (String inputDataString : inputDataStrings) {
      totalAnsweredQuestions += computeCommonElements(inputDataString);
    }

    task2Solution = totalAnsweredQuestions;
  }


  private int computeCommonElements(String inputData) {
    String[] splitInputData = inputData.split("\r\n");
    List<Character> commonElements = stringToCharList(splitInputData[0]);

    for (int i = 1; i < splitInputData.length; i++) {
      List<Character> compareList = stringToCharList(splitInputData[i]);
      commonElements.retainAll(compareList);
      if (commonElements.size() == 0) {
        return 0;
      }
    }
    return commonElements.size();
  }

  private List<Character> stringToCharList(String inputString) {
    List<Character> output = new ArrayList<>();
    for (Character character : inputString.toCharArray()) {
      output.add(character);
    }
    return  output;
  }

}
