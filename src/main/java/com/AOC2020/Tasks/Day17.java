package com.AOC2020.Tasks;

import lombok.Data;

import java.util.*;

public @Data class Day17 extends AoCChallenge {

  private int task1Solution, task2Solution;

  public Day17(String overrideFileName) {
    super(overrideFileName);
  }

  public Day17(String overrideFileName, boolean oneNotTwo) {
    super(overrideFileName, oneNotTwo);
  }

  @Override
  protected void computeSolutionToTask1() {

    String[] inputData = fileReader.getInputDataAsLineArray();
    ConwayCube conwayCube = new ConwayCube(inputData);
    System.out.println("Total active nodes after initialisation: " + conwayCube.getActiveNodes());

    for (int i = 0; i < 6; i++) {
      conwayCube.computeNextState();
      //System.out.println("Total active nodes after " + (i + 1) + " cycles: " + conwayCube.getActiveNodes());
    }


    task1Solution = conwayCube.getActiveNodes();

  }

  @Override
  protected void computeSolutionToTask2() {

    String[] inputData = fileReader.getInputDataAsLineArray();
    ConwayCube conwayCube = new ConwayCube(inputData, true);
    System.out.println("Total active nodes after initialisation: " + conwayCube.getActiveNodes());

    for (int i = 0; i < 6; i++) {
      conwayCube.computeNextState();
      //System.out.println("Total active nodes after " + (i + 1) + " cycles: " + conwayCube.getActiveNodes());
    }


    task2Solution = conwayCube.getActiveNodes();

  }

  private class ConwayCube {

    private HashMap<CubeCoordinate, Boolean> currentCubeStates = new HashMap<>();
    private HashMap<CubeCoordinate, Boolean> futureCubeStates = new HashMap<>();

    public ConwayCube(String[] initialStateStrings) {

      int z = 0;
      for (int x = 0; x < initialStateStrings.length; x++) {
        for (int y = 0; y < initialStateStrings[x].length(); y++) {
          if (initialStateStrings[x].charAt(y) == '#') {
            //System.out.println("Initial state activation at: (" + x + ", " + y + ", " + z + ")");
            currentCubeStates.put(new CubeCoordinate(x, y, z), true);
          }
        }
      }
    }

    public ConwayCube(String[] initialStateStrings, boolean fourDimensions) {

      int z = 0;
      int w = 0;
      if (fourDimensions) {
        for (int x = 0; x < initialStateStrings.length; x++) {
          for (int y = 0; y < initialStateStrings[x].length(); y++) {
            if (initialStateStrings[x].charAt(y) == '#') {
              //System.out.println("Initial state activation at: (" + x + ", " + y + ", " + z + ")");
              currentCubeStates.put(new CubeCoordinate(x, y, z, w), true);
            }
          }
        }
      }
      else {
        for (int x = 0; x < initialStateStrings.length; x++) {
          for (int y = 0; y < initialStateStrings[x].length(); y++) {
            if (initialStateStrings[x].charAt(y) == '#') {
              //System.out.println("Initial state activation at: (" + x + ", " + y + ", " + z + ")");
              currentCubeStates.put(new CubeCoordinate(x, y, z), true);
            }
          }
        }
      }

    }

    void computeNextState() {

      for (CubeCoordinate cubeCoordinate : computePossiblyActiveCoordinates()) {
        int activeNeighbours = computeNumberOfActiveNeighbours(cubeCoordinate);
        if (currentCubeStates.getOrDefault(cubeCoordinate, false)) {
          if (activeNeighbours < 2 || activeNeighbours >= 4) {
            futureCubeStates.put(cubeCoordinate, false);
          }
          else {
            futureCubeStates.put(cubeCoordinate, true);
          }
        }
        else {
          if (activeNeighbours == 3 ) {
            futureCubeStates.put(cubeCoordinate, true);
          }
          else {
            futureCubeStates.put(cubeCoordinate, false);
          }

        }
      }

      currentCubeStates = futureCubeStates;
      futureCubeStates = new HashMap<>();

    }

    int getActiveNodes() {
      int activeCubes = 0;
      for (boolean value: currentCubeStates.values()) {
        if (value) {
          activeCubes++;
        }
      }
      return activeCubes;
    }


    private Set<CubeCoordinate> computePossiblyActiveCoordinates() {

      Set<CubeCoordinate> possibleActiveCoordinates = new HashSet<>();
      for (CubeCoordinate cubeCoordinate : currentCubeStates.keySet()) {
        possibleActiveCoordinates.addAll(cubeCoordinate.getNeighbours());
      }
      return possibleActiveCoordinates;
    }

    private int computeNumberOfActiveNeighbours(CubeCoordinate currentCubeCoordinate) {

      int activeNeighbours = 0;
      for (CubeCoordinate neighbourCubeCoordinate : currentCubeCoordinate.getNeighbours()) {
        if (currentCubeStates.getOrDefault(neighbourCubeCoordinate, false)) {
          activeNeighbours++;
        }
      }
      //System.out.println("(" + currentCubeCoordinate.coordinates[0] + ", " + currentCubeCoordinate.coordinates[1] + ", " + currentCubeCoordinate.coordinates[2] + ") Active Neighbours: " + activeNeighbours);
      return activeNeighbours;
    }

  }

  private class CubeCoordinate {

    private final int[] coordinates;

    public CubeCoordinate(int x, int y, int z) {
      coordinates = new int[] {x, y, z};
    }

    public CubeCoordinate(int x, int y, int z, int w) {
      coordinates = new int[] {x, y, z, w};
    }

    List<CubeCoordinate> getNeighbours() {

      if (coordinates.length == 3) {
        return getNeighbours3D();
      }
      else {
        return getNeighbours4D();
      }

    }

    private List<CubeCoordinate> getNeighbours3D() {

      List<CubeCoordinate> neighbours = new ArrayList<>();

      int neighbourXCoordinate;
      int neighbourYCoordinate;
      int neighbourZCoordinate;
      int[] coordinateDelta = new int[] {-1, 0 ,1};
      for (int x : coordinateDelta) {
        neighbourXCoordinate = coordinates[0] + x;
        for (int y : coordinateDelta) {
          neighbourYCoordinate = coordinates[1] + y;
          for (int z : coordinateDelta) {
            neighbourZCoordinate = coordinates[2] + z;
            if (!(x == 0 && y == 0 && z == 0)) {
              neighbours.add(new CubeCoordinate(neighbourXCoordinate, neighbourYCoordinate, neighbourZCoordinate));
              //System.out.println("(" + coordinates[0] + ", " + coordinates[1] + ", " + coordinates[2] + ") :: (" +
              // neighbourXCoordinate + ", " + neighbourYCoordinate + ", " + neighbourZCoordinate +
              // ") Neighbour Count: " + neighbours.size());
            }
          }
        }
      }

      return neighbours;
    }

    private List<CubeCoordinate> getNeighbours4D() {

      List<CubeCoordinate> neighbours = new ArrayList<>();

      int neighbourXCoordinate;
      int neighbourYCoordinate;
      int neighbourZCoordinate;
      int neighbourWCoordinate;
      int[] coordinateDelta = new int[] {-1, 0 ,1};
        for (int x : coordinateDelta) {
          neighbourXCoordinate = coordinates[0] + x;
          for (int y : coordinateDelta) {
            neighbourYCoordinate = coordinates[1] + y;
            for (int z : coordinateDelta) {
              neighbourZCoordinate = coordinates[2] + z;
              for (int w : coordinateDelta) {
                neighbourWCoordinate = coordinates[3] + w;
              if (!(x == 0 && y == 0 && z == 0 && w == 0)) {
                neighbours.add(new CubeCoordinate(neighbourXCoordinate, neighbourYCoordinate, neighbourZCoordinate, neighbourWCoordinate));
                //System.out.println("(" + coordinates[0] + ", " + coordinates[1] + ", " + coordinates[2] +
                // coordinates[3] + ") :: (" + neighbourXCoordinate + ", " + neighbourYCoordinate + ", " +
                // neighbourZCoordinate + neighbourWCoordinate + ") Neighbour Count: " + neighbours.size());
              }
            }
          }
        }
      }

      return neighbours;
    }

    @Override
    public boolean equals(Object another) {
      if (another == this) {
        return true;
      }
      if (another == null) {
        return false;
      }
      if (another.getClass() != this.getClass()) {
        return false;
      }
      CubeCoordinate cubeCoordinate = (CubeCoordinate) another;
      return Arrays.equals(this.coordinates, cubeCoordinate.coordinates);
    }

    @Override
    public int hashCode() {
      return Arrays.hashCode(this.coordinates);
    }

  }

}
