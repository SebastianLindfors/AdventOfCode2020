package com.AOC2020.Tasks;

import lombok.Data;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;


public @Data class Day19 extends AoCChallenge{

  private int task1Solution, task2Solution;

  public Day19(String overrideFileName) {
    super(overrideFileName);
  }

  public Day19(String overrideFileName, boolean oneNotTwo) {
    super(overrideFileName, oneNotTwo);
  }

  @Override
  protected void computeSolutionToTask1() {

    String[] inputData = fileReader.getInputDataAsLineArray();

    int breakPoint = -1;
    for (int i = 0; i < inputData.length; i++) {
      if (inputData[i].equals("")) {
        breakPoint = i;
        break;
      }
    }

    String[] ruleLines = Arrays.copyOfRange(inputData, 0, breakPoint);
    String[] messageLines = Arrays.copyOfRange(inputData, breakPoint + 1, inputData.length);

    HashMap<String, MessageRule> messageRules = new HashMap<>();
    for (String ruleLine : ruleLines) {
      new MessageRule(ruleLine, messageRules);
    }


    while(messageRules.get("0").getValidStringsNonRecursive() == null) {

      for ( MessageRule messageRule : messageRules.values())
      {
        if (messageRule.getValidStringsNonRecursive() == null) {
          messageRule.computeValidStringsArrayNonRecursive();
        }
      }

    }

    String[] validMessages = messageRules.get("0").getValidStringsNonRecursive();
    int validMessageLength = validMessages[0].length();

    int totalValidMessages = 0;
    for (String message : messageLines) {
      if (message.length() != validMessageLength) {
        continue;
      }
      for (String ruleString : validMessages) {
        if (message.equals(ruleString)) {
          totalValidMessages++;
        }
      }

      task1Solution = totalValidMessages;
    }

  }

  @Override
  protected void computeSolutionToTask2() {

  }

  private class MessageRule {

    String ruleId;

    HashMap<String, MessageRule> rulesMap;

    String[] subRuleStrings;
    String [] validStrings = new String[0];


    MessageRule(String newRuleString, HashMap<String, MessageRule> rulesMap) {

      this.rulesMap = rulesMap;

      int spaceIndex = newRuleString.indexOf(" ");

      ruleId = newRuleString.substring(0,spaceIndex - 1);

      subRuleStrings = newRuleString.substring(spaceIndex).split("\\|");

      for (int i = 0; i < subRuleStrings.length; i++) {
        subRuleStrings[i] = subRuleStrings[i].strip();
      }

      rulesMap.put(ruleId, this);

    }

    String[] getValidStringsNonRecursive() {
      if (validStrings.length == 0) {
        return null;
      }
      return validStrings;
    }

    private void computeValidStringsArrayNonRecursive() {

      if (subRuleStrings[0].charAt(0) == '"') {
        validStrings = new String[] { subRuleStrings[0].substring(1,2)};
        return;
      }

      String [] tempValidStrings = new String[0];

      for (int i = 0; i < subRuleStrings.length; i++) {

        int neededLength = (int) subRuleStrings[i].chars().filter(ch -> ch == ' ').count();
        String[][] subStrings = new String[neededLength + 1][];
        int subRuleStringIndex = 0;
        int substringCounter = 0;
        while (subRuleStringIndex < subRuleStrings[i].length()) {
          int nexSpaceIndex = subRuleStrings[i].indexOf(" ", subRuleStringIndex);

          if (nexSpaceIndex != -1) {
            subStrings[substringCounter] = rulesMap.get(subRuleStrings[i].substring(subRuleStringIndex, nexSpaceIndex)).getValidStringsNonRecursive();
            if (subStrings[substringCounter] == null) {
              return;
            }
          }
          else {
            subStrings[substringCounter] = rulesMap.get(subRuleStrings[i].substring(subRuleStringIndex)).getValidStringsNonRecursive();
            if (subStrings[substringCounter] == null) {
              return;
            }
          }
          substringCounter++;

          if (nexSpaceIndex == -1) {
            break;
          }

          subRuleStringIndex = nexSpaceIndex + 1;
        }

        int product = 1;
        for (int j = 0; j < subStrings.length; j++) {
          product *= subStrings[j].length;
        }

        int[] counter = new int[subStrings.length];
        String[] outputStrings = new String[product];
        int outputPointer = 0;

        boolean finished = false;
        while(!finished) {

          String outputString = "";
          for (int j = 0; j < counter.length; j++) {
            outputString += subStrings[j][counter[j]];
          }
          outputStrings[outputPointer++] = outputString;

          int counterPointer = counter.length - 1;
          while(counterPointer >= 0) {
            counter[counterPointer]++;
            if (counter[counterPointer] == subStrings[counterPointer].length) {
              if (counterPointer == 0) {
                finished = true;
              }
              counter[counterPointer] = 0;
              counterPointer--;
            }
            else {
              break;
            }
          }
        }
        tempValidStrings = ArrayUtils.addAll(tempValidStrings, outputStrings);
      }

      validStrings = tempValidStrings;
    }
  }

}
