package com.AOC2020.Tasks;

import lombok.Data;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Filter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public @Data class Day14 extends AoCChallenge {

  private long task1SolutionAsLong, task2SolutionAsLong;

  public Day14(String overrideFileName) {
    super(overrideFileName);
  }

  public Day14(String overrideFileName, boolean oneNotTwo) {
    super(overrideFileName, oneNotTwo);
  }

  @Override
  protected void computeSolutionToTask1() {

    String[] inputData = fileReader.getInputDataAsLineArray();

    Pattern memPattern = Pattern.compile("^mem\\[([0-9]+)] = ([0-9]+)");

    HashMap<Integer, Long> memArray= new HashMap<>();
    BinaryFilter currentFilter = new BinaryFilter(inputData[0].substring(7));


    for (int i = 1; i < inputData.length; i++) {
      Matcher memMatcher = memPattern.matcher(inputData[i]);

      if (memMatcher.matches()) {
        Long valueToStore = currentFilter.convertNumber(Long.parseLong(memMatcher.group(2)));
        //System.out.println("Writing " + valueToStore + " to memory " + memMatcher.group(1));
        memArray.put(Integer.parseInt(memMatcher.group(1)), valueToStore);
      }
      else {
        currentFilter = new BinaryFilter(inputData[i].substring(7));
      }

    }

    long totalValueInMemory = 0;
    for (Integer key : memArray.keySet()) {
      totalValueInMemory += memArray.get(key);
    }

    task1SolutionAsLong = totalValueInMemory;

  }

  @Override
  protected void computeSolutionToTask2() {

    String[] inputData = fileReader.getInputDataAsLineArray();

    Pattern memPattern = Pattern.compile("^mem\\[([0-9]+)] = ([0-9]+)");

    HashMap<Long, Long> memArray= new HashMap<>();
    BinaryFilter currentFilter = new BinaryFilter(inputData[0].substring(7));

    for (int i = 1; i < inputData.length; i++) {
      Matcher memMatcher = memPattern.matcher(inputData[i]);

      if (memMatcher.matches()) {
        Long[] addressArray = currentFilter.convertMemory(Long.parseLong(memMatcher.group(1)));
        for (Long address : addressArray) {
          //System.out.println("Writing " + memMatcher.group(2) + " to memory " + address);
          memArray.put(address, Long.parseLong(memMatcher.group(2)));
        }
      }
      else {
        currentFilter = new BinaryFilter(inputData[i].substring(7));
      }
    }
    long totalValueInMemory = 0;
    for (Long key : memArray.keySet()) {
      totalValueInMemory += memArray.get(key);
    }

    task2SolutionAsLong = totalValueInMemory;


  }

  public long getTask1SolutionAsLong() {
    return task1SolutionAsLong;
  }

  public long getTask2SolutionAsLong() {
    return task2SolutionAsLong;
  }

  private class BinaryFilter {

    private final int maskLength = 36;

    private HashMap<Integer, Boolean> filterMap = new HashMap<>();
    private Integer floatingBits = 0;

    private Long[] allMaskSums;

    public BinaryFilter(String filterString) {
      //System.out.println("Filter: " + filterString);

      char[] filterChars = filterString.toCharArray();
      for (int i = 0; i < filterChars.length; i++) {

        if (filterChars[i] =='0') {
          filterMap.put((maskLength - 1) - i, false);
        }
        else if (filterChars[i] =='1') {
          filterMap.put((maskLength - 1) - i, true);
        }
        else {
          floatingBits++;
        }
      }
    }

    public long convertNumber(long number) {

      for (Integer key : filterMap.keySet()) {

        long testNumber = number >> key;
        if ((testNumber & 1L) == 1) {
          if (!filterMap.get(key)) {
            number -= Math.pow(2, key);
          }
        }
        else {
          if (filterMap.get(key)) {
            number += Math.pow(2, key);
          }
        }
      }
      return number;
    }

    public Long[] convertMemory(Long memoryNumber) {

      if (allMaskSums == null) {
        computeMaskSums();
      }

      for (int i = 0; i < maskLength; i++) {

        Boolean oneZeroOrFloating = filterMap.getOrDefault(i, null);
        //Determine the lowest value for this memory set.
        if (oneZeroOrFloating == null) {
          long memoryTest = memoryNumber >> i;
          if ((memoryTest & 1) == 1) {
            memoryNumber -= (long) Math.pow(2, i);
          }
        }
        //If the mask has a '1' flip the bit if it is 0.
        else if (oneZeroOrFloating) {
          long memoryTest = memoryNumber >> i;
          if ((memoryTest & 1) == 0) {
            memoryNumber += (long) Math.pow(2, i);
          }
        }
      }

      //get all sums from the floating bit values and add the lowest allowed address to each of them.
      Long[] possibleMemoryAddresses = allMaskSums.clone();
      for (int i = 0; i < allMaskSums.length; i++) {
          possibleMemoryAddresses[i] += memoryNumber;
      }

      return possibleMemoryAddresses;
    }

    private Long[] computeAllPartialSums(Long[] numbers) {

      if (numbers.length == 1) {
        return new Long[] {0L , numbers[0]};
      }
      else {
        Long[] smallerNumbers = Arrays.copyOfRange(numbers, 0, numbers.length - 1);
        Long[] lowerSums = computeAllPartialSums(smallerNumbers);

        Long[] sums = new Long[lowerSums.length * 2];
        for (int i = 0; i < lowerSums.length; i++) {
          sums[i] = lowerSums[i];
          sums[lowerSums.length + i] = lowerSums[i] + numbers[numbers.length - 1];
        }

        return sums;
      }
    }

    private void computeMaskSums() {

      Long[] floatingBitValues = new Long[floatingBits];
      Integer floatingBitPointer = 0;
      for (int i = 0; i < maskLength; i++) {
        if (!filterMap.containsKey(i)) {
          floatingBitValues[floatingBitPointer++] = (long) Math.pow(2, i);
        }
      }
      allMaskSums = computeAllPartialSums(floatingBitValues);
    }

  }


}
