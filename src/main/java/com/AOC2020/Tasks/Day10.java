package com.AOC2020.Tasks;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public @Data class Day10 extends AoCChallenge{

  private int task1Solution;
  private long task2SolutionAsLong;

  public Day10(String overrideFileName) {
    super(overrideFileName);
  }

  public Day10(String overrideFileName, boolean oneNotTwo) {
    super(overrideFileName, oneNotTwo);
  }

  @Override
  protected void computeSolutionToTask1() {

    Integer[] inputData = fileReader.getInPutDataAsIntegerArray();

    AdapterGraph adapterGraph = new AdapterGraph(inputData);

    AdapterNode[] nodePath = new AdapterNode[adapterGraph.nodeNumber];
    int pathPointer = 0;

    AdapterNode currentNode = adapterGraph.startNode;
    System.out.print("Node Path:");
    while (currentNode != adapterGraph.endNode) {

      AdapterNode nextNode = currentNode.linkedAdapters.get(0);
      for (AdapterNode linkedNode : currentNode.linkedAdapters ) {
        if (linkedNode.value < nextNode.value) {
          nextNode = linkedNode;
        }
      }
      nodePath[pathPointer++] = currentNode;
      System.out.print(" " + nodePath[pathPointer - 1].id + " (" + nodePath[pathPointer -1].value + ") ");
      currentNode = nextNode;
    }
    nodePath[pathPointer] = adapterGraph.endNode;
    System.out.print("\n");

    int oneCount = 0;
    int threeCount = 0;
    for (int i = 0; i < nodePath.length - 1; i++) {
      if (nodePath[i + 1].value - nodePath[i].value == 1) {
        oneCount++;
      }
      else if (nodePath[i + 1].value - nodePath[i].value == 3) {
        threeCount++;
      }
    }

    task1Solution = oneCount * threeCount;
  }

  @Override
  protected void computeSolutionToTask2() {

    Integer[] inputData = fileReader.getInPutDataAsIntegerArray();

    AdapterGraph adapterGraph = new AdapterGraph(inputData);

    long totalPaths = adapterGraph.startNode.computePathValue(adapterGraph.endNode);

    task2SolutionAsLong = totalPaths;


  }

  public long getTask2SolutionAsLong() {
    return task2SolutionAsLong;
  }

  private class AdapterGraph {

    private AdapterNode startNode;
    private AdapterNode endNode;

    private int nodeNumber;

    private List<AdapterNode> listOfAllAdapters = new ArrayList<>();

    AdapterGraph (Integer[] adapterValues) {

      this.startNode = new AdapterNode(0,0);

      int highestNodeValue = Integer.MIN_VALUE;
      for (int i = 0; i < adapterValues.length; i++) {
        if (highestNodeValue < adapterValues[i]) {
          highestNodeValue = adapterValues[i];
        }
        listOfAllAdapters.add(new AdapterNode(i + 1, adapterValues[i]));
      }

      endNode = new AdapterNode(adapterValues.length + 1, highestNodeValue + 3);
      endNode.linkedAdapters.add(new AdapterNode(Integer.MAX_VALUE, Integer.MAX_VALUE));
      System.out.println("End Node, ID: " + endNode.id + " Value: " + endNode.value);

      listOfAllAdapters.add(startNode);
      listOfAllAdapters.add(endNode);

      // ------------------------- //

      for (AdapterNode fromNode : listOfAllAdapters) {
        for (AdapterNode toNode : listOfAllAdapters) {
          if (fromNode.id == toNode.id) {
            continue;
          }

          if (toNode.value - fromNode.value <= 3 && toNode.value - fromNode.value > 0 ) {
            fromNode.linkedAdapters.add(toNode);
          }
        }
      }
      nodeNumber = listOfAllAdapters.size();
    }




  }

  private class AdapterNode {

    private int id;
    private int value;

    private long pathValue;

    private List<AdapterNode> linkedAdapters = new ArrayList<>();

    public AdapterNode(int id, int value) {

      this.id = id;
      this.value = value;

      pathValue = -1;

    }

    private long computePathValue(AdapterNode targetNode) {

      if (this.id == targetNode.id) {
        System.out.println("Target Node found, returning...");
        return 1;
      }

      if (pathValue != -1) {
        return pathValue;
      }
      else {
        pathValue = 0;
        for (AdapterNode childNode : linkedAdapters) {
          pathValue += childNode.computePathValue(targetNode);
        }
        return pathValue;
      }
    }


  }


}
