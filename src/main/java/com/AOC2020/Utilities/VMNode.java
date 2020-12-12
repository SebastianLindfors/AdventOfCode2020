package com.AOC2020.Utilities;

import lombok.Data;

public @Data class VMNode {

  private String instruction;

  private int value;

  private boolean visited;

  public VMNode(String instruction, int value) {

    this.instruction = instruction;
    this.value = value;

  }

}
