package com.AOC2020.Tasks;

import lombok.Data;

import javax.print.attribute.HashAttributeSet;
import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public @Data class Day16 extends AoCChallenge {

  private int task1Solution;
  private long task2SolutionAsLong;

  public Day16(String overrideFileName) {
    super(overrideFileName);
  }

  public Day16(String overrideFileName, boolean oneNotTwo) {
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

    String[] fieldStrings = Arrays.copyOfRange(inputData, 0, breakPoint);
    String[] nearbyTicketStrings = Arrays.copyOfRange(inputData, breakPoint + 5, inputData.length);

    Integer totalInvalidTicketValues = 0;
    TicketFields ticketFields = new TicketFields(fieldStrings);
    for (String nearbyTicketString : nearbyTicketStrings) {

      String[] nearbyTicketValueStrings = nearbyTicketString.split(",");

      Integer[] nearbyTicketValues = new Integer[nearbyTicketValueStrings.length];
      for (int i = 0; i < nearbyTicketValues.length; i++) {
        nearbyTicketValues[i] = Integer.parseInt(nearbyTicketValueStrings[i]);
      }

      TrainTicket currentTrainTicket = new TrainTicket(nearbyTicketValues, ticketFields);
      totalInvalidTicketValues += currentTrainTicket.invalidSum;
    }

    task1Solution = totalInvalidTicketValues;

  }

  @Override
  protected void computeSolutionToTask2() {

    //region <Input Parsing>

    String[] inputData = fileReader.getInputDataAsLineArray();
    int breakPoint = -1;

    for (int i = 0; i < inputData.length; i++) {
      if (inputData[i].equals("")) {
        breakPoint = i;
        break;
      }
    }

    String[] fieldStrings = Arrays.copyOfRange(inputData, 0, breakPoint);
    String[] nearbyTicketStrings = Arrays.copyOfRange(inputData, breakPoint + 5, inputData.length);

    TrainTicket[] nearbyTicketArray = new TrainTicket[nearbyTicketStrings.length];
    int nearbyTicketPointer = 0;

    TicketFields ticketFields = new TicketFields(fieldStrings);
    for (String nearbyTicketString : nearbyTicketStrings) {

      String[] nearbyTicketValueStrings = nearbyTicketString.split(",");

      Integer[] nearbyTicketValues = new Integer[nearbyTicketValueStrings.length];
      for (int i = 0; i < nearbyTicketValues.length; i++) {
        nearbyTicketValues[i] = Integer.parseInt(nearbyTicketValueStrings[i]);
      }

      nearbyTicketArray[nearbyTicketPointer++] = new TrainTicket(nearbyTicketValues, ticketFields);
    }

    String yourTicketString = inputData[breakPoint + 2];
    String[] yourTicketValueStrings = yourTicketString.split(",");

    Integer[] yourTicketValues = new Integer[yourTicketValueStrings.length];
    for (int i = 0; i < yourTicketValueStrings.length; i++) {
      yourTicketValues[i] = Integer.parseInt(yourTicketValueStrings[i]);
    }

    TrainTicket yourTicket = new TrainTicket(yourTicketValues, ticketFields);

    TrainTicketCollection trainTicketCollection = new TrainTicketCollection(ticketFields, yourTicket, nearbyTicketArray);

    //endregion

    trainTicketCollection.fillListOfValidFieldsArray();

    long departureTotal = 1;
    for (int i = 0; i < trainTicketCollection.listOfValidFieldsArray.length; i++) {
      for (Integer value : trainTicketCollection.listOfValidFieldsArray[i]) {
        if (ticketFields.fieldNames[value].contains("departure")) {
          departureTotal *= yourTicket.ticketValues[i];
        }
      }
    }

    task2SolutionAsLong = departureTotal;
  }

  public long getTask2SolutionAsLong() {
    return task2SolutionAsLong;
  }

  private class TrainTicketCollection {

    private TicketFields ticketFields;

    private List<Integer>[] listOfValidFieldsArray;

    private TrainTicket yourTicket;
    private TrainTicket[] nearbyTickets;

    public TrainTicketCollection(TicketFields ticketFields, TrainTicket yourTicket, TrainTicket[] nearbyTickets) {

      this.yourTicket = yourTicket;
      this.nearbyTickets = nearbyTickets;

      this.ticketFields = ticketFields;





    }

    boolean isFieldValidForValue(int fieldNumber, int valueNumber) {

      if (!ticketFields.fieldLimits.containsKey(fieldNumber)) {
        throw new IllegalArgumentException("Fieldnumber " + fieldNumber + "not recognised");
      }

      Integer[][] fieldLimits = ticketFields.fieldLimits.get(fieldNumber);
      for (TrainTicket nearbyTicket : nearbyTickets) {

        if (!nearbyTicket.isValid) {
          continue;
        }

        Integer ticketFieldValue = nearbyTicket.ticketValues[valueNumber];
        boolean valid = false;
        for (int i = 0; i < fieldLimits.length; i++) {
          if ( fieldLimits[0][i] <= ticketFieldValue && ticketFieldValue <= fieldLimits[1][i]) {
            valid = true;
          }
        }
        if (valid == false) {
          return false;
        }
      }

      return true;
    }

    List<Integer> getAllValidFieldsForValue(int valueNumber) {

      List<Integer> outputList = new ArrayList<>();
      for (Integer fieldNumber : ticketFields.fieldLimits.keySet()) {
        if (isFieldValidForValue(fieldNumber, valueNumber)) {
          outputList.add(fieldNumber);
        }
      }
      return outputList;
    }

    private void fillListOfValidFieldsArray() {

      listOfValidFieldsArray = new List[ticketFields.fieldNames.length];
      for (int i = 0; i < listOfValidFieldsArray.length; i++) {
        listOfValidFieldsArray[i] = new ArrayList<>();
      }

      for (int i = 0; i < listOfValidFieldsArray.length; i++) {
        listOfValidFieldsArray[i] = getAllValidFieldsForValue(i);
      }

      boolean changed = true;
      while(changed == true) {
        changed = false;

        for (int i = 0; i < listOfValidFieldsArray.length; i++) {
          if (listOfValidFieldsArray[i].size() == 1) {
            for (int j = 0; j < listOfValidFieldsArray.length; j++) {
              if (i == j) {
                continue;
              }

              int valueToBeRemoved = listOfValidFieldsArray[i].get(0);
              int  indexOfRemoval = listOfValidFieldsArray[j].indexOf(valueToBeRemoved);
              if (indexOfRemoval != -1) {
                changed = true;
                listOfValidFieldsArray[j].remove(indexOfRemoval);
              }




            }
          }
        }
      }


    }

  }

  private class TrainTicket {

    private boolean isValid;
    private boolean[] validValues;

    private Integer invalidSum = 0;
    private Integer[] ticketValues;


    private TicketFields ticketFields;

    TrainTicket(Integer[] ticketValues, TicketFields ticketFields) {

      this.ticketValues = ticketValues;
      this.ticketFields = ticketFields;
      this.validValues = new boolean[ticketValues.length];

      validateTicketValues();


    }

    private void validateTicketValues() {
      for (int i = 0; i < ticketValues.length; i++) {
        validValues[i] = ticketFields.validateValueAgainstAllFields(ticketValues[i]);
        if (!validValues[i]) {
          invalidSum += ticketValues[i];
        }

      }

      isValid = true;
      for (boolean valid : validValues) {
        if (!valid) {
          isValid = false;
        }
      }


    }
  }

  private  class TicketFields {

    private HashMap<Integer, Integer[][]> fieldLimits = new HashMap<>();

    private String[] fieldNames;
    private int fieldNamesPointer = 0;

    TicketFields(String[] inputData) {

      Pattern fieldPattern = Pattern.compile("^([a-z ]+): (.+)$");
      Pattern limitsPattern = Pattern.compile("[0-9]+-[0-9]+");

      fieldNames = new String[inputData.length];

      for (String fieldString : inputData) {

        Matcher fieldMatcher = fieldPattern.matcher(fieldString.strip());

        if (fieldMatcher.matches()) {

          String[] limits = limitsPattern
              .matcher(fieldString)
              .results()
              .map(MatchResult::group)
              .toArray(String[]::new);

          Integer[] intLowLimits = new Integer[limits.length];
          Integer[] intHighLimits = new Integer[limits.length];
          for (int i = 0; i < limits.length; i++) {
            int dashIndex = limits[i].indexOf('-');
            intLowLimits[i] = Integer.parseInt(limits[i].substring(0,dashIndex));
            intHighLimits[i] = Integer.parseInt(limits[i].substring(dashIndex + 1));
          }

          Integer[][] limitArray = new Integer[2][limits.length];
          limitArray[0] = intLowLimits;
          limitArray[1] = intHighLimits;

          fieldLimits.put(fieldNamesPointer, limitArray);

          fieldNames[fieldNamesPointer++] = fieldMatcher.group(1);

        } else { throw new IllegalArgumentException("Could not create a ticket field from line '" + fieldString + "'."); }



      }


    }

    boolean validateValueAgainstAllFields(int value) {

      for (Integer key : fieldLimits.keySet()) {
        if(validateValueAgainstSpecificField(value, key)) {
          return true;
        }
      }
      return false;
    }

    private boolean validateValueAgainstSpecificField(int value, int fieldKey) {

      if (!fieldLimits.containsKey(fieldKey)) {
        throw new IllegalArgumentException("Could not find a limit value for value: " + fieldKey);
      }

      Integer[][] limitArray = fieldLimits.get(fieldKey);
      for (int i = 0; i < limitArray[0].length; i++) {
          if (limitArray[0][i] <= value && value <= limitArray[1][i]) {
            return true;
          }
      }
      return false;
    }

  }

}

