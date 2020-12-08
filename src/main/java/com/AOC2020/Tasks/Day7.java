package com.AOC2020.Tasks;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public @Data class Day7 extends AoCChallenge {

  private int task1Solution, task2Solution;

  public Day7(String overrideFileName) {
    super(overrideFileName);
  }

  public Day7(String overrideFileName, boolean oneNotTwo) {
    super(overrideFileName, oneNotTwo);
  }

  @Override
  protected void computeSolutionToTask1() {

    String[] inputData = fileReader.getInputDataAsLineArray();
    HashMap<String, BagNode> nodeTree = constructNodeTree(inputData);

    String targetNodeName = "shiny gold";
    List<BagNode> greatGrandParentNodes = nodeTree.get(targetNodeName).getGreatParentNodes();

    List<BagNode> listWithoutDuplicates = new ArrayList<>(
        new HashSet<>(greatGrandParentNodes));


    task1Solution = listWithoutDuplicates.size();

  }

  @Override
  protected void computeSolutionToTask2() {

    String[] inputData = fileReader.getInputDataAsLineArray();
    HashMap<String, BagNode> nodeTree = constructNodeTree(inputData);

    String targetNodeName = "shiny gold";

    int nestedBags = nodeTree.get(targetNodeName).getNestedChildrenIncludingSelf() - 1;

    task2Solution = nestedBags;

  }

  private HashMap<String, BagNode> constructNodeTree(String[] nodeData) {
    HashMap<String, BagNode> nodeTree = new HashMap<>();

    for (String inputLine : nodeData) {
      String[] splitInputLine = inputLine.split(" contain ");
      String[] childNodesStrings = splitInputLine[1].split(",");

      String nodeName = splitInputLine[0].substring(0, splitInputLine[0].length() - 5);

      BagNode parentNode = nodeTree.getOrDefault(nodeName, new BagNode(nodeName));
      nodeTree.put(nodeName, parentNode);

      if (childNodesStrings[0].equals("no other bags.")) {
        continue;
      }

      for (int i = 0; i < childNodesStrings.length; i++) {
        String[] childDataArray = childNodesStrings[i].strip().split(" ");

        int amount = Integer.parseInt(childDataArray[0]);
        String childNodeName = childDataArray[1] + " " + childDataArray[2];

        BagNode childNode = nodeTree.getOrDefault(childNodeName, new BagNode(childNodeName));
        nodeTree.put(childNodeName, childNode);

        parentNode.addChildNode(childNode, amount);
        childNode.addParentNode(parentNode);

      }

    }

    return nodeTree;
  }

  private class BagNode {

    private String name;

    private List<BagLink> childNodes = new ArrayList<>();
    private List<BagNode> parentNodes = new ArrayList<>();

    public BagNode(String name) {
      this.name = name;
    }

    public void addChildNode(BagNode childNode, int amount) {

      BagLink newLink = new BagLink(this, childNode, amount);
      childNodes.add(newLink);

    }

    public void addParentNode(BagNode parentNode) {
      parentNodes.add(parentNode);
    }

    public List<BagNode> getGreatParentNodes() {

      List<BagNode> tempList = new ArrayList<>();
      if (parentNodes.size() == 0) {
        return tempList;
      }
      else {
        for (BagNode parentNode : parentNodes) {
          tempList.addAll(parentNode.getGreatParentNodes());
        }
      }
      tempList.addAll(parentNodes);
      return tempList;
    }

    public int getNestedChildrenIncludingSelf() {

      int tempNestedChildren = 1;
      if (childNodes.size() == 0) {
        return 1;
      }
      else {
        for (BagLink childLinks : childNodes) {
          tempNestedChildren += childLinks.amount * childLinks.childNode.getNestedChildrenIncludingSelf();
        }
      }
      return tempNestedChildren;

    }

    public List<BagLink> getChildNodes() {
      return childNodes;
    }




  }

  private class BagLink {

    private BagNode parentNode;
    private BagNode childNode;

    private int amount;

    public BagLink(BagNode parent, BagNode child, int amount) {

      parentNode = parent;
      childNode = child;

      this.amount = amount;

    }

    public BagNode getChildNode() {
      return childNode;
    }
  }
}
