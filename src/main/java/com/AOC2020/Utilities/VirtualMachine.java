package com.AOC2020.Utilities;

import lombok.Data;

public @Data class VirtualMachine {

  private boolean looping;

  private VMNode[] instructionSet;

  private int accumulator = 0;
  private int instructionPointer = 0;

  public VirtualMachine(VMNode[] instructionSet) {
    this.instructionSet = instructionSet;
  }

  public void executeProgram() {

    while (true) {

      if (instructionSet[instructionPointer].isVisited()) {
        looping = true;
        break;
      }

      executeNode(instructionSet[instructionPointer]);

      if (instructionPointer == instructionSet.length) {
        looping = false;
        break;
      }
    }
  }

  public void reset() {
    accumulator = 0;
    instructionPointer = 0;

    for (VMNode node : instructionSet) {
      node.setVisited(false);
    }
  }

  private void executeNode(VMNode node) {

    //System.out.println("Executing instruction: " + node.getInstruction() + " " + node.getValue());

    switch (node.getInstruction()) {
      case "nop":
        instructionPointer++;
        break;
      case "acc":
        accumulator += node.getValue();
        instructionPointer++;
        break;
      case "jmp":
        instructionPointer += node.getValue();
        break;
      default:
        throw new IllegalArgumentException("Operation " + node.getInstruction() + " is not supported.");
    }

    node.setVisited(true);

  }


}
