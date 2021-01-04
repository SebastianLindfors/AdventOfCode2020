package com.AOC2020.Tasks;

import lombok.Data;

import java.util.HashMap;

public @Data class Day15 extends AoCChallenge {

  private int task1Solution, task2Solution;

  public Day15(String overrideFileName) {
    super(overrideFileName);
  }

  public Day15(String overrideFileName, boolean oneNotTwo) {
    super(overrideFileName, oneNotTwo);
  }

  @Override
  protected void computeSolutionToTask1() {

    int gameLength = 2020;
    Integer[] startSequence = fileReader.getInPutDataAsIntegerArray();
    MemoryGame memoryGame = new MemoryGame(startSequence, gameLength);
    memoryGame.playFullGame();

    task1Solution = memoryGame.gameHistory[gameLength];

  }

  @Override
  protected void computeSolutionToTask2() {

    int gameLength = 30000000;
    Integer[] startSequence = fileReader.getInPutDataAsIntegerArray();
    MemoryGame memoryGame = new MemoryGame(startSequence, gameLength);
    memoryGame.playFullGame();

    task2Solution = memoryGame.gameHistory[gameLength];

  }


  private class MemoryGame {

    private HashMap<Integer, Integer[]> lastMentioned = new HashMap<>();

    private Integer roundNumber = 0;
    private Integer gameLength;
    private Integer[] gameHistory;


    public MemoryGame(Integer[] startSequence,  int gameLength) {

      this.gameLength = gameLength;
      gameHistory = new Integer[gameLength + 1];

      gameHistory[0] = -1; //Should never be accessed.

      for (int i = 0; i < startSequence.length; i++) {
        gameHistory[i + 1] = startSequence[i];
        updateLastMentions(i + 1, startSequence[i]);
      }

      roundNumber = startSequence.length + 1;
    }

    public void playFullGame() {
      while(roundNumber <= gameLength) {
        playNextRound();
      }
    }

    private void playNextRound() {

      Integer lastRoundValue = gameHistory [roundNumber - 1];
      Integer[] lastRoundLastMentions = lastMentioned.get(lastRoundValue);

      Integer thisRoundValue;

      if (lastRoundLastMentions[1] == -1) {
        thisRoundValue = 0;
      }
      else {
        thisRoundValue = lastRoundLastMentions[0] - lastRoundLastMentions[1];
      }

      gameHistory[roundNumber] = thisRoundValue;
      updateLastMentions(roundNumber, thisRoundValue);

      roundNumber++;

    }

    private void updateLastMentions(int roundNumber, int value) {

      Integer[] thisRoundLastMentioned = lastMentioned.getOrDefault(value, new Integer[] {-1, -1});
      if (thisRoundLastMentioned[0] != -1) {
        thisRoundLastMentioned[1] = thisRoundLastMentioned[0];
        thisRoundLastMentioned[0] = roundNumber;
      }
      else {
        thisRoundLastMentioned[0] = roundNumber;
      }
      lastMentioned.put(value, thisRoundLastMentioned);


    }



  }


}
