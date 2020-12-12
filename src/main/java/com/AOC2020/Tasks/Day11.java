package com.AOC2020.Tasks;

import lombok.Data;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public @Data class Day11 extends AoCChallenge {

  private int task1Solution, task2Solution;

  public Day11(String overrideFileName) {
    super(overrideFileName);
  }

  public Day11(String overrideFileName, boolean oneNotTwo) {
    super(overrideFileName, oneNotTwo);
  }

  @Override
  protected void computeSolutionToTask1() {

    String[] inputData = fileReader.getInputDataAsLineArray();

    ChairArrangement chairArrangement = new ChairArrangement(inputData, true);

    String currentState = chairArrangement.stateString;
    String previousState = "";

    int numberOfCycles = 0;

    while (!currentState.equals(previousState)) {
      chairArrangement.advanceState(true);

      previousState = currentState;
      currentState = chairArrangement.stateString;

      numberOfCycles++;
    }

    System.out.println("Seating stable after " + numberOfCycles + " cycles.");
    System.out.println(chairArrangement.toString());

    task1Solution = chairArrangement.numberOfOccupiedSeats;

  }

  @Override
  protected void computeSolutionToTask2() {

    String[] inputData = fileReader.getInputDataAsLineArray();

    ChairArrangement chairArrangement = new ChairArrangement(inputData, false);

    //chairArrangement.advanceState(false);

    String currentState = chairArrangement.stateString;
    String previousState = "";

    int numberOfCycles = 0;

    while (!currentState.equals(previousState)) {
      chairArrangement.advanceState(false);

      previousState = currentState;
      currentState = chairArrangement.stateString;
      System.out.println(chairArrangement.toString());
      System.out.println("-------------------------");

      numberOfCycles++;
    }

    System.out.println("Seating stable after " + numberOfCycles + " cycles.");
    System.out.println(chairArrangement.toString());

    task2Solution = chairArrangement.numberOfOccupiedSeats;

  }


  private class ChairArrangement {

    private HashMap<Integer, ChairNode> chairMap = new HashMap<>();

    int totalNumberOfSeats;
    int numberOfOccupiedSeats = 0;

    private String stateString;

    int xSize;
    int ySize;

    public ChairArrangement(String[] inputData, boolean task1) {

      totalNumberOfSeats = 0;
      ChairNode adjacentNode;
      ChairNode currentChairNode;

      ySize = inputData.length;
      xSize = inputData[0].length();

      for (int i = 0; i < ySize; i++) {
        for (int j = 0; j < xSize; j++) {
          if (inputData[i].charAt(j) == 'L') {
            //System.out.println("Chair Found at (" + i + "," + j + ")");
            currentChairNode = new ChairNode(j,i);
            chairMap.put(i * xSize + j, currentChairNode);
            totalNumberOfSeats++;

            if (task1) {

              if (j != 0) {

                adjacentNode = chairMap.getOrDefault(i * xSize + (j - 1), null);
                if (adjacentNode != null) {
                  currentChairNode.adjacentChairNodes.add(adjacentNode);
                  adjacentNode.adjacentChairNodes.add(currentChairNode);
                }

                adjacentNode = chairMap.getOrDefault((i - 1) * xSize + (j - 1), null);
                if (adjacentNode != null) {
                  currentChairNode.adjacentChairNodes.add(adjacentNode);
                  adjacentNode.adjacentChairNodes.add(currentChairNode);
                }
              }

              if (j != (xSize - 1)) {

                adjacentNode = chairMap.getOrDefault(i * xSize + (j + 1), null);
                if (adjacentNode != null) {
                  currentChairNode.adjacentChairNodes.add(adjacentNode);
                  adjacentNode.adjacentChairNodes.add(currentChairNode);
                }

                adjacentNode = chairMap.getOrDefault((i - 1) * xSize + (j + 1), null);
                if (adjacentNode != null) {
                  currentChairNode.adjacentChairNodes.add(adjacentNode);
                  adjacentNode.adjacentChairNodes.add(currentChairNode);
                }

              }

              adjacentNode = chairMap.getOrDefault((i - 1) * xSize + j, null);
              if (adjacentNode != null) {
                currentChairNode.adjacentChairNodes.add(adjacentNode);
                adjacentNode.adjacentChairNodes.add(currentChairNode);
              }
            }
            else {

              //Going up
              int xCoordinate = j;
              int yCoordinate = i - 1;

              while(inRange(yCoordinate, xCoordinate)) {

                adjacentNode = chairMap.getOrDefault(yCoordinate * xSize + xCoordinate, null);
                if (adjacentNode == null) {
                  yCoordinate -= 1;
                  continue;
                }
                else {
                  currentChairNode.adjacentChairNodes.add(adjacentNode);
                  adjacentNode.adjacentChairNodes.add(currentChairNode);
                  break;
                }

              }

              //Going up and right
              xCoordinate = j + 1;
              yCoordinate = i - 1;

              while(inRange(yCoordinate, xCoordinate)) {

                adjacentNode = chairMap.getOrDefault(yCoordinate * xSize + xCoordinate, null);
                if (adjacentNode == null) {
                  xCoordinate += 1;
                  yCoordinate -= 1;
                  continue;
                }
                else {
                  currentChairNode.adjacentChairNodes.add(adjacentNode);
                  adjacentNode.adjacentChairNodes.add(currentChairNode);
                  break;
                }

              }

              //Going right
              /*xCoordinate = j + 1;
              yCoordinate = i;

              while(inRange(yCoordinate, xCoordinate)) {



                adjacentNode = chairMap.getOrDefault(yCoordinate * xSize + xCoordinate, null);
                if (adjacentNode == null) {
                  xCoordinate += 1;
                  continue;
                }
                else {
                  currentChairNode.adjacentChairNodes.add(adjacentNode);
                  adjacentNode.adjacentChairNodes.add(currentChairNode);
                  break;
                }

              }*/

              //Going right and down
              /*xCoordinate = j + 1;
              yCoordinate = i + 1;

              while(inRange(yCoordinate, xCoordinate)) {

                adjacentNode = chairMap.getOrDefault(yCoordinate * xSize + xCoordinate, null);
                if (adjacentNode == null) {
                  xCoordinate += 1;
                  yCoordinate += 1;
                  continue;
                }
                else {
                  currentChairNode.adjacentChairNodes.add(adjacentNode);
                  adjacentNode.adjacentChairNodes.add(currentChairNode);
                  break;
                }

              }*/

              //Going down
              /*xCoordinate = j;
              yCoordinate = i + 1;

              while(inRange(yCoordinate, xCoordinate)) {

                adjacentNode = chairMap.getOrDefault(yCoordinate * xSize + xCoordinate, null);
                if (adjacentNode == null) {
                  yCoordinate += 1;
                  continue;
                }
                else {
                  currentChairNode.adjacentChairNodes.add(adjacentNode);
                  adjacentNode.adjacentChairNodes.add(currentChairNode);
                  break;
                }

              }
*/
              //Going down and left
              /*xCoordinate = j - 1;
              yCoordinate = i + 1;

              while(inRange(yCoordinate, xCoordinate)) {



                adjacentNode = chairMap.getOrDefault(yCoordinate * xSize + xCoordinate, null);
                if (adjacentNode == null) {
                  xCoordinate -= 1;
                  yCoordinate += 1;
                  continue;
                }
                else {
                  currentChairNode.adjacentChairNodes.add(adjacentNode);
                  adjacentNode.adjacentChairNodes.add(currentChairNode);
                  break;
                }

              }*/

              //Going left
              xCoordinate = j - 1;
              yCoordinate = i;

              while(inRange(yCoordinate, xCoordinate)) {

                adjacentNode = chairMap.getOrDefault(yCoordinate * xSize + xCoordinate, null);
                if (adjacentNode == null) {
                  xCoordinate -= 1;
                  continue;
                }
                else {
                  currentChairNode.adjacentChairNodes.add(adjacentNode);
                  adjacentNode.adjacentChairNodes.add(currentChairNode);
                  break;
                }

              }

              //Going left and up
              xCoordinate = j - 1;
              yCoordinate = i - 1;

              while(inRange(yCoordinate, xCoordinate)) {

                adjacentNode = chairMap.getOrDefault(yCoordinate * xSize + xCoordinate, null);
                if (adjacentNode == null) {
                  xCoordinate -= 1;
                  yCoordinate -= 1;
                  continue;
                }
                else {
                  currentChairNode.adjacentChairNodes.add(adjacentNode);
                  adjacentNode.adjacentChairNodes.add(currentChairNode);
                  break;
                }

              }
            }
          }

        }
      }
      computeStateString();
    }



    public void advanceState(boolean task1) {

      numberOfOccupiedSeats = 0;

      for (int key : chairMap.keySet()) {
        chairMap.get(key).computeNextState(task1);
      }

      for (int key : chairMap.keySet()) {
        chairMap.get(key).advanceState();
        if (chairMap.get(key).currentState) {
          numberOfOccupiedSeats++;
        }
      }
      computeStateString();

    }

    public String toString() {

      String seatingString = "";
      for (int i = 0; i < ySize; i++) {

        for (int j = 0; j < xSize; j++) {
          ChairNode node = chairMap.getOrDefault(i * xSize + j, null);
          if(node == null) {
            seatingString += ".";
            continue;
          }

          if(node.currentState) {
              seatingString += "#";
          }
          else {
            seatingString += "L";
          }

        }
        seatingString += "\n";
      }

      seatingString += "Total Number of seats: " + totalNumberOfSeats + ", Occupied Seats: " + numberOfOccupiedSeats + ".";
      return seatingString;

    }

    private void computeStateString() {

      stateString = "";
      for (int i = 0; i < xSize * ySize; i++) {
        ChairNode node = chairMap.getOrDefault( i, null);
        if(node == null) {
          stateString += ".";
          continue;
        }

        if(node.currentState) {
          stateString += "#";
        }
        else {
          stateString += "L";
        }
      }

    }

    private boolean inRange(int i, int j) {

      if (i >= 0 &&  i < ySize) {
        if (j >= 0 &&  j < xSize) {
          return true;
        }
      }
      return false;
    }
  }

  private class ChairNode  {

    boolean currentState;
    boolean nextState;

    int xPosition;
    int yPosition;

    private List<ChairNode> adjacentChairNodes = new ArrayList<>();

    public ChairNode(int x, int y) {
      currentState = false;

      xPosition = x;
      yPosition = y;
    }


    public void advanceState() { currentState = nextState;}

    public void computeNextState(boolean task1) {

      int adjacentOccupiedSeats = 0;
      for (ChairNode adjacentChairNode : adjacentChairNodes) {
        //System.out.println("Node (" + xPosition + ", " + yPosition + ") is adjacent to (" + adjacentChairNode.xPosition + ", " + adjacentChairNode.yPosition + ").");
        if (adjacentChairNode.currentState) {
          adjacentOccupiedSeats++;
        }
      }

      //System.out.println("Node (" + xPosition + ", " + yPosition + ") has " + adjacentChairNodes.size() + " adjacent nodes.");

      if (adjacentOccupiedSeats == 0) {
        nextState = true;
      }
      else if (adjacentOccupiedSeats >= 4 && task1) {
        nextState = false;
      }
      else if (adjacentOccupiedSeats >= 5) {
        nextState = false;
      }
      else nextState = currentState;

    }




  }

}
