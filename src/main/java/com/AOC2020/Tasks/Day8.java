package com.AOC2020.Tasks;

import com.AOC2020.Utilities.VMNode;
import com.AOC2020.Utilities.VirtualMachine;
import lombok.Data;

public @Data class Day8 extends AoCChallenge {

  private int task1Solution, task2Solution;

  public Day8(String overrideFileName) {
    super(overrideFileName);
  }

  public Day8(String overrideFileName, boolean oneNotTwo) {
    super(overrideFileName, oneNotTwo);
  }

  @Override
  protected void computeSolutionToTask1() {

    String[] inputData = fileReader.getInputDataAsLineArray();
    VMNode[] instructions = new VMNode[inputData.length];

    for (int i = 0; i < inputData.length; i++) {
      String[] data = inputData[i].split(" ");
      instructions[i] = new VMNode(data[0].strip(), Integer.parseInt(data[1]));
    }

    VirtualMachine virtualMachine = new VirtualMachine(instructions);

    virtualMachine.executeProgram();

    task1Solution = virtualMachine.getAccumulator();
  }

  @Override
  protected void computeSolutionToTask2() {

    String[] inputData = fileReader.getInputDataAsLineArray();
    VMNode[] originalInstructions = new VMNode[inputData.length];
    VMNode[] instructionsCopy = new VMNode[inputData.length];

    for (int i = 0; i < inputData.length; i++) {
      String[] data = inputData[i].split(" ");
      VMNode instruction = new VMNode(data[0].strip(), Integer.parseInt(data[1]));
      originalInstructions[i] = instruction;
      instructionsCopy[i] = instruction;
    }

    VirtualMachine virtualMachine = new VirtualMachine(originalInstructions);

    for (int i = 0; i < originalInstructions.length; i++) {

      if (originalInstructions[i].getInstruction().equals("jmp")) {
        instructionsCopy[i] = new VMNode("nop", originalInstructions[i].getValue());
      }
      else if (originalInstructions[i].getInstruction().equals("nop")) {
        instructionsCopy[i] = new VMNode("jmp", originalInstructions[i].getValue());
      }
      else {
        continue; }

      virtualMachine.reset();
      virtualMachine.setInstructionSet(instructionsCopy);
      virtualMachine.executeProgram();

      if (virtualMachine.isLooping()) {
        if (originalInstructions[i].getInstruction().equals("jmp")) {
          instructionsCopy[i] = new VMNode("jmp", originalInstructions[i].getValue());
        }
        else if (originalInstructions[i].getInstruction().equals("nop")) {
          instructionsCopy[i] = new VMNode("nop", originalInstructions[i].getValue());
        }
      }
      else {
        break;
      }
    }


    task2Solution = virtualMachine.getAccumulator();

  }



}
