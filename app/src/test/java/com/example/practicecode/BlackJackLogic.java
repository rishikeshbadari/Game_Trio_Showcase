package com.example.practicecode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class BlackJackLogic {
    private List<Integer> deck;
    private List<Integer> playerHand;
    private List<Integer> dealerHand;
    private int playerScore;
    private int dealerScore;
    private int bustCount;
    private int[] suits = { R.drawable.club, R.drawable.diamond, R.drawable.heart, R.drawable.spade };
    private HashSet<HashMap<Integer, Integer>> set = new HashSet<>();

    public void startNewGame() {
        deck = new ArrayList<>();
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            deck.add(i);
        }
        playerScore = 0;
        dealerScore = 0;
        hit();
        hit();
        dealCardToDealer();
    }

    protected void hit() {
        int randomIndex = new Random().nextInt(deck.size());
        int cardValue = deck.get(randomIndex);
        deck.remove(randomIndex);
        playerHand.add(cardValue);
        int score = getCardScore(cardValue, playerScore);
        playerScore += score;
        if (score == 11 && playerScore > 21) {
            playerScore -= 10;
        }
        if (playerScore > 21) {
            bustCount++;
        }
        int randomSuitIndex = new Random().nextInt(suits.length);
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        hashmap.put(randomSuitIndex, cardValue);
    }

    protected void dealCardToDealer() {
        int randomIndex = new Random().nextInt(deck.size());
        int cardValue = deck.get(randomIndex);
        deck.remove(randomIndex);
        dealerHand.add(cardValue);
        dealerScore += getCardScore(cardValue, dealerScore);
    }

    private int getCardScore(int cardValue, int currentScore) {
        if (cardValue == 1) {
            return (currentScore + 11) <= 21 ? 11 : 1;
        } else if (cardValue >= 11 && cardValue <= 13) {
            return 10;
        } else {
            return cardValue;
        }
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getDealerScore() {
        return dealerScore;
    }

    public int getBustCount() {
        return bustCount;
    }

    public boolean isPlayerBusted() {
        return playerScore > 21;
    }

    public boolean isDealerBusted() {
        return dealerScore > 21;
    }

    public boolean isPlayerWin() {
        System.out.println(playerScore);
        System.out.println(dealerScore);
        return !isPlayerBusted() && (isDealerBusted() || dealerScore < playerScore);
    }

    public boolean isDealerWin() {
        System.out.println(playerScore);
        System.out.println(dealerScore);
        return !isDealerBusted() && (isPlayerBusted() || playerScore < dealerScore);
    }

    public boolean isTie() {
        return playerScore == dealerScore;
    }

    public boolean isBlackjack() {
        return playerScore == 21 && playerHand.size() == 2;
    }

    public List<Integer> getPlayerHand() {
        return playerHand;
    }
    public boolean isGameOver() {
        return bustCount >= 3;
    }


    public List<Integer> getDealerHand() {
        return dealerHand;
    }
    public void addToPlayerScore(int score) {
        playerScore += score;
    }
    public void setPlayerScore(int score) {
        playerScore = score;
    }
    public void setDealerScore(int score) {
        dealerScore = score;
    }
    public void addToDealerScore(int score) {
        dealerScore += score;
    }
    public void addToBustCount() {
        if (isPlayerBusted()) {
            bustCount++;
        }
    }

    public boolean isEndGame() {
        return isPlayerBusted() || isDealerBusted() || isDealerWin() || isPlayerWin();
    }
}