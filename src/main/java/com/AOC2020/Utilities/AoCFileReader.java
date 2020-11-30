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

  char[] getInputDataAsCharArray() {
    return fileData.toCharArray();
  }

  String[] getInputDataAsLineArray() {
    return fileData.split("\\r?\\n");
  }

  String[] getInputDataAsDelimitedArray(String delimiter) {
    return fileData.split(delimiter);
  }

  Integer[] getInPutDataAsIntegerArray() {

    String[] intStrings = fileData.split(",");
    Integer[] intInts = new Integer[intStrings.length];

    for (int i = 0; i < intStrings.length; i++) {
        intInts[i] = Integer.parseInt(intStrings[i]);
    }

    return intInts;

  }

  //endregion


}
