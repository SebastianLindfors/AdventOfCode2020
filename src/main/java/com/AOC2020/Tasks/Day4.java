package com.AOC2020.Tasks;

import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public @Data class Day4 extends AoCChallenge{

  private int task1Solution, task2Solution;

  public Day4(String overrideFileName) {
    super(overrideFileName);
  }

  public Day4(String overrideFileName, boolean oneNotTwo) {
    super(overrideFileName, oneNotTwo);
  }

  @Override
  protected void computeSolutionToTask1() {

     String [] inputData = fileReader.getInputDataAsDelimitedArray("\r\n\r\n");

     int validPassports = 0;

     for (String passportString : inputData) {
       Passport currentPassport = new Passport(passportString);
/*       System.out.printf("Passport Crated: \n Birth Year %s \n Issue Year: %s \n Expiration Year: %s \n Height: %s \n" +
            " Hair Colour: %s \n Eye Colour: %s \n Passport ID: %s \n Country ID: %s \n",
           currentPassport.passportInfo[0], currentPassport.passportInfo[1], currentPassport.passportInfo[2],
           currentPassport.passportInfo[3], currentPassport.passportInfo[4], currentPassport.passportInfo[5],
           currentPassport.passportInfo[6], currentPassport.passportInfo[7]);*/

       if (currentPassport.validateTask1()) {
         validPassports += 1;;
       }
     }

     task1Solution = validPassports;
  }

  @Override
  protected void computeSolutionToTask2() {

    String [] inputData = fileReader.getInputDataAsDelimitedArray("\r\n\r\n");

    int validPassports = 0;

    for (String passportString : inputData) {
      Passport currentPassport = new Passport(passportString);
/*      System.out.printf("Passport Crated: \n Birth Year %s \n Issue Year: %s \n Expiration Year: %s \n Height: %s \n" +
              " Hair Colour: %s \n Eye Colour: %s \n Passport ID: %s \n Country ID: %s \n",
          currentPassport.passportInfo[0], currentPassport.passportInfo[1], currentPassport.passportInfo[2],
          currentPassport.passportInfo[3], currentPassport.passportInfo[4], currentPassport.passportInfo[5],
          currentPassport.passportInfo[6], currentPassport.passportInfo[7]);*/

      if (currentPassport.validateTask2()) {
        validPassports += 1;;
      }
    }

    task2Solution = validPassports;

  }

  private class Passport {

    String[] passportInfo = new String[8];
    // 0 = Birth Year, 1 = Issue Year, 2 = Expiration Year, 3 = height,
    // 4 = Hair Colour, 5 = Eye Colour, 6 = Passport ID, 7 = Country ID

    public Passport(String passportDataString) {

      parseInputString(passportDataString);


    }

    private void parseInputString(String inputString) {

      String[] splitInputStringArray = inputString.split("[(\r\n) ]");


      for (int i = 0; i < splitInputStringArray.length; i++) {
        if (splitInputStringArray[i].matches("^\\s*$")) {
          continue;
        }
        String[] dataArray = splitInputStringArray[i].split(":");
        switch (dataArray[0]) {
          case "byr":
            passportInfo[0] = dataArray[1];
            break;
          case "iyr":
            passportInfo[1] = dataArray[1];
            break;
          case "eyr":
            passportInfo[2] = dataArray[1];
            break;
          case "hgt":
            passportInfo[3] = dataArray[1];
            break;
          case "hcl":
            passportInfo[4] = dataArray[1];
            break;
          case "ecl":
            passportInfo[5] = dataArray[1];
            break;
          case "pid":
            passportInfo[6] = dataArray[1];
            break;
          case "cid":
            passportInfo[7] = dataArray[1];
            break;
          default:
            System.out.println("Did not recognise data type: '" + dataArray[0] + "'" );
        }
      }

    }

    public boolean validateTask1() {
      for (int i = 0; i < 7; i++) {
        if (passportInfo[i] == null) {
          System.out.println("Data field " + i + " missing, passport is invalid");
          return false;
        }
      }
      return true;
    }

    public boolean validateTask2() {

      for (int i = 0; i < 7; i++) {
        if (passportInfo[i] == null) { return false; }
      }

      if (!this.validateBirthYear()) {
        System.out.println("Invalid Birth Year: " + passportInfo[0]);
        return false;
      }
      else if (!this.validateIssueYear()) {
        System.out.println("Invalid Issue Year: " + passportInfo[1]);
        return false;
      }
      else if (!this.validateExpirationYear()) {
        System.out.println("Invalid Expiration Year: " + passportInfo[2]);
        return false;
      }
      else if (!this.validateHeight()) {
        System.out.println("Invalid Height: " + passportInfo[3]);
        return false;}
      else if (!this.validateHairColour()) {
        System.out.println("Invalid Hair Colour: " + passportInfo[4]);
        return false;
      }
      else if (!this.validateEyeColour()) {
        System.out.println("Invalid Eye Colour: " + passportInfo[5]);
        return false;
      }
      else if (!this.validatePassportId()) {
        System.out.println("Invalid Passport ID: " + passportInfo[6]);
        return false;
      }

      return true;
    }

    private boolean validateBirthYear() {

      String birthYear = passportInfo[0];

      if (birthYear.length() != 4) {
        return false;
      }
      else if (Integer.parseInt(birthYear) < 1920 || Integer.parseInt(birthYear) > 2002) {
        return false;
      }
      else {return  true;}
    }

    private boolean validateIssueYear() {

      String issueYear = passportInfo[1];

      if (issueYear.length() != 4) {
        return false;
      }
      else if (Integer.parseInt(issueYear) < 2010 || Integer.parseInt(issueYear) > 2020) {
        return false;
      }
      else {return  true;}
    }

    private boolean validateExpirationYear() {

      String expirationYear = passportInfo[2];

      if (expirationYear.length() != 4) {
        return false;
      }
      else if (Integer.parseInt(expirationYear) < 2010 || Integer.parseInt(expirationYear) > 2030) {
        return false;
      }
      else {return  true;}
    }

    private boolean validateHeight() {

      String heightString = passportInfo[3];

      Pattern heightPattern = Pattern.compile("([0-9]+)(cm|in)");
      Matcher heightMatcher = heightPattern.matcher(heightString);
      if (!heightMatcher.matches()) {return false;}

      int heightValue = Integer.parseInt(heightMatcher.group(1));

      if (heightMatcher.group(2).equals("in")) {
        if (heightValue < 59 || heightValue > 76) {
          return false;
        }
      }
      else {
        if (heightValue < 150 || heightValue > 193) {
          return false;
        }
      }
       return true;
    }

    private boolean validateHairColour() {

      String hairColourString = passportInfo[4];

      Pattern hairColourPattern = Pattern.compile("^#[a-f0-9]{6}$");
      Matcher hairColourMatcher = hairColourPattern.matcher(hairColourString);
      if (!hairColourMatcher.matches()) { return false; }

      return true;
    }

    private boolean validateEyeColour() {

      String eyeColourString = passportInfo[5];

      Pattern eyeColourPattern = Pattern.compile("^(amb|blu|brn|gry|grn|hzl|oth)$");

      Matcher eyeColourMatcher = eyeColourPattern.matcher(eyeColourString);
      if (!eyeColourMatcher.matches()) { return false; }

      return true;
    }

    private boolean validatePassportId() {

      String passportIdString = passportInfo[6];

      Pattern passportIdPattern = Pattern.compile("^[0-9]{9}$");

      Matcher passportIdMatcher = passportIdPattern.matcher(passportIdString);
      if (!passportIdMatcher.matches()) { return false; }

      return true;

    }



  }

}
