package com.AOC2020.Tasks;

import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public @Data class Day18 extends AoCChallenge {

  private long task1SolutionAsLong, task2SolutionAsLong;

  public Day18(String overrideFileName) {
    super(overrideFileName);
  }

  public Day18(String overrideFileName, boolean oneNotTwo) {
    super(overrideFileName, oneNotTwo);
  }

  @Override
  protected void computeSolutionToTask1() {

    String[] inputData = fileReader.getInputDataAsLineArray();
    long[] answers = new long[inputData.length];

    for (int i = 0; i < inputData.length; i++) {
      answers[i] = Long.parseLong(evaluate(inputData[i]));
    }

    long sumOfAnswers = 0;
    for (long answer : answers) {
      sumOfAnswers += answer;
    }

    task1SolutionAsLong = sumOfAnswers;

  }

  @Override
  protected void computeSolutionToTask2() {

    String[] inputData = fileReader.getInputDataAsLineArray();
    long[] answers = new long[inputData.length];

    for (int i = 0; i < inputData.length; i++) {
      answers[i] = Long.parseLong(evaluateMore(inputData[i]));
    }

    long sumOfAnswers = 0;
    for (long answer : answers) {
      sumOfAnswers += answer;
    }

    task2SolutionAsLong = sumOfAnswers;

  }

  public long getTask1SolutionAsLong() {
    return task1SolutionAsLong;
  }

  public long getTask2SolutionAsLong() {
    return task2SolutionAsLong;
  }

  private String evaluate(String originalExpression) {

    String simplifiedExpression = originalExpression;
    int openingParenthesisIndex = simplifiedExpression.indexOf('(');
    while   (openingParenthesisIndex != -1) {
     int closingParenthesisIndex = findClosingParenthesisIndex(simplifiedExpression, openingParenthesisIndex);
      String temporaryExpression = evaluate(simplifiedExpression.substring(openingParenthesisIndex + 1, closingParenthesisIndex - 1));

      simplifiedExpression = simplifiedExpression.substring(0,openingParenthesisIndex) + temporaryExpression + simplifiedExpression.substring(closingParenthesisIndex);
      openingParenthesisIndex = simplifiedExpression.indexOf('(');
    }

    while(true) {

      Pattern mathPattern = Pattern.compile("^([0-9]+) ([+*]) ([0-9]+)");
      Matcher mathMatcher = mathPattern.matcher(simplifiedExpression);

      if (mathMatcher.find()) {
        long firstNumber = Long.parseLong(mathMatcher.group(1));
        long secondNumber = Long.parseLong(mathMatcher.group(3));
        long answer;

        if (mathMatcher.group(2).equals("+")) {
          answer = firstNumber + secondNumber;
        } else {
          answer = firstNumber * secondNumber;
        }
        String temporaryExpression = answer + simplifiedExpression.substring(mathMatcher.end());
        simplifiedExpression = temporaryExpression;

      }
      else {
        return simplifiedExpression;
      }
    }
  }

  private String evaluateMore(String originalExpression) {

    String simplifiedExpression = originalExpression;
    int openingParenthesisIndex = simplifiedExpression.indexOf('(');
    while   (openingParenthesisIndex != -1) {
      int closingParenthesisIndex = findClosingParenthesisIndex(simplifiedExpression, openingParenthesisIndex);
      String temporaryExpression = evaluateMore(simplifiedExpression.substring(openingParenthesisIndex + 1, closingParenthesisIndex - 1));

      simplifiedExpression = simplifiedExpression.substring(0,openingParenthesisIndex) + temporaryExpression + simplifiedExpression.substring(closingParenthesisIndex);
      openingParenthesisIndex = simplifiedExpression.indexOf('(');
    }

    Pattern additionPattern = Pattern.compile("([0-9]+) \\+ ([0-9]+)");
    Pattern multiplicationPattern = Pattern.compile("([0-9]+) \\* ([0-9]+)");

    while(true) {

      Matcher additionMatcher = additionPattern.matcher(simplifiedExpression);
      Matcher multiplicationMatcher = multiplicationPattern.matcher(simplifiedExpression);

      if (additionMatcher.find()) {
        long firstNumber = Long.parseLong(additionMatcher.group(1));
        long secondNumber = Long.parseLong(additionMatcher.group(2));
        long answer = firstNumber + secondNumber;

        String temporaryExpression = simplifiedExpression.substring(0, additionMatcher.start()) + answer + simplifiedExpression.substring(additionMatcher.end());
        simplifiedExpression = temporaryExpression;

      }
      else if (multiplicationMatcher.find()) {
        long firstNumber = Long.parseLong(multiplicationMatcher.group(1));
        long secondNumber = Long.parseLong(multiplicationMatcher.group(2));
        long answer = firstNumber * secondNumber;

        String temporaryExpression = simplifiedExpression.substring(0, multiplicationMatcher.start()) + answer + simplifiedExpression.substring(multiplicationMatcher.end());
        simplifiedExpression = temporaryExpression;

      }
      else {
        return simplifiedExpression;
      }


      }
    }

  private int findClosingParenthesisIndex(String parenthesisString, int openingParenthesisIndex) {

    int numberOfOpenBrackets = 0;
    int stringPointer = openingParenthesisIndex;

    do {
      if (parenthesisString.charAt(stringPointer) == '(') {
        numberOfOpenBrackets++;
      }
      else if (parenthesisString.charAt(stringPointer) == ')') {
        numberOfOpenBrackets--;
      }
      stringPointer++;
    } while (numberOfOpenBrackets != 0);

    return stringPointer;
  }

}
