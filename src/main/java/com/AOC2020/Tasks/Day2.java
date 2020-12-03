package com.AOC2020.Tasks;

import lombok.Data;

public @Data class Day2 extends AoCChallenge {

  private int task1Solution, task2Solution;

  public Day2(String overrideFileName) {
    super(overrideFileName);
  }

  public Day2(String overrideFileName, boolean oneNotTwo) {
    super(overrideFileName, oneNotTwo);
  }

  protected void computeSolutionToTask1() {

    int numberOfVerifiedPasswords = 0;
    String[] inputData = fileReader.getInputDataAsLineArray();
    for (int i = 0; i < inputData.length; i++) {
      String policyString = inputData[i].split(":")[0];
      String passwordString = inputData[i].split(":")[1]
                              .stripLeading();

      PasswordPolicy passwordPolicy = new PasswordPolicy(policyString);
      if(passwordPolicy.verifyPasswordTask1(passwordString)) {
        numberOfVerifiedPasswords++;
      }
    }

    task1Solution = numberOfVerifiedPasswords;
    System.out.println("Solution to task 1: " + task1Solution);
  }

  protected void computeSolutionToTask2() {

    int numberOfVerifiedPasswords = 0;
    String[] inputData = fileReader.getInputDataAsLineArray();
    for (int i = 0; i < inputData.length; i++) {
      String policyString = inputData[i].split(":")[0];
      String passwordString = inputData[i].split(":")[1]
          .stripLeading();

      PasswordPolicy passwordPolicy = new PasswordPolicy(policyString);
      if(passwordPolicy.verifyPasswordTask2(passwordString)) {
        numberOfVerifiedPasswords++;
      }
    }

    task2Solution = numberOfVerifiedPasswords;
    System.out.println("Solution to task 2: " + task2Solution);
  }


  private class PasswordPolicy {

    private char policyChar;

    private int lowerBound;
    private int upperBound;

    public PasswordPolicy(String policyString) {

        String[] policyDataArray = policyString.split("[- ]");

        lowerBound = Integer.parseInt(policyDataArray[0]);
        upperBound = Integer.parseInt(policyDataArray[1]);

        policyChar = policyDataArray[2].charAt(0);

        //System.out.printf("New Password policy created! Lower bound: %d, Upper bound: %d and Policy Character: %c\n",
        //                  lowerBound, upperBound, policyChar);

    }

    protected boolean verifyPasswordTask1(String password) {

      char[] passwordCharArray = password.toCharArray();
      int counter = 0;
      for (int i = 0; i < passwordCharArray.length; i++) {
        if (passwordCharArray[i] == policyChar) {
          counter++;
        }
      }
      return (lowerBound <= counter && counter <= upperBound);
    }

    protected boolean verifyPasswordTask2(String password) {

      System.out.println("Verifying password: '" + password + "'");

      char[] passwordCharArray = password.toCharArray();
      return (passwordCharArray[lowerBound - 1] == policyChar ^ passwordCharArray[upperBound - 1] == policyChar);
    }

  }
}
