package com.AOC2020.Utilities;

import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public @Data class AoCFileReader {

  //region <Fields>

  private String fileData;

  //endregion

  //region <Constructors>

  public AoCFileReader(String resourceFilePath) {

    File inputFile = new File("src/main/resources/" + resourceFilePath);
    try {

      fileData = new String(Files.readAllBytes(inputFile.toPath()));
    }
    catch (IOException e) {
      System.out.println("File: " + resourceFilePath + " not found.");
      System.exit(1);
    }

  }

  //endregion

  //region <Methods>

  public char[] getInputDataAsCharArray() {
    return fileData.toCharArray();
  }

  public String[] getInputDataAsLineArray() {
    return fileData.split("\\r?\\n");
  }

  public String[] getInputDataAsDelimitedArray(String delimiter) {
    return fileData.split(delimiter);
  }

  public Integer[] getInPutDataAsIntegerArray() {

    String[] intStrings = fileData.split("[\\r\\n,]+");
    Integer[] intInts = new Integer[intStrings.length];

    for (int i = 0; i < intStrings.length; i++) {
        intInts[i] = Integer.parseInt(intStrings[i]);
    }

    return intInts;

  }

  public Long[] getInPutDataAsLongArray() {

    String[] longStrings = fileData.split("[\\r\\n,]+");
    Long[] longLongs = new Long[longStrings.length];

    for (int i = 0; i < longStrings.length; i++) {
      longLongs[i] = Long.parseLong(longStrings[i]);
    }

    return longLongs;

  }



  //endregion


}
